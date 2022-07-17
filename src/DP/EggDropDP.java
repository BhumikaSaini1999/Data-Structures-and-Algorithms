package DP;

import java.util.Scanner;


//Time=>O(n^3)=>O(e*f^2)
//Space=>O(n^2)=>O(e*f)
public class EggDropDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int e=sc.nextInt();  //Number of eggs
		int f=sc.nextInt();  //Number of floors
		System.out.println(solve(e,f));
	}

	private static int solve(int e, int f) {
		// TODO Auto-generated method stub
		int dp[][]=new int[e+1][f+1];  //because here we are considering from 1 to e and 1 to f
		
		for(int i=1;i<=e;i++)  //represent egg rows
		{
			for(int j=1;j<=f;j++) //represent floor columns
			{
				if(i==1) //if eggs are 1
				{
					dp[i][j]=j;
				}
				else if(j==1) //if number of floors are 1
				{
					dp[i][j]=j;
				}
				else
				{
					int min=Integer.MAX_VALUE;
					for(int a=0,b=j-1;a<j;a++,b--)//here only columns are changing of current row and previous row
					{
						int val1=dp[i][b];  //represents current row
						int val2=dp[i-1][a]; //represents previous row
						
						int temp=Math.max(val1, val2);  //worst or max of two
						if(temp<min) //finding best of worst
							min=temp;
					}
					dp[i][j]=min+1; //1 here representing that 1 step is already taken
				}
			}
		}
		
		return dp[e][f];
		
	}

}
