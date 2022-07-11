package DP;

import java.util.Scanner;

//Time=>O(n^3)
//Space=>O(n^2)+O(n)=>storage[][]+recursive call stack space
public class MCM_Memoization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter array elements: ");
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		int[][] storage=new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				storage[i][j]=-1;
			}
		}
		System.out.println(solve(arr,1,n-1,storage));

	}

	private static int solve(int[] arr, int i, int j, int[][] storage) {
		// TODO Auto-generated method stub
		
		if(storage[i][j]!=-1)
			return storage[i][j];
		
		if(i>=j)
		{
			storage[i][j]=0;
			return storage[i][j];
		}
		
		int min=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++)
		{
			int tempAns=solve(arr,i,k,storage)+solve(arr,k+1,j,storage)+arr[i-1]*arr[k]*arr[j];
			if(tempAns<min)
				min=tempAns;
		}
		storage[i][j]=min;
		return storage[i][j];
	}

}
