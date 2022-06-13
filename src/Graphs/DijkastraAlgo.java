package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Time=>O(V+E)VlogV =>Time taken to take out vertex and traversing all its adjacency list as well as removing element from PQ
//Space=>o(V)+O(V)=>O(V)=>Distance array+PQ
class Paired
{
	int node;
	int wgt;
	public Paired(int node, int wgt) {
		super();
		this.node= node;
		this.wgt = wgt;
	}
}
class MinComparator implements Comparator<Paired>
{
	@Override
	public int compare(Paired o1, Paired o2) {
		if(o1.wgt<o2.wgt)
			return -1;
		else if(o1.wgt>o2.wgt)
			return 1;
		else
			return 0;
	}
}
public class DijkastraAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		
		ArrayList<ArrayList<Paired>> adj=new ArrayList<ArrayList<Paired>>();
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<Paired>());
		}
		
		System.out.println("Enter edges along with weight:");
		for(int i=0;i<e;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			int weight=sc.nextInt();
			
			adj.get(src).add(new Paired(dest,weight));
			adj.get(dest).add(new Paired(src,weight));
		}

		Dijkastra(adj,v);
	}

	private static void Dijkastra(ArrayList<ArrayList<Paired>> adj, int v) {
		// TODO Auto-generated method stub
		MinComparator mc=new MinComparator();
		PriorityQueue<Paired> pq=new PriorityQueue<Paired>(mc);
		
		int dist[]=new int[v];
		for(int i=0;i<v;i++)
		{
			dist[i]=Integer.MAX_VALUE;
		}
		pq.add(new Paired(0,0));
		dist[0]=0;
		
		while(!pq.isEmpty())
		{
			Paired front=pq.remove();
			
			for(Paired ele:adj.get(front.node))
			{
			   int x=dist[front.node]+ele.wgt;
			   if(x<dist[ele.node])
			   {
				   dist[ele.node]=x;
				   pq.add(new Paired(ele.node,x));
			   }
			}
		}
		
		for(int i=0;i<v;i++)
		{
			System.out.println("0->"+i+"= "+dist[i]);
		}
	}

}
