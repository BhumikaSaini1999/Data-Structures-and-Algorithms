package searching;

import java.util.Scanner;

//Time-> Worst=>O(n), Best=>O(1)
//Space->O(1)
public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter size of array:");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter array elements:");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Enter element which you want to search:");
		int x=sc.nextInt();
		
		boolean flag=false;
		for(int i=0;i<arr.length;i++)
		{
			if(x==arr[i])
			{
				flag=true;
				break;
			}
		}
		
		
		System.out.println(flag);
	}

}
