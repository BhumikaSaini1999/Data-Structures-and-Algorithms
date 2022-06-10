package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Time=>O(V+E) and Space=>O(V)=>colour array
//Here we are taking two colours=>0/1
public class BipartiteCheck_DFS {

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
			adj.get(destination).add(source);
		}
		System.out.println(bipartiteCheck(adj,v));
	}

	private static boolean bipartiteCheck(ArrayList<ArrayList<Integer>> adj, int v) {
		// TODO Auto-generated method stub
		int colour[]=new int[v+1];
		for(int i=0;i<=v;i++)
			colour[i]=-1;
	
		for(int i=0;i<v;i++)
		{
			if(colour[i]==-1)
			{
				if(!bipartite(adj,i,0,colour))
					return false;
			}
		}
		return true;
	}

	private static boolean bipartite(ArrayList<ArrayList<Integer>> adj, int sv, int col, int[] colour) {
		colour[sv]=col;
		for(Integer i:adj.get(sv))
		{
			if(colour[i]==-1)
			{
				if(colour[sv]==0)
					col=1;
				else col=0;
				if(!bipartite(adj,i,col,colour))
					return false;
			}
			else if(colour[i]==colour[sv])
				return false;
		}
		return true;
	}

}
