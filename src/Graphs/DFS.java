package Graphs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Time Complexity->O(V+E) && Space Complexity->Output ArrayList+Visited array=>O(V)+O(V)=>O(2V)=>O(V)
//Graph Properties:-
//1)Undirected and Disconnected Graph
//2)0-Based Indexing
public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			int source=sc.nextInt();
			int destination=sc.nextInt();
			adj.get(source).add(destination);
			adj.get(destination).add(source);
		}
		
		ArrayList<Integer> dfs=dfs(adj,v);
		
		System.out.println("----------DFS TRAVERSAL--------");
		for(Integer i:dfs)
		{
			System.out.print(i+" ");
		}
	}

	private static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj, int v) {
		// TODO Auto-generated method stub
		ArrayList<Integer> dfs=new ArrayList<Integer>();
		boolean visited[]=new boolean[v];
		
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				dfsUtil(adj,visited,dfs,i);
			}
		}
		return dfs;
	}

	private static void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs,int sv) {
		// TODO Auto-generated method stub
		visited[sv]=true;
		dfs.add(sv);
		
		for(Integer i: adj.get(sv))
		{
			if(!visited[i])
			   dfsUtil(adj,visited,dfs,i);
		}
		
	}

}
