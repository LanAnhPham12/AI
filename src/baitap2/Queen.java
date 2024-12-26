package baitap2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//usual way
public class Queen {

	private int n;
    private Node goal;

    public Queen(int n) {
        this.n = n;
    }

    public void dfs() {
        Node root = new Node(n);
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.state.size() == n) {
                this.goal = node;
                break;
            }

            for (Node neighbour : node.getNeighbours()) {
                stack.push(neighbour);
            }
        }
    }

    public void bfs() {
        Node root = new Node(n);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.state.size() == n) {
                this.goal = node;
                break;
            }

            for (Node neighbour : node.getNeighbours()) {
                queue.add(neighbour);
            }
        }
    }

    public void printSolution() {
        if (goal == null) {
            System.out.println("Can't find solution");
            return;
        }

        System.out.println("Path:");
        for (int i = 0; i < n; i++) {
            System.out.print(goal.state.get(i) + " ");
        }
        System.out.println();
    }
    
    
   
}


  

