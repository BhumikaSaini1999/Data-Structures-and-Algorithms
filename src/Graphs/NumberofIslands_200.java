package Graphs;

import java.util.Scanner;

//Time->O(n*m)
//Space->O(n*m)
public class NumberofIslands_200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter rows:");
		int n=sc.nextInt();
		
		System.out.println("Enter columns:");
		int m=sc.nextInt();
		
		char[][] grid=new char[n][m];
		
		System.out.println("Enter grid of islands:");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				grid[i][j]=sc.next().charAt(0);
			}
		}
		
		System.out.println(numIslands(grid));

	}

	private static int numIslands(char[][] grid) {
		    int[][] mat=new int[grid.length][grid[0].length];
	        
	        boolean[][] visited=new boolean[mat.length][mat[0].length];
	        int count=0;
	        
	        for(int i=0;i<grid.length;i++)
	        {
	            for(int j=0;j<grid[0].length;j++)
	            {
	                if(!visited[i][j] && grid[i][j]=='1')
	                {
	                    dfs(i,j,grid,visited);
	                    count++;
	                }
	            }
	        }
	        return count;
	}
	
	private static void dfs(int i,int j,char[][] grid,boolean[][] visited)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
           return;
           
        if(grid[i][j]=='0')return;
        if(!visited[i][j])
        {
            visited[i][j]=true;
            dfs(i+1,j,grid,visited);
            dfs(i-1,j,grid,visited);
            dfs(i,j+1,grid,visited);
            dfs(i,j-1,grid,visited);
        }
    }

}
