package DP;

import java.util.Scanner;

//Space=>O(e*f)
//Time=>won't be exponential
public class EggDropMemoization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int e=sc.nextInt();  //Number of eggs
		int f=sc.nextInt();  //Number of floors
		
		int storage[][]=new int[e+1][f+1];
		for(int i=0;i<=e;i++)
		{
			for(int j=0;j<=f;j++)
			{
				storage[i][j]=-1;
			}
		}
		System.out.println(solve(e,f,storage));
	}

	private static int solve(int e, int f, int[][] storage) {
		// TODO Auto-generated method stub
		
		if(storage[e][f]!=-1)
			return storage[e][f];
		if(e==1)   //if e==1 then in worst case min attempts would be f
		{
			return storage[e][f]=f;
		}
		
		if(f==0 || f==1) //if f==0 then no attempt and if f==1 then only 1 attempt
		{
			return storage[e][f]=f;
		}
		
		if(e==0)
			return storage[e][f]=0;
		
		int min=Integer.MAX_VALUE;
		for(int k=1;k<=f;k++)
		{
			int case1=solve(e,k-f,storage);    //if egg do not breaks when thrown from kth floor
			int case2=solve(e-1,k-1,storage);  //if egg breaks when thrown from kth floor
			
			int max=Math.max(case1, case2);  //In the worst case Maximum of both cases should be considered
			if(max<min)   //After taking max of all in the above statement, we need to take min of all
				min=max;
		}
		
		return storage[e][f]=1+min; //1+min=>here 1 reprents that we have already taken 1 step before
	}

}
