package DP;

import java.util.HashMap;
import java.util.Scanner;

//Time Complexity: O(N^3) as MCM, where N is the length of the given strings.
//Auxiliary Space: O(N^2), As we need to store O(N^2) string in our map.
public class ScrambledStringMem {
	
	static HashMap<String,Boolean> map=new HashMap<String,Boolean>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		
		map.clear();
		System.out.println(solve(a,b));
	}

	private static boolean solve(String a, String b) {
		// TODO Auto-generated method stub
		
		//Creating key for map (Memoization)
		String key=a+" "+b;
		if(map.containsKey(key))
			return map.get(key);
		
		if(a.length()!=b.length())
		{
			map.put(key, false);
			return map.get(key);
		}
		if(a.length()==0 && b.length()==0)
		{
			map.put(key, true);
			return map.get(key);
		}
		if(a.equals(b))
		{
			map.put(key, true);
			return map.get(key);
		}
		if(a.length()<=1)
		{
			map.put(key, false);
			return map.get(key);
		}
		
		int n=a.length();
		boolean flag=false;
		for(int i=1;i<=n-1;i++)
		{
			//Condition 1=>when swap , Condition2=>not swap
			boolean cond1=solve(a.substring(0,i),b.substring(n-i,n)) && solve(a.substring(i,n),b.substring(0,n-i));
			boolean cond2=solve(a.substring(0, i),b.substring(0, i)) && solve(a.substring(i,n),b.substring(i, n));
			
			if(cond1 ||  cond2)
			{
				flag=true;
				break;
			}
		}
		map.put(key, flag);
		return map.get(key);
	}

}
