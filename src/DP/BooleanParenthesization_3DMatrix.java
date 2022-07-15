package DP;

import java.util.HashMap;
import java.util.Scanner;

//T(C)=>O(n^3)
//S(C)=>O(n^3)


public class BooleanParenthesization_3DMatrix {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		//3D Matrix=>as there are three changing variables i,j,isTrue
		//value of i,j can vary from 0 to n-1(n=length of string) , Value of isTrue can be 2 either T/F
		int[][][] storage=new int[str.length()][str.length()][2];
		
		for(int i=0;i<str.length();i++)
		{
			for(int j=0;j<str.length();j++)
			{
				for(int k=0;k<2;k++)
				{
					storage[i][j][k]=-1;
				}
			}
		}
		System.out.println(solve(str,0,str.length()-1,true,storage));
	}

	private static int solve(String str, int i, int j, boolean isTrue, int[][][] storage) {
		
		if(storage[i][j][0]!=-1 && !isTrue) //representing False Case
			return storage[i][j][0];
		if(storage[i][j][1]!=-1 && isTrue) //representing True Case
			return storage[i][j][1];
		
		//out of range return 0
		if(i>j)
			return 0;
		
		//if single character
		if(i==j)
		{
			if(isTrue) //if we are checking for true 
			{
				if(str.charAt(i)=='T')
					return 1; //if character is T
				else
					return 0; //if character is F
			}
			else
			{
				//if we are checking for false
				if(str.charAt(i)=='F')
					return 1; //if character is F
				else
					return 0; //if character is T
			}
		}
		
		
		int ans=0;
		for(int k=i+1;k<=j-1;k+=2)
		{
			int leftTrue=solve(str,i,k-1,true,storage); //Number of ways for the left expression to be true
			int rightFalse=solve(str,k+1,j,false,storage); //Number of ways for the right expression to be false
			int leftFalse=solve(str,i,k-1,false,storage); //Number of ways for the left expression to be false
			int rightTrue=solve(str,k+1,j,true,storage); //Number of ways for the right expression to be true
			
			
			//Based on operator calculate ans
			if(str.charAt(k)=='^') //if my current expression separated by '^'
			{
				if(isTrue)
				{
					//Number of ways to make current exp true
					ans+=leftTrue*rightFalse+rightTrue*leftFalse;
				}
				else
				{
					//Number of ways to make current exp false
					ans=leftTrue*rightTrue+leftFalse*rightFalse;
				}
			}
			else if(str.charAt(k)=='|') //if my current expression separated by '|'
			{
				if(isTrue)
				{
					//Number of ways to make current exp true
					ans+=leftTrue*rightFalse+leftFalse*rightTrue+leftTrue*rightTrue;
				}
				else
				{
					//Number of ways to make current exp false
					ans+=leftFalse*rightFalse;
				}
			}
			else if(str.charAt(k)=='&') //if my current expression separated by '&'
			{
				if(isTrue)
				{
					//Number of ways to make current exp true
					ans+=leftTrue*rightTrue;
				}
				else
				{
					//Number of ways to make current exp false
					ans+=leftFalse*rightFalse+leftTrue*rightFalse+leftFalse*rightTrue;
				}
			}	
		}
		
		if(isTrue)
		{
			return storage[i][j][1]=ans;
		}
		else
		{
			return storage[i][j][0]=ans;
		}
	}

}
