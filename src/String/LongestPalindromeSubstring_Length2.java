package String;

import java.util.Scanner;

//Time->O(2^n)
//Space=>O(n) {Recursive Call stack space}
//Using Recursion

public class LongestPalindromeSubstring_Length2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		
		//Returning MaxLength of Palindromic Substring
		System.out.println(lpSubstring(s,0,s.length()-1));
	}

	private static int lpSubstring(String s, int start, int end) {
		
		if(start>end)   //In case of even Palindromic substring
			return 0;
		if(start==end)  //In case of odd Palindromic substring
			return 1;
		
		if(s.charAt(start)==s.charAt(end))
		{
			int remainingLength=end-start-1;
			if(remainingLength==lpSubstring(s,start+1,end-1))
				return 2+remainingLength;
		}
		
		return Math.max(lpSubstring(s,start,end-1), lpSubstring(s,start+1,end));
	}

}
