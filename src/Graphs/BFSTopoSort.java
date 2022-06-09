package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
//Time->O(V+E)
//Space->O(2V)=>O(V)=>inDegree arr+queue

//Kahn's Algorithm
public class BFSTopoSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int ed=sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adjList=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++)
		{
			adjList.add(new ArrayList<Integer>());
		}
		System.out.println("Enter edges:");
		for(int i=0;i<ed;i++)
		{
			int src=sc.nextInt();
			int dest=sc.nextInt();
			adjList.get(src).add(dest);
		}
        
		ArrayList<Integer> ans=topoSort(adjList,n);
		for(Integer ele:ans)
			System.out.print(ele+" ");
	}

	private static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, int v) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<Integer>();
		ArrayList<Integer> ans=new ArrayList<Integer>();
		int inDegree[]=new int[v];
		for(int i=0;i<v;i++)
		{
			for(Integer it:adj.get(i))
			{
				inDegree[it]++;
			}
		}
		for(int i=0;i<inDegree.length;i++)
		{
			if(inDegree[i]==0)
				q.add(i);
		}
		
		while(!q.isEmpty())
		{
			int front=q.poll();
			ans.add(front);
			
			for(Integer i:adj.get(front))
			{
				inDegree[i]-=1;
				if(inDegree[i]==0)
					q.add(i);
			}
		}
		return ans;
	}
}
