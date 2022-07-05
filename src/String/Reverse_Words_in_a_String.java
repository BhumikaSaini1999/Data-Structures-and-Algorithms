package String;

import java.util.Scanner;


//Time & Space->O(n)=>number of words in a string
public class Reverse_Words_in_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		String arrofStr[]=s.split("\\s+");
		
		String res="";
		for(int i=arrofStr.length-1;i>=0;i--)
		{
			res+=arrofStr[i]+" ";
			
		}
		res=res.trim();
		System.out.println(res);
		
	}

}
