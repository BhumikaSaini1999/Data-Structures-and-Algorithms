package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
//Time->O(V+E),Time->O(3V)=>O(V)=>stack+queue+indegree array
//Using BFS Kahn's Algo approach
public class CourseScheduleII_210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v=sc.nextInt();
		
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		
		int arr[][]=new int[e][];

		System.out.println("Enter edges:");
		for(int i=0;i<e;i++)
		{
			arr[i]=new int[2];
			int source=sc.nextInt();
			int destination=sc.nextInt();
			arr[i][0]=source;
			arr[i][1]=destination;
		}
		int ans[]=findOrder(v,arr);
	}

	private static int[] findOrder(int n, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<n;i++)
        {
                adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<arr.length;i++)
        {
                int src=arr[i][0];
                int dest=arr[i][1];
                adj.get(src).add(dest);
        }
        
        int ans[]=topoSortReverse(adj,n);
        return ans;
	}

	private static int[] topoSortReverse(ArrayList<ArrayList<Integer>> adj, int n) {
		int ans[]=new int[n];
        int indegree[]=new int[n];
        Queue<Integer> q=new LinkedList<Integer>();
        Stack<Integer> stack=new Stack<Integer>();
        
        for(int i=0;i<n;i++)
        {
                for(Integer j:adj.get(i))
                {
                        indegree[j]++;
                }
        }
        
        for(int i=0;i<n;i++)
        {
                if(indegree[i]==0)
                        q.add(i);
        }
        
        int count=0;
        while(!q.isEmpty())
        {
                int front=q.poll();
                stack.push(front);
                count++;
                for(Integer i:adj.get(front))
                {
                        indegree[i]-=1;
                        if(indegree[i]==0)
                                q.add(i);
                }
        }
        
        
        if(count!=n)  //there is cycle
                return new int[0];
        
        int index=0;
        while(!stack.isEmpty())
                ans[index++]=stack.pop();
        return ans;
	}

}
