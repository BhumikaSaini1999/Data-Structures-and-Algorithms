package DP;

import java.util.Scanner;

//Exponential
//Time Complexity: O(2^k + 2^(n-k)), where k and n-k are the length of the two substrings.
//Auxiliary Space: O(2^N), recursion stack.
public class ScrambledStringRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		
		System.out.println(solve(a,b));
	}

	private static boolean solve(String a, String b) {
		// TODO Auto-generated method stub
		
		// 4 base cases
		if(a.length()!=b.length()) //if strings length are not same then they can't be scrambled
			return false;
		
		if(a.length()==0 && b.length()==0) //if both strings empty then scrambled
			return true;
		
		if(a.equals(b))  //if both a and b are equal then scrambled
			return true;
		
		if(a.length()<=1) //Means a and b are not equal=> Example=>1) a and b 2) a and ""
			return false;
		
		
		//Now calling recursively for checking scrambled strings or not
		int n=a.length(); //For sure the lengths are equal for both strings
		boolean flag=false; //representing flag or not
		
		for(int i=1;i<=n-1;i++)
		{
			//If condition 1 || condition 2 is true
			//Condition1 => when swap is happening , Condition2=> when swap not happening (Condition1 || Condition2)
			if((solve(a.substring(0,i),b.substring(n-i,n)) && solve(a.substring(i,n),b.substring(0,n-i))) || (solve(a.substring(0,i),b.substring(0,i)) && solve(a.substring(i,n),b.substring(i,n))))
			{
				flag=true; //then flag will be true
				break;
			}
		}
		return flag;
	}

}
