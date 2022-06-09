package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Kahn's algo
//Time->O(V+E),Space->O(2V)=>O(V)=>queue+inDegree
//1-Based Indexing of Directed Graph
public class CycleDetectionBFS_Directed {

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
		Queue<Integer> q=new LinkedList<Integer>();
		int inDegree[]=new int[v];
		
		for(int i=0;i<v;i++)
		{
			for(Integer j:adj.get(i))
			{
				inDegree[j]++;
			}
		}
		
		for(int i=0;i<v;i++)
		{
			if(inDegree[i]==0)
				q.add(i);
		}
		
		int count=0;
		while(!q.isEmpty())
		{
			int front=q.poll();
			count++;
			for(Integer i:adj.get(front))
			{
				inDegree[i]-=1;
				if(inDegree[i]==0)
				{
					q.add(i);
				}
			}
			
		}
		if(count==v)       //count is topoSort count=>If we found topoSort then it would be equal to v=>means no cycle
			return false;
		return true;
		
	}

}
