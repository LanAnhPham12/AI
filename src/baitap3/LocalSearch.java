package baitap3;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class LocalSearch {

	// tổng xung đột ngang trong một node
	public int checkHorizontal(Node node) {
		int count = 0;

		int n = node.n;
		List<Integer> state = node.state;

		for (int i = 0; i < n; i++) {
			// Check if there's a neighbor with the same state except for one element
			List<Integer> neighborState = new ArrayList<>(state);
			neighborState.set(i, 1 - state.get(i)); // Flip the value

			if (node.state.equals(neighborState)) {
				count++;
			}
		}

		return count;

	}

	// tổng xung đột chéo trong một node
	public int checkDiagonal(Node node) {
		int count = 0;
		    int n = node.n;
		    List<Integer> state = node.state;

		    for (int i = 0; i < n; i++) {
		        for (int j = 0; j < n; j++) {
		            if (i != j) {
		                // Check if there's a neighbor with the same state except for two elements
		                List<Integer> neighborState = new ArrayList<>(state);
		                neighborState.set(i, 1 - state.get(i)); // Flip the value of the first element
		                neighborState.set(j, 1 - state.get(j)); // Flip the value of the second element

		                if (node.state.equals(neighborState)) {
		                    count++;
		                }
		            }
		        }
		    }

		    return count;
		

	}

	// hàm đánh giá mức độ hợp lý của một node, trả về tổng xung đột ngang và chéo
	public int heuristic(Node node) {
		List<Integer> state = node.state;
	    int heuristicValue = 0;

	    for (Integer element : state) {
	        heuristicValue += element;
	    }

	    return heuristicValue;
	}

	// thay đổi vị trí quân hậu của node tại cột y (đang ở bất kỳ dòng nào) thành
	// dòng x, trả về heuristic của node mới
	public int tryMovingOneQueen(Node node, int x, int y) {

		
		    List<Integer> currentState = new ArrayList<>(node.state); // Copy the current state
		    int n = node.n;

		    // Ensure that (x, y) is within the bounds of the board
		    if (x < 0 || x >= n || y < 0 || y >= n) {
		        return Integer.MIN_VALUE; // Return a very low value for an invalid move
		    }

		    // Check if moving the queen results in a conflict
		    for (int i = 0; i < n; i++) {
		        if (i == x) {
		            continue; // Skip the current row
		        }

		        // Check for conflicts in the same column or diagonals
		        if (currentState.get(i) == y || Math.abs(i - x) == Math.abs(currentState.get(i) - y)) {
		            return Integer.MIN_VALUE; // Return a very low value for a conflicting move
		        }
		    }

		    // If the move is valid and does not lead to conflicts, calculate the heuristic value
		    // This could be based on the number of queens attacking each other or any other criterion.
		    // A smaller heuristic value is typically better in N-Queens problems.

		    int newHeuristicValue = calculateHeuristic(currentState, x, y);
		    return newHeuristicValue;
		}

		private int calculateHeuristic(List<Integer> state, int x, int y) {
			 int heuristicValue = 0;
			    int n = state.size();

			    // Count the number of attacks in the current state
			    for (int i = 0; i < n; i++) {
			        if (i == x) {
			            continue; // Skip the queen that was moved
			        }

			        int queenY = state.get(i);

			        // Check for conflicts in the same column or diagonals
			        if (queenY == y || Math.abs(i - x) == Math.abs(queenY - y)) {
			            heuristicValue++; // Increment the heuristic for each attack
			        }
			    }

			    return heuristicValue;

	}

	// tạo tất cả các neighbour node của node đang xét, đánh giá các neighbour node
	// này, nếu có nhiều node có cùng một kết quả đánh giá, chỉ cần lưu lại một node
	// trong chúng. Trả về một SortedMap trong đó key là kết quả đánh giá, value là
	// node mới.
	public SortedMap<Integer, Node> generateNeighbours(Node node) {

		 SortedMap<Integer, Node> neighbors = new TreeMap<>();
		    int n = node.n;

		    for (int x = 0; x < n; x++) {
		        for (int y = 0; y < n; y++) {
		            if (x != node.n) {
		                // Generate a neighbor by moving the queen from node.x to (x, y)
		                List<Integer> neighborState = new ArrayList<>(node.state);
		                neighborState.set(node.n, y); // Move the queen

		                // Calculate the heuristic value for the neighbor
		                int heuristicValue = calculateHeuristic(neighborState,x,y);

		                // Add the neighbor to the sorted map with the heuristic value as the key
		                neighbors.put(heuristicValue, new Node( x, neighborState));
		            }
		        }
		    }

		    return neighbors;
	}

	public void run() {
		Node initial = new Node(8); // hoặc 4,5,6,7
		if (heuristic(initial) == 0) // goal
		{
			System.out.println(initial.state);
			return;
		}
		System.out.println("Initial state is: " + initial.state);
		Node node = initial;
		SortedMap<Integer, Node> neighbours = generateNeighbours(node);
		Integer bestHeuristic = neighbours.firstKey();
		while (bestHeuristic < heuristic(node)) {
			node = neighbours.get(bestHeuristic);
			neighbours = generateNeighbours(node);
			bestHeuristic = neighbours.firstKey();
		}
		if (heuristic(node) == 0) {
			System.out.println("Goal is: " + node.state);
		} else
			System.out.println("Cannot find goal state! Best state is: " + node.state);
	}

	public static void main(String[] args) {
		LocalSearch localS = new LocalSearch();
		localS.run();
	}

}
