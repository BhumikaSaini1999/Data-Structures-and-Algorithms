package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

//Time->O(V+E),Space->O(3V)=>O(V)=>visited Array+dfsVisited Array+Auxiliary stack space
//1-Based Indexing of Directed Graph
public class CycleDetectionDFS_Directed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=v;i++)
		{
			adj.add(new ArrayList<Integer>());
		}

		System.out.println("Enter edges:");
		for(int i=0;i<e;i++)
		{
			int source=sc.nextInt();
			int destination=sc.nextInt();
			adj.get(source).add(destination);
		}
		
		System.out.println(cycleDetection(adj,v));

	}

	private static boolean cycleDetection(ArrayList<ArrayList<Integer>> adj, int v) {
		boolean visited[]=new boolean[v+1];
		boolean dfsVisited[]=new boolean[v+1];
		for(int i=0;i<v;i++)
		{
			if(DFSCycle(i,adj,visited,dfsVisited))
				return true;
		}
		
		return false;
	}

	private static boolean DFSCycle(int sv, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisited) {
		visited[sv]=true;
		dfsVisited[sv]=true;
		
		
		for(Integer i:adj.get(sv))
		{
			if(!visited[i])
			{
				if(DFSCycle(i,adj,visited,dfsVisited))
					return true;
			}
			else if(dfsVisited[i])
				return true;
		}
		dfsVisited[sv]=false;
		return false;
	}

}
