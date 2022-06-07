package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

//Time->O(V+E),Space->O(V)
//Here Graph is Undirected and disconnected
public class CycleDetectionDFS {

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
				if(detectCycle(i,-1,visited,adj))
				{
					return true;
				}
			}
		}
		return false;
	}

	private static boolean detectCycle(int sv, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		// TODO Auto-generated method stub
		visited[sv]=true;
		
		for(Integer i:adj.get(sv))
		{
			if(!visited[i])
			{
				return detectCycle(i,sv,visited,adj);
			}
			else if(parent!=i)
				return true;
		}
		return false;
	}

}
