package String;

import java.util.Scanner;

//Time->O(n^2)
//Space->O(n^2)
//Using DP
public class CountPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		boolean dp[][]=new boolean[str.length()][str.length()];
		System.out.println(CountDP(str,dp));
	}

	private static int CountDP(String str, boolean[][] dp) {
		
		int count=0;
		for(int g=0;g<dp.length;g++)  //Gap or Diagonals
		{
			for(int i=0,j=g;j<dp.length;i++,j++) //Traversing cell of each diagonal Diagonally
			{
				if(g==0)
				{
					dp[i][j]=true;
				}
				else if(g==1)
				{
					if(str.charAt(i)==str.charAt(j))
						dp[i][j]=true;
				}
				else
				{
					
					if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]==true)
						dp[i][j]=true;
				}
				
				if(dp[i][j])
					count++;
			}
		}
		return count;
	}

}
