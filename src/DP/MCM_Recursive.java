package DP;

import java.util.Scanner;

//Time=>Exponential
//Space=>O(n)
public class MCM_Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter array elements: ");
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		System.out.println(solve(arr,1,n-1));

	}

	private static int solve(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if(i>=j)
			return 0;
		
		int min=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++)
		{
			int tempAns=solve(arr,i,k)+solve(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
			
			if(tempAns<min)
				min=tempAns;
		}
		return min;
	}

}
