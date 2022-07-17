package DP;

import java.util.Scanner;

//Time and space=>exponential(in terms of recursive call stack)
//auxiliary space=>O(1)
public class EggDropRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int e=sc.nextInt();  //Number of eggs
		int f=sc.nextInt();  //Number of floors
		//Our purpose is not to find critical floor but to find min attempts to find critical floor
		//Critical floor is the floor at/below which egg won't break. Above that floor egg breaks
		
		System.out.println(solve(e,f));
	}

	//Returning min attempts to find critical floor
	//Best of worst scenario=> when project estimation
	private static int solve(int e, int f) {
		// TODO Auto-generated method stub
		if(e==1)   //if e==1 then in worst case min attempts would be f
			return f;
		
		if(f==0 || f==1) //if f==0 then no attempt and if f==1 then only 1 attempt
			return f;
		
		if(e==0)
			return 0;
		
		int min=Integer.MAX_VALUE;
		for(int k=1;k<=f;k++)
		{
			int case1=solve(e,f-k);    //if egg do not breaks when thrown from kth floor
			int case2=solve(e-1,k-1);  //if egg breaks when thrown from kth floor
			
			int temp=Math.max(case1, case2);  //In the worst case Maximum of both cases should be considered
			if(temp<min)   //After taking max of all in the above statement, we need to take min of all
				min=temp;
		}
		
		return 1+min; //1+min=>here 1 reprents that we have already taken 1 step before
	}

}
