package DP;

import java.util.Scanner;

//Time=>O(n^3)
//Space=>O(n^2)=>storage[][]
public class PalindromePartitioningDP {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		System.out.println(PartitionDP(str,str.length()));
	}

	private static int PartitionDP(String str, int n) {
		
		int[][] dp=new int[n][n];
		
		for(int g=0;g<n;g++)
		{
			for(int i=0,j=g;j<n;i++,j++)
			{
				if(g==0)
				{
					dp[i][j]=0;
				}
				else if(g==1)
				{
					if(str.charAt(i)==str.charAt(j))
						dp[i][j]=0;
					else
						dp[i][j]=1;
				}
				else
				{
					
					if(isPalindrome(str,i,j)==true)
					{
						dp[i][j]=0;
					}
					else
					{
						int min=Integer.MAX_VALUE;
						for(int k=i;k<j;k++)
						{
							int leftCost=dp[i][k];
							int rightCost=dp[k+1][j];
							int totalCost=leftCost+rightCost+1;
							
							if(totalCost<min)
								min=totalCost;
						}
						
						dp[i][j]=min;
					}
				}
			}
		}
		
		return dp[0][n-1];
	}

	private static boolean isPalindrome(String str, int i, int j) {
		// TODO Auto-generated method stub
		
		while(i<=j)
		{
			if(str.charAt(i)!=str.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
