package Graphs;

import java.util.ArrayList;
import java.util.Scanner;


//Time=>O(V-1)*O(E)=>O(V*E)
//Space=>O(V)=>distance array
class Triplet
{
	int src;
	int dest;
	int wgt;
	public Triplet(int src, int dest, int wgt) {
		super();
		this.src = src;
		this.dest = dest;
		this.wgt = wgt;
	}
}
public class BellmanFordAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		
		ArrayList<Triplet> adj=new ArrayList<Triplet>();
		System.out.println("Enter edges along with weight:");
		
		for(int i=0;i<e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int wgt=sc.nextInt();
			adj.add(new Triplet(src,dest,wgt));
		}	
		bellmanFord(adj,v,0);
	}

	private static void bellmanFord(ArrayList<Triplet> adj, int v, int s) {
		// TODO Auto-generated method stub
		int dist[]=new int[v];
		for(int i=0;i<v;i++)
		{
			dist[i]=Integer.MAX_VALUE;
		}
		
		dist[s]=0;
		int flag=0;
		for(int i=1;i<=v-1;i++) //Number of Relaxations is equal to v-1
		{
			for(Triplet node:adj)
			{
				if(dist[node.src]+node.wgt<dist[node.dest])
					dist[node.dest]=dist[node.src]+node.wgt;
			}
		}
		
		for(Triplet node:adj)
		{
			if(dist[node.src]+node.wgt<dist[node.dest])
			{
				flag=1;
				System.out.println("Negative weight cycle");
				if(flag==1)
					break;
				dist[node.dest]=dist[node.src]+node.wgt;
			}
		}
		if(flag==0)
		{
			System.out.println("Shortest Distance from Source:");
			for(int i=0;i<v;i++)
				System.out.print(dist[i]+" ");
		}
	}

}
