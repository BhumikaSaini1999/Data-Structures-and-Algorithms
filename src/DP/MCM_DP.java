package DP;

import java.util.Scanner;

//Time=>O(n^3)
//Space=>O(n^2)=>storage[][]
public class MCM_DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array:");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter array elements:");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		System.out.println(MCM(arr,n));

	}

	private static int MCM(int[] arr, int n) {
		
		int dp[][]=new int[n-1][n-1];
		
		for(int g=0;g<dp.length;g++)
		{
			for(int i=0,j=g;j<dp.length;i++,j++)
			{
				if(g==0)
				{
					dp[i][j]=0;
				}
				else if(g==1)
				{
					dp[i][j]=arr[i]*arr[j]*arr[j+1];
				}
				else
				{
					int min=Integer.MAX_VALUE;
					for(int k=i;k<j;k++)
					{
						//Left=>i to k and Right=>k+1 to j
						//Left Dimensions=>i * k+1 and Right Dimensions=>k+1 * j+1
						int lc=dp[i][k];
						int rc=dp[k+1][j];
						int mc=arr[i]*arr[k+1]*arr[j+1];
						
						int cost=lc+rc+mc;
						if(cost<min)
							min=cost;
					}
					
					dp[i][j]=min;
				}
			}
		}
		
		return dp[0][dp.length-1];
	}

}
