package DP;

import java.util.Scanner;


//Time Complexity=>O(n^2)
//Space=>O(n)
//Using Palindromic suffix min cut method
public class PalindromePartitioningDP2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			String str=sc.next();
			
			System.out.println(PartitionDP(str,str.length()));

	}

	private static int PartitionDP(String str, int length) {
		// TODO Auto-generated method stub
		int[] dp=new int[str.length()];
		dp[0]=0;
		
		//j represents end of string
		for(int j=1;j<dp.length;j++)
		{
			if(isPalindrome(str,0,j)==true)
			{
				dp[j]=0;
			}
			else
			{
				int min=Integer.MAX_VALUE;
				for(int i=j;i>=1;i--)       //Here we are checking the suffixes
				{
					if(isPalindrome(str,i,j)==true)  //If suffix is palindrome then partition
					{
						if(dp[i-1]<min) //prefix=>previous calculated result
							min=dp[i-1];
					}
				}
				dp[j]=min+1;
			}
			
		}
		
		return dp[str.length()-1];
		
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
