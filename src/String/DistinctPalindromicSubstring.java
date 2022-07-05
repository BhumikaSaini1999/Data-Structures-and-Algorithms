package String;

import java.util.HashMap;
import java.util.Scanner;

//Distinct Palindromic Substrings
//Time->O(n^2 * logn)=> here logn is for put() in hashMap
//Space->O(n^2)+O(n)=>dp[][]+Hashmap space
//Using DP
public class DistinctPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		boolean dp[][]=new boolean[str.length()][str.length()];
		System.out.println(CountDP(str,dp));
	}

	private static int CountDP(String str, boolean[][] dp) {
		
		int count=0;
		HashMap<String,Integer> map=new HashMap<String,Integer>();
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
                {
                    String palStr=str.substring(i,j+1);
                    if(!map.containsKey(palStr))
                    {
                        map.put(palStr,1);
                        count++;
                    }
                }
			}
		}
		return count;
	}

}
