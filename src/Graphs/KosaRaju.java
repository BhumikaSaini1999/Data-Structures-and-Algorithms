package Graphs;

import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

//Time Complexity=>O(V+E)+O(V)+O(V+E)=>TopoSort+Transpose Of Graph+DFS
//Space Complexity=>O(V+E)+O(V)+O(V)=>O(V+E)=>transpose matrix+visited array+stack
public class KosaRaju {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
		
		System.out.println("Enter edges:");
		for(int i=0;i<e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			adj.get(src).add(dest);
		}
		
		Kosaraju(adj,v);
	}
	private static void dfsTopoSort(int sv, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[sv]=true;
		
		for(Integer i:adj.get(sv))
		{
			if(!visited[i])
				dfsTopoSort(i,adj,stack,visited);
		}
		stack.add(sv);
	}
	
	private static void revDfs(int sv, ArrayList<ArrayList<Integer>> transpose,boolean[] visited) {
		// TODO Auto-generated method stub
		visited[sv]=true;
		System.out.print(sv+" ");
		for(Integer i:transpose.get(sv))
		{
			if(!visited[i])
				revDfs(i,transpose,visited);
		}
	}

	private static void Kosaraju(ArrayList<ArrayList<Integer>> adj, int v) {
		// TODO Auto-generated method stub
		Stack<Integer> stack=new Stack<Integer>();
		boolean visited[]=new boolean[v];
		
		// Finding out TopoSort using DFS=>Using DFS store vertices in a stack as per their finish time
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				dfsTopoSort(i,adj,stack,visited);
			}
		}
			
		//Transpose of Graph
		ArrayList<ArrayList<Integer>> transpose=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<v;i++)
		{
			transpose.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<v;i++)
		{
			visited[i]=false;            //Making again all visited nodes as false
			for(Integer itr:adj.get(i))
			{
				transpose.get(itr).add(i);    //Transposing the matrix
			}
		}
		
		//DFS according to Finishing Time
		int count=0;
		while(stack.size()>0)
		{
			int top=stack.peek();
			stack.pop();
			if(!visited[top])
			{
				count++;
				System.out.print("SCC: ");
				revDfs(top,transpose,visited);
				System.out.println();
			}
		}
		System.out.println("Count="+count);
	}


}
