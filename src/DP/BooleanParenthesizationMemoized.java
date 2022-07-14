package DP;

import java.util.Scanner;

//T(C)=>O(n^3)
//S(C)=>O(n^2)+O(n^2)=O(n^2)=>Using two storages
public class BooleanParenthesizationMemoized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		int storageTrue[][]=new int[str.length()][str.length()];
		for(int i=0;i<storageTrue.length;i++)
		{
			for(int j=0;j<storageTrue.length;j++)
			{
				storageTrue[i][j]=-1;
			}
		}
		
		int storageFalse[][]=new int[str.length()][str.length()];
		for(int i=0;i<storageFalse.length;i++)
		{
			for(int j=0;j<storageFalse.length;j++)
			{
				storageFalse[i][j]=-1;
			}
		}
		System.out.println(solve(str,0,str.length()-1,true,storageTrue,storageFalse));
	}

	private static int solve(String str, int i, int j, boolean isTrue, int[][] storageTrue, int[][] storageFalse) {
		
		if(storageTrue[i][j]!=-1 && isTrue)
		{
			return storageTrue[i][j];
		}
		if(storageFalse[i][j]!=-1 && !isTrue)
		{
			return storageFalse[i][j];
		}
		
		if(i>j && isTrue)
		{
			storageTrue[i][j]=0;
			return storageTrue[i][j];
		}

		if(i>j && !isTrue)
		{
			storageFalse[i][j]=0;
			return storageFalse[i][j];
		}
		
		if(i==j)
		{
			if(isTrue)
			{
				if(str.charAt(i)=='T')
				{
					storageTrue[i][j]=1;
					return storageTrue[i][j];
				}
				else
				{
					storageTrue[i][j]=0;
					return storageTrue[i][j];
				}
			}
			else
			{
				if(str.charAt(i)=='F')
				{
					storageFalse[i][j]=1;
					return storageFalse[i][j];
				}
				else
				{
					storageFalse[i][j]=0;
					return storageFalse[i][j];
				}
			}
		}
		
		int ans=0;
		for(int k=i+1;k<=j-1;k+=2)
		{
			int leftTrue=solve(str,i,k-1,true,storageTrue,storageFalse);
			int rightFalse=solve(str,k+1,j,false,storageTrue,storageFalse);
			int leftFalse=solve(str,i,k-1,false,storageTrue,storageFalse);
			int rightTrue=solve(str,k+1,j,true,storageTrue,storageFalse);
			
			
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
		if(isTrue)
		{
			storageTrue[i][j]=ans;
			return storageTrue[i][j];
		}
		else
		{
			storageFalse[i][j]=ans;
			return storageFalse[i][j];
		}
	}

}
