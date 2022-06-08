package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

//CycleDetection in Directed Graph Using DFS
//Time->O(V+E),Space->O(3V)=>O(V)=>visited Array+dfsVisited Array+Auxiliary stack call space
public class CourseScheduleI_207 {

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
		System.out.println(canFinish(v,arr));

	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int n=numCourses;
        boolean visited[]=new boolean[n];
        boolean dfsVisited[]=new boolean[n];
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<n;i++)
                adj.add(new ArrayList<Integer>());
        
        for(int i=0;i<prerequisites.length;i++)
        {
                int src=prerequisites[i][0];
                int dest=prerequisites[i][1];
                adj.get(src).add(dest);
        }
        for(int i=0;i<numCourses;i++)
        {
             if(DFS_Cycle(i,visited,dfsVisited,adj)) //If cycle return false
                        return false;
        }
        return true;   //otherwise true
}
    
private static boolean DFS_Cycle(int sv,boolean[] visited,boolean[] dfsVisited,ArrayList<ArrayList<Integer>> adj)
{
        visited[sv]=true;
        dfsVisited[sv]=true;
        
        for(Integer i:adj.get(sv))
        {
                     if(!visited[i])
                     {
                         if(DFS_Cycle(i,visited,dfsVisited,adj))
                             return true;
                     }
                     else if(dfsVisited[i])
                             return true;
        }
        
        dfsVisited[sv]=false;
        return false;
}

}
