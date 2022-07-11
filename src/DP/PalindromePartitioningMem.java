package DP;

import java.util.Scanner;

//Time=>O(n^2)
//Space=>O(n^2)+O(n)=>storage space+recursive call stack space
public class PalindromePartitioningMem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		int storage[][]=new int[str.length()][str.length()];
		
		for(int i=0;i<str.length();i++)
		{
			for(int j=0;j<str.length();j++)
			{
				storage[i][j]=-1;
			}
		}
		System.out.println(solve(str,0,str.length()-1,storage));
	}

	private static int solve(String str, int i, int j, int[][] storage) {
		
		if(storage[i][j]!=-1)
			return storage[i][j];
			
		if(i>=j)
		{
			storage[i][j]=0;
			return storage[i][j];
			
		}
		if(isPalindrome(str,i,j)==true)
		{
			storage[i][j]=0;
			return storage[i][j];
		}
		
		int min=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++)
		{
			int tempAns=solve(str,i,k,storage)+solve(str,k+1,j,storage)+1;
			if(tempAns<min)
				min=tempAns;
		}
		storage[i][j]=min;
		return storage[i][j];
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
