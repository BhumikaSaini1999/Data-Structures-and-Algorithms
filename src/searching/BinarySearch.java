package searching;

import java.util.Scanner;


//Time=>O(logn)
//Space=>O(1)
//Binary search applied only on sorted array
public class BinarySearch {

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
		int start=0,end=n-1;
		while(start<=end)
		{
			int mid=(start+end)/2;
			if(x==arr[mid])
			{
				flag=true;
				break;
			}
			
			if(x<arr[mid]) //if element is less than arr[mid], we should search in left part of array
				end=mid-1;
			
			if(x>arr[mid]) //if element is greater than arr[mid], we should search in right part of array
				start=mid+1;
		}
		
		System.out.println(flag);
	}

}
