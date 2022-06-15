package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

//Time=>O(V^3)
//Space=>O(V^2)
class Pairs
{
	int node;
	int wgt;
	public Pairs(int node, int wgt) {
		super();
		this.node = node;
		this.wgt = wgt;
	}
}
public class FloydWarshallAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		
		ArrayList<ArrayList<Pairs>> adj=new ArrayList<ArrayList<Pairs>>();
		System.out.println("Enter edges along with weight:");
		
		for(int i=0;i<v;i++)
			adj.add(new ArrayList<Pairs>());
		
		for(int i=0;i<e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int wgt=sc.nextInt();
			adj.get(src).add(new Pairs(dest,wgt));
		}	
		FloydWarshall(adj,v);
	}

	private static void FloydWarshall(ArrayList<ArrayList<Pairs>> adj, int v) {
		// TODO Auto-generated method stub
		int dist[][]=new int[v][v];
		
		//Filling dist[][] initially
		for(int i=0;i<v;i++)
		{
			for(Pairs ele:adj.get(i))
			{
				dist[i][ele.node]=ele.wgt;
			}
		}
		
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
			  if(i!=j && dist[i][j]==0)
			        dist[i][j]=Integer.MAX_VALUE;
			}
		}
		
		//Find all pairs shortest path by trying all possible paths
		for(int k=0;k<v;k++)
		{
			for(int i=0;i<v;i++) //Trying all possible sources
			{
				for(int j=0;j<v;j++) //Trying all possible destinations
				{
					if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE)	//SKIP if K is unreachable from i or j is unreachable from k
						continue;
					else
					{
						dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]); //Check if new distance is shorter via vertex K
					}
				}
			}
		}
		
		//Check for negative edge weight cycle
		for(int i=0;i<v;++i)
			if(dist[i][i] < 0)
			{
				System.out.println("Negative edge weight cycle is present");
				return;
			}
		
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
	}
}
