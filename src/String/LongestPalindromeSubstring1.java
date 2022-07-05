package String;

import java.util.Scanner;

//Time->O(n^3)
//Space=>O(1)
//Brute Force Approach=>generate all the substrings and => for each substring check whether its palindrome or not=>if its palindrome find the max length
//Total possible substrings=(n*(n+1))/2
//For "abc"=>Total Possible substrings=>"a","ab","abc","b","bc","c"=>6
public class LongestPalindromeSubstring1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		
		
		int length=1,maxlength=1,count=0;
		String res="",subStr="";
		
		for(int i=0;i<s.length();i++)
		{
			for(int j=i+1;j<=s.length();j++)
			{
				subStr=s.substring(i, j);
				count++;
				//System.out.println(subStr);
				
				int k=0,l=subStr.length()-1;
				boolean flag=false;
				
				while(k<=l)
				{
				   if(subStr.charAt(k)==subStr.charAt(l))
				   {
					   flag=true;
					   k++;
					   l--;
				   }
				   else
				   {
					   flag=false;
					   break;
				   }
				}
				
				if(subStr.length()==1 && maxlength==1)//To solve the edge cases like input="ac" || "a"
					res=subStr;
				
				if(flag==true)
				{
					length=subStr.length();
					if(length>maxlength)
					{
						maxlength=length;
						res=subStr;
					}
				}
				length=1;
			}
			
		}
		
		System.out.println("MaxSubstring Length= "+maxlength+", "+"MaxSubstring= "+res);
		System.out.println("Total Possible substrings="+count);
	}

}
