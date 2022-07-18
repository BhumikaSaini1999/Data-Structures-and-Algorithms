package Sorting;

import java.util.Scanner;

//Time=>O(n^2)
//Space=>O(1)
//Its a little bit optimized version as compare to Bubble Sort Bcoz number of operations(comparisons and swaps) are less. 
//Its inPlace Sorting Algo
public class InsertionSort {

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
		
		InsertionSort(arr,n);
		System.out.println("The sorted Array is: ");
		for(int i:arr)
			System.out.print(i+" ");

	}

	private static void InsertionSort(int[] arr, int n) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<n;i++) //Traversing for unsorted array from index 1 as element at 0th index is already sorted
		{
			int temp=arr[i]; //Pick ist element from unsorted part
			int j=i-1; //Unsorted part starts from i-1, just the previous element from ist element of unsorted part 
			for(;j>=0;j--) //Go back in reverse order in sorted part to compare with temp
			{
				if(arr[j]>temp) //if element present in sorted part greater than temp, then that element needs to be shifted to next position
					arr[j+1]=arr[j];
				else
					break;      //if element present in sorted part less than temp then no need to check further as other elements will surely be less than temp
			}
			arr[j+1]=temp;  //After this,we need to set the temp at correct position as we found its correct position
		}
	}

}
