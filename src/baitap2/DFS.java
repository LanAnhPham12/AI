package baitap2;

import java.util.Stack;

public class DFS {

	 public Node dfsUsingStack(Node initial, int goal) {
	        Node root = initial;
	        Stack<Node> stack = new Stack<>();
	        stack.push(root);

	        while (!stack.isEmpty()) {
	            Node node = stack.pop();

	            if (node.state.size() == goal) {
	                node=root;
	                break;
	            }

	            for (Node neighbour : node.getNeighbours()) {
	                stack.push(neighbour);
	            }
	        }
	        return root;
	    }

	  
}
