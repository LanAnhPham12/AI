package week1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	
	void bfs(Node initial, int goal) {
		Node start= initial;
		if(start.getState()==goal) {
			System.out.println(start.getState());
		}
		else {
			Queue<Node> q= new LinkedList<Node>();
			q.add(start);
			while(q!=null) {
				Node next= q.remove();
				next.isVisited();
				
				if(next.getState()==goal) {
					printPath(next , initial);
					break;
				}else {
					List<Node> l= next.getNeighbour();
					for(int i=0;i<l.size();i++) {
						if(!(l.get(i).isVisited())){
							l.get(i).parent=next;
							q.add(l.get(i));
							System.out.println("con: " +l.get(i).getState());
						}
					}
				}
			}
		}
		
	}
	
	



	private void printPath(Node node, Node initial) {
		String s = "";
		while (node != initial) {
			s = node.getState() + " " + s;
			node = node.parent;
		}
		System.out.println("Path: " + initial.getState() + " " + s);
	
	}

}
