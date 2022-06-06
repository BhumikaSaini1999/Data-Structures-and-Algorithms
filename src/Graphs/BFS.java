package Graphs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Time Complexity->O(V+E) && Space Complexity->Queue+Output ArrayList=>O(V)+O(V)=>O(2V)=>O(V)
//Graph Properties:-
//1)Undirected and Disconnected Graph
//2)0-Based Indexing
public class BFS {

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
		
		ArrayList<Integer> bfs=bfs(adj,v);
		
		System.out.println("----------BFS TRAVERSAL--------");
		for(Integer i:bfs)
		{
			System.out.print(i+" ");
		}
	}

	private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int v) {
		// TODO Auto-generated method stub
		ArrayList<Integer> bfs=new ArrayList<Integer>();
		boolean visited[]=new boolean[v];
		
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				bfsUtil(adj,visited,bfs,i);
			}
		}
		return bfs;
	}

	private static void bfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> bfs,int sv) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(sv);
		bfs.add(sv);
		visited[sv]=true;
		
		while(!q.isEmpty())
		{
			int front=q.poll();
			for(Integer i:adj.get(front))
			{
				if(!visited[i])
				{
					q.add(i);
					bfs.add(i);
					visited[i]=true;
				}
			}
		}
		
	}

}
