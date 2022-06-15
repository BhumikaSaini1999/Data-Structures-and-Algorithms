package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

//Time=>O(V^3)
//Space=>O(1)
public class FloydWarshallAlgo_InPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		
		int graph[][]=new int[v][v];
		System.out.println("Enter edges along with weight:");
		
		
		for(int i=0;i<e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int wgt=sc.nextInt();
			graph[src][dest]=wgt;
		}	
		FloydWarshall(graph,v);
	}

	private static void FloydWarshall(int[][] graph, int v) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
			  if(i!=j && graph[i][j]==0)
			        graph[i][j]=Integer.MAX_VALUE;
			}
		}
		
		//Find all pairs shortest path by trying all possible paths
		for(int k=0;k<v;k++)
		{
			for(int i=0;i<v;i++) //Trying all possible sources
			{
				for(int j=0;j<v;j++) //Trying all possible destinations
				{
					if(graph[i][k]!=Integer.MAX_VALUE && graph[k][j]!=Integer.MAX_VALUE)	//SKIP if K is unreachable from i or j is unreachable from k
					{
						graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]); //Check if new distance is shorter via vertex K
					}
				}
			}
		}
		
		//Check for negative edge weight cycle
		for(int i=0;i<v;++i)
			if(graph[i][i] < 0)
			{
				System.out.println("Negative edge weight cycle is present");
				return;
			}
		
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
}
