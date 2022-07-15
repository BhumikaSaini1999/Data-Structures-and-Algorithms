package DP;

import java.util.HashMap;
import java.util.Scanner;

//T(C)=>exponential
//S(C)=>O(n)


public class BooleanParenthesization_MapMem {

	static HashMap<String,Integer> map=new HashMap<String,Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		map.clear();
		//Initial Index of string=i=0, Final Index of string=j=n-1
		//Passing true to check the number of ways in which whole expression can be evaluated as true, Its important to pass this boolean variable bcoz
		//We have | and ^ operator in which its equally important to know the number of times an expression can come as false 
		System.out.println(solve(str,0,str.length()-1,true));
	}

	private static int solve(String str, int i, int j, boolean isTrue) {
		
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
		
		
		
		//Setting Map=>Here key consist of i,j and isTrue=>Which will give unique key
		String keyString=Integer.toString(i)+" "+Integer.toString(j)+" "+Boolean.toString(isTrue);
		if(map.containsKey(keyString))
			return map.get(keyString);
		else
		{
			map.put(keyString,0);
		}
		
		
		
		
		
		
		
		
		int ans=0;
		
		//k variable is taken here to move onto operator
		//K would obviously be at 2nd position after Ist character and likewise in the whole expression it would be at i+1 if str starts at i pos
		//k+=2 Here we are increamenting k as 2 bcoz its always at 2nd position
		for(int k=i+1;k<=j-1;k+=2)
		{
			int leftTrue=solve(str,i,k-1,true); //Number of ways for the left expression to be true
			int rightFalse=solve(str,k+1,j,false); //Number of ways for the right expression to be false
			int leftFalse=solve(str,i,k-1,false); //Number of ways for the left expression to be false
			int rightTrue=solve(str,k+1,j,true); //Number of ways for the right expression to be true
			
			
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
		
		map.put(keyString, ans);
		//Now returning ans
		return ans;
	}

}
