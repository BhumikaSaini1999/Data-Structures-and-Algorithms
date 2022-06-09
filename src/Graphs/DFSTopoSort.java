package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
//Time->O(V+E)
//Space->O(3V)=>O(V)=>auxiliary call stack+visited array+stack
public class DFSTopoSort {

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
		boolean visited[]=new boolean[v];
		Stack<Integer> stack=new Stack<Integer>();
		ArrayList<Integer> ans=new ArrayList<Integer>();
		
		for(int i=0;i<v;i++)
		{
		   if(!visited[i])
			   dfs(adj,i,visited,stack);
		}
		while(!stack.isEmpty())
			ans.add(stack.pop());
		return ans;
	}

	private static void dfs(ArrayList<ArrayList<Integer>> adj, int sv, boolean[] visited, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		visited[sv]=true;
		for(Integer i:adj.get(sv))
		{
			if(!visited[i])
			{
				dfs(adj,i,visited,stack);
			}
		}
		stack.push(sv);
	}

}
