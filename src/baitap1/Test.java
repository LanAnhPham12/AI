package week1;

public class Test {

	public static void main(String[] args) {
		
		  Node node40= new Node(40);
		  Node node10= new Node(10);
		  Node node20= new Node(20);
		  Node node30= new Node(30);
		  Node node60= new Node(60);
		  Node node50= new Node(50);
		  Node node70= new Node(70);
		  
		  
		    
		  node40.addNeighbours(node10);
		  node40.addNeighbours(node20);
		  node10.addNeighbours(node30);
		  node20.addNeighbours(node10);
		  node20.addNeighbours(node30);
		  node20.addNeighbours(node60);
		  node20.addNeighbours(node50);
		  node30.addNeighbours(node60);
		  node60.addNeighbours(node70);
		  node50.addNeighbours(node70);
		  BFS bfs= new BFS();
	
	//	bfs.bfs(node40, 70);
	
		  
	 DFS dfs= new DFS();
		 dfs.dfs(node40, 70);
			// System.out.println(node40.toString());
		 }
}
