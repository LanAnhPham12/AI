package baitap2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import baitap2.Node;
public class BFS {

	  public Node bfsUsingQueue(Node initial, int goal) {
		  
	        Node root = initial;
	        Queue<Node> queue = new LinkedList<Node>();
	        queue.add(root);

	        while (!queue.isEmpty()) {
	            Node node = queue.poll();

	            if (node.state.size() == goal) {
	            	node=root;
	                break;
	            }

	            for (Node neighbour : node.getNeighbours()) {
	                queue.add(neighbour);
	            }
	        }
	        return root;
	    }
}


