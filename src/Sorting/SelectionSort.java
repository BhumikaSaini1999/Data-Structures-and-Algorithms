package Sorting;

import java.util.Scanner;


//Time=>O(n^2)
//Space=>O(1)
public class SelectionSort {

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
		
		SelectionSort(arr,n);
		System.out.println("The sorted Array is: ");
		for(int i:arr)
			System.out.print(i+" ");
	}

	private static void SelectionSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		for(int i=0;i<n-1;i++) //Total Passes are n-1
		{
			
			int min=Integer.MAX_VALUE;
			int minIndex=-1;
			
			for(int j=i;j<n;j++)// Need to find out the min element from unsorted array
			{
				if(arr[j]<min)
				{
					min=arr[j];
					minIndex=j;
				}
			}
			
			if(minIndex!=i) //If min element found at index where the element needs to be swapped so swap is not required
			{
				int temp=arr[minIndex];
				arr[minIndex]=arr[i];
				arr[i]=temp;
			}
		}
	}

}
