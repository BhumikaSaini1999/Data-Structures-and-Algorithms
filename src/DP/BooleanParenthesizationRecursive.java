package DP;

import java.util.Scanner;

//T(C)=>exponential
//S(C)=>O(n)
public class BooleanParenthesizationRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println(solve(str,0,str.length()-1,true));
	}

	private static int solve(String str, int i, int j, boolean isTrue) {
		if(i>j)
			return 0;
		if(i==j)
		{
			if(isTrue)
			{
				if(str.charAt(i)=='T')
					return 1;
				else
					return 0;
			}
			else
			{
				if(str.charAt(i)=='F')
					return 1;
				else
					return 0;
			}
		}
		
		int ans=0;
		for(int k=i+1;k<=j-1;k+=2)
		{
			int leftTrue=solve(str,i,k-1,true);
			int rightFalse=solve(str,k+1,j,false);
			int leftFalse=solve(str,i,k-1,false);
			int rightTrue=solve(str,k+1,j,true);
			
			
			//Based on operator calculate ans
			if(str.charAt(k)=='^')
			{
				if(isTrue)
				{
					ans+=leftTrue*rightFalse+rightTrue*leftFalse;
				}
				else
				{
					ans=leftTrue*rightTrue+leftFalse*rightFalse;
				}
			}
			else if(str.charAt(k)=='|')
			{
				if(isTrue)
				{
					ans+=leftTrue*rightFalse+leftFalse*rightTrue+leftTrue*rightTrue;
				}
				else
				{
					ans+=leftFalse*rightFalse;
				}
			}
			else if(str.charAt(k)=='&')
			{
				if(isTrue)
				{
					ans+=leftTrue*rightTrue;
				}
				else
				{
					ans+=leftFalse*rightFalse+leftTrue*rightFalse+leftFalse*rightTrue;
				}
			}
			
			
		}
		return ans;
	}

}
