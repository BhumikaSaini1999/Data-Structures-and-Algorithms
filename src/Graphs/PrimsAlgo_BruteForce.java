package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

//Time=>O(V)*{O(V)+O(V+E)}=>O(V^2)
//Space=>O(3V)=>O(V)=>visited+parent+weight
class Double
{
	int dest;
	int wgt;
	public Double(int dest, int wgt) {
		super();
		this.dest = dest;
		this.wgt = wgt;
	}
}
public class PrimsAlgo_BruteForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		
		ArrayList<ArrayList<Double>> adj=new ArrayList<ArrayList<Double>>();
		for(int i=0;i<=v;i++)
		{
			adj.add(new ArrayList<Double>());
		}

		System.out.println("Enter edges along with weight:");
		for(int i=0;i<e;i++)
		{
			int source=sc.nextInt();
			int destination=sc.nextInt();
			int weight=sc.nextInt();
			adj.get(source).add(new Double(destination,weight));
			adj.get(destination).add(new Double(source,weight));
		}
		
		Prims(adj,v);
	}

	private static void Prims(ArrayList<ArrayList<Double>> adj, int v) {
		// TODO Auto-generated method stub
		int weight[]=new int[v];
		boolean visited[]=new boolean[v];
		int parent[]=new int[v];
		
		for(int i=0;i<v;i++)
		{
			weight[i]=Integer.MAX_VALUE;
			parent[i]=-1;
		}
		weight[0]=0;
		
		int count=0;
		while(count<v-1)//Bcoz we are traversing v-1 edges
		{
			int min=Integer.MAX_VALUE;
			int minIndex=0;
			for(int i=0;i<weight.length;i++)
			{
				if(!visited[i] && weight[i]<min)
				{
					min=weight[i];
					minIndex=i;
				}
			}
			visited[minIndex]=true;
			for(Double ele:adj.get(minIndex))
			{
				if(!visited[ele.dest] && ele.wgt<weight[ele.dest])
				{
					weight[ele.dest]=ele.wgt;
					parent[ele.dest]=minIndex;
				}
			}
			count++;
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
