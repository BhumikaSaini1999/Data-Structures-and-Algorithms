package Sorting;

import java.util.Scanner;

//Time=>O(nlogn)
//Space=>O(n)
//Its not In-Place algorithm.
public class MergeSort {

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
			
			mergeSort(arr,0,n-1);
			System.out.println("The sorted Array is: ");
			for(int i:arr)
				System.out.print(i+" ");

	}

	//O(logn)
	private static void mergeSort(int[] arr, int l, int h) {
		// TODO Auto-generated method stub
		if(l<h)
		{
			int mid=(l+h)/2; //l+(h-l)/2;=>mostly this is preferred because in some of the platforms (l+h)/2=>give extreme high values if l and h are very large
			mergeSort(arr,l,mid);
			mergeSort(arr,mid+1,h);
			merge(arr,l,mid,h);
		}	
	}

	//O(n)
	private static void merge(int[] arr, int l, int mid, int h) {
		// TODO Auto-generated method stub
		
		int i=l;
		int j=mid+1;
		int k=0;
		
		int b[]=new int[h-l+1];
		
		while(i<=mid && j<=h) //Comparing the elements of two divided arrays
		{
			if(arr[i]<=arr[j])
			{
				b[k]=arr[i];
				i++;
				k++;
			}
			else
			{
				b[k]=arr[j];
				j++;
				k++;
			}
		}
		
		if(i<=mid) //copying the remaining elements back to b[] as it is, if still i<=mid
		{
			while(i<=mid)
			{
				b[k]=arr[i];
				i++;
				k++;
			}
		}
		
		if(j<=h) //copying the remaining elements back to b[] as it is, if still j<=h
		{
			while(j<=h)
			{
				b[k]=arr[j];
				j++;
				k++;
			}
		}
		
		//copy b[] to arr[]=> As b[] is used for only for merging purpose
		
		for(i=l,k=0;k<b.length;k++)
		{
			arr[l++]=b[k];
		}
		
	}

}
