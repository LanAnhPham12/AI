package baitap2;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
   
     Queen queens = new Queen(8);
      queens.dfs();
      queens.printSolution();
     queens.bfs();
      queens.printSolution();
      
      
      Queens q=new Queens(8);
      q.dfs();
	q.bfs();
      
	}
	

}
