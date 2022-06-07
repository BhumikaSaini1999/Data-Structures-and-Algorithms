package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

//Time->O(V+E),Space->O(V)+O(V)=>visited array & queue
//Here Graph is Undirected and disconnected
class Pair
{
	int node;
	int parent;
	public Pair(int node, int parent) {
		super();
		this.node = node;
		this.parent = parent;
	}
	
}

public class CycleDetectionBFS {

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
		
		System.out.println(cycleDetection(adj,v));


	}

	private static boolean cycleDetection(ArrayList<ArrayList<Integer>> adj, int v) {
		// TODO Auto-generated method stub
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
			{
				if(BFSCycle(i,visited,adj))
					return true;
			}
		}
		return false;
	}

	private static boolean BFSCycle(int sv, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		// TODO Auto-generated method stub
		Queue<Pair> q=new LinkedList<Pair>();
		q.add(new Pair(sv,-1));
		visited[sv]=true;
		
		while(!q.isEmpty())
		{
			Pair front=q.poll();
			for(Integer i:adj.get(front.node))
			{
				if(!visited[i])
				{
					q.add(new Pair(i,front.node));
					visited[i]=true;
				}
				else if(i!=front.parent)
					return true;
			}
		}
		return false;
	}

}
