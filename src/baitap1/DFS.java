package week1;

import java.util.List;
import java.util.Stack;

public class DFS {

	public void dfs(Node initial, int goal) {
		Node start = initial;
		if (start.getState() == goal) {
			System.out.println(start);
		} else {
			Stack<Node> stack = new Stack<Node>();
			stack.push(start);
			while (!stack.empty()) {
				Node next = stack.pop();
				next.isVisited();
				if (next.getState() == goal) {
					printPath(next, initial);
					break;
				} else {
					List<Node> l = next.getNeighbour();
					for (int i = 0; i < l.size(); i++) {
						if (!(l.get(i).isVisited())) {
							l.get(i).parent = next;
							stack.push(l.get(i));
							System.out.println("con: " + l.get(i).getState());

						}
					}
				}
			}
		}
	}

	private void printPath(Node node, Node initial) {
		String s = "";
		while (node != initial) {
			// System.out.println("tets "+ node.state);
			s = node.getState() + " " + s;
			node = node.parent;
		}
		System.out.println("Path: " + initial.getState() + " " + s);
	}
}
