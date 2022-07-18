package Sorting;

import java.util.Scanner;

//Simple Sorts=>Bubble,Insertion,Selection
//Effecient Sorts=>Merge,Heap,Quick


//Time in Worst Case=>O(n^2)
//Time in Best case=>O(1)
//Space=>O(1)
//Bubble Sort is Inplace Sorting Algo.
public class BubbleSortOptimised {

	public static void main(String args[])
	{
        Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter size of array:");
		int n=sc.nextInt();
		
		int arr[]=new int[n];
		System.out.println("Enter array elements:");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		BubbleSort(arr,n);
		System.out.println("The sorted Array is: ");
		for(int i:arr)
			System.out.print(i+" ");
	}

	private static int[] BubbleSort(int[] arr, int n) {
		
		for(int i=0;i<arr.length-1;i++) //Total Pass=n-1
		{
			boolean flag=false; //This is using, if array is already sorted then no need to go for each n every pass, it will break from loop after checking condition
			
			for(int j=0;j<arr.length-i-1;j++) //In each pass=>we are doing comparisons=>and it decreases by 1 in each pass as bcoz in each pass 1 element already sorted and come at last
			{
				if(arr[j]>arr[j+1])//If ist element greater than second ,then do swap
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=true;
				}
			}
			
			if(flag==false)
				break;
		}
		
		return arr;
	}
}
