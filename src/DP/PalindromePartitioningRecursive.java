package DP;

import java.util.Scanner;

//Time=>Exponential
//Space=>O(n)=>recursive call stack space
public class PalindromePartitioningRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		System.out.println(solve(str,0,str.length()-1));
	}

	private static int solve(String str, int i, int j) {
		
		if(i>=j)
			return 0;
		if(isPalindrome(str,i,j)==true)
			return 0;
		
		int min=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++)
		{
			int tempAns=solve(str,i,k)+solve(str,k+1,j)+1;
			if(tempAns<min)
				min=tempAns;
		}
		return min;
	}

	private static boolean isPalindrome(String str, int i, int j) {
		// TODO Auto-generated method stub
		
		boolean flag=true;
		while(i<=j)
		{
			if(str.charAt(i)!=str.charAt(j))
			{
				flag=false;
				break;
			}
			i++;
			j--;
		}
		
		return flag;
	}

}
