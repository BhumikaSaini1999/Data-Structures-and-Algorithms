package DP;


//Time Complexity=>O(n^3)
//Space Complexity=>O(n^2)+O(n^2)
import java.util.Scanner;

public class BooleanParenthesization_DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		System.out.println(solve(str));

	}

	static int solve(String str)
	{
		int n=str.length();
		int[][] dpt=new int[n][n];
		int[][] dpf=new int[n][n];
		
		for(int g=0;g<n;g++)
		{
			for(int i=0,j=g;j<n;i++,j++)
			{
				if(g==0)
				{
					if(str.charAt(i)=='T')
					{
						dpt[i][j]=1;
						dpf[i][j]=0;
					}
					else if(str.charAt(i)=='F')
					{
						dpt[i][j]=0;
						dpf[i][j]=1;
					}
				}
				else
				{
					int ansTrue=0,ansFalse=0;
					for(int k=i+1;k<j;k+=2)
					{
						int ltc=dpt[i][k-1];
						int rtc=dpt[k+1][j];
						int lfc=dpf[i][k-1];
						int rfc=dpf[k+1][j];
						
						if(str.charAt(k)=='&')
						{
							ansTrue+=ltc*rtc;
							ansFalse+=ltc*rfc+lfc*rtc+lfc*rfc;
						}
						else if(str.charAt(k)=='|')
						{
							ansTrue+=ltc*rfc+lfc*rtc+ltc*rtc;
							ansFalse+=lfc*rfc;
						}
						else
						{
							ansTrue+=ltc*rfc+lfc*rtc;
							ansFalse+=ltc*rtc+lfc*rfc;
						}
					}
					
					dpt[i][j]=ansTrue;
					dpf[i][j]=ansFalse;
				}
			}
		}
		return dpt[0][n-1];
	}

}
