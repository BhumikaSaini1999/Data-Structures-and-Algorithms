package Sorting;

import java.util.Scanner;

//Try with input=>3,1,4,9,7 and 95,13,47,52,41,68,42
//Time in Best Case=>O(nlogn)=>logn is for height of recursion tree=> if array is dividing into 2 parts equally, as pivot is coming in mid.
//Time in Worst case=>O(n^2 logn)=>If array is already sorted
//Space=>O(n)=>Recursion Stack
//Its Inplace sorting algo
public class QuickSort {

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
		
		QuickSort(arr,0,n-1);
		System.out.println("The sorted Array is: ");
		for(int i:arr)
			System.out.print(i+" ");

	}

	private static void QuickSort(int[] arr, int l, int h) {
		// TODO Auto-generated method stub
		
		if(l<h)
		{
			int pivotIndex=partition(arr,l,h);
			QuickSort(arr,l,pivotIndex-1);
			QuickSort(arr,pivotIndex+1,h);
		}
	}

	private static int partition(int[] arr, int l, int h) {
		// TODO Auto-generated method stub
		int pivot=arr[l];  // Here we are taking first element as pivot
		int i=l,j=h;
		
		while(i<j)
		{
			//Logic: i<=h is required to write, If the pivot element is the largest element at any point in the recursion, 
            //i will keep on incrementing and will ultimately result in an ArrayIndexOutOfBoundsException. 
			//Hence, we need to have a check before the equality condition as due to the lazy operation of Logical AND, 
			//if the first condition fails, 2nd won't be checked. 
			//The same thing is not required in the 2nd while loop as j will never go less than i
			while(i<=h && arr[i]<=pivot)i++;
			while(arr[j]>pivot)j--; //j>l not required here=> bcoz if all elements are greater and equal to pivot, it will automatically fail for pivot element
			
			if(i<j)
			{
				//Swap element at i and j=> after doing this, the element less than pivot come at i and element greater than pivot come at j
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				
				//do not write i++ and j-- here,=> failing for 95,13,47,52,41,68,42
			}
		}
		//Swap element at j and pivot Element which is at l
		int temp=arr[l];
		arr[l]=arr[j];
		arr[j]=temp;
		return j;
	}

}
