package baitap2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queens {

	
	private int n;
	private Node goal;
	public Queens (int n)
	{
		this.n=n;
	}
	public void dfs()
	{
		DFS dfs=new DFS();
		this.goal=dfs.dfsUsingStack(new Node(n), n);
		
		System.out.print(goal);
		System.out.println();
	}
	public void bfs()
	{
		BFS bfs=new BFS();
		this.goal=bfs.bfsUsingQueue(new Node(n), n);
		System.out.println(goal);
		System.out.println();
	}

}
