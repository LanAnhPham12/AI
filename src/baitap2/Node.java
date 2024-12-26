package baitap2;

import java.util.ArrayList;
import java.util.List;

public class Node {
	int n;
	List<Integer> state;
	List<Node> neighbours;

	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<>();
		this.neighbours = new ArrayList<>();

	}

	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = state;
		this.neighbours = new ArrayList<>();

	}

	public void addNeighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}
	
	
	public boolean isValid(List<Integer> state) {
		if (state.size() == 1) {
			return true;
		}

		for (int i = 0; i < state.size() - 1; i++) {
			for (int j = i + 1; j < state.size(); j++) {
				if (state.get(i) == state.get(j) || Math.abs(state.get(i) - state.get(j)) == Math.abs(i - j)) {
					return false;
				}
			}
		}

		return true;
	}

	private List<Integer> place(int x) {
		List<Integer> newState = new ArrayList<>(state);
		newState.add(x);

		if (isValid(newState)) {
			return newState;
		} else {
			return null;
		}
	}

	public List<Node> getNeighbours() {
		if (state.size() == n) {
			return null;
		}

		List<Node> neighbours = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			List<Integer> newState = place(i);
			if (newState != null) {
				Node neighbour = new Node(n, newState);
				neighbours.add(neighbour);
			}
		}

		return neighbours;
	}

	public static void main(String[] args) {

	}
}
