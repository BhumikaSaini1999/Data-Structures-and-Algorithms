package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Time=>O(V)*O(logV+O(E))=>O(VlogV)
//Space=>O(4V)=>visited+weight+parent+PQ
class Double1 
{
	int node;
	int wgt;
	public Double1(int node, int wgt) {
		super();
		this.node = node;
		this.wgt = wgt;
	}
}
class MinComparators implements Comparator<Double1>
{

	@Override
	public int compare(Double1 o1, Double1 o2) {
		// TODO Auto-generated method stub
		if(o1.wgt<o2.wgt)
			return -1;
		else if(o1.wgt>o2.wgt)
			return 1;
		else
			return 0;
	}
	
}

public class PrimsAlgo_Effecient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		
		ArrayList<ArrayList<Double1>> adj=new ArrayList<ArrayList<Double1>>();
		for(int i=0;i<=v;i++)
		{
			adj.add(new ArrayList<Double1>());
		}

		System.out.println("Enter edges along with weight:");
		for(int i=0;i<e;i++)
		{
			int source=sc.nextInt();
			int destination=sc.nextInt();
			int weight=sc.nextInt();
			adj.get(source).add(new Double1(destination,weight));
			adj.get(destination).add(new Double1(source,weight));
		}
		
		Prims(adj,v);
	}

	private static void Prims(ArrayList<ArrayList<Double1>> adj, int v) {
		// TODO Auto-generated method stub
		int weight[]=new int[v];
		boolean visited[]=new boolean[v];
		int parent[]=new int[v];
		
		MinComparators mc=new MinComparators();
		PriorityQueue<Double1> pq=new PriorityQueue<Double1>(mc);
		pq.add(new Double1(0,0));
		
		for(int i=0;i<v;i++)
		{
			weight[i]=Integer.MAX_VALUE;
			parent[i]=-1;
		}
		weight[0]=0;
		while(!pq.isEmpty())
		{
			int minIndex=pq.remove().node;
			visited[minIndex]=true;
			for(Double1 ele:adj.get(minIndex))
			{
				if(!visited[ele.node] && ele.wgt<weight[ele.node])
				{
					pq.add(new Double1(ele.node,ele.wgt));
					parent[ele.node]=minIndex;
					weight[ele.node]=ele.wgt;
				}
			}
		}
		
		int sum=0;
		for(int i=0;i<v;i++)
		{
			sum+=weight[i];
			System.out.print(weight[i]+" ");
		}
		System.out.println("\n"+sum);
	}

}
