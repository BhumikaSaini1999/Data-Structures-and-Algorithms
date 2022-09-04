package LinkedList1;

//You have been given a singly linked list of integers. 
//Write a function that returns the index/position of integer data denoted by 'N' (if it exists). Return -1 otherwise.

//Input Format
//The first line contains an Integer 'T' which denotes the number of test cases. 
//The first line of each test case or query contains the elements of the singly linked list separated by a single space. 
//The second line contains the integer value 'N'. It denotes the data to be searched in the given singly linked list.

//Sample Input 1:
//2
//3 4 5 2 6 1 9 -1
//5
//10 20 30 40 50 60 70 -1
//6

//Sample Output 1 :
//2
//-1

import java.util.Scanner;

import LinkedList.Node;

public class FindNodeinLL {
	
     static Node<Integer> TakeInput(){
		
		Node<Integer> head=null;
		Node<Integer> tail=null;
		
		System.out.println("Enter Data of Nodes:");
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		
		while(data!=-1)
		{
			Node<Integer> newNode=new Node<Integer>(data);
			if(head==null)
			{
				head=newNode;
				tail=newNode;
			}
			else
			{
				tail.next=newNode;  //O(n)
				tail=tail.next;
			}
			
			data=sc.nextInt();
		}	
		return head;
	}
     
     public static int findNode(Node<Integer> head, int n) {
 		// Write your code here.
         
         Node<Integer> temp=head;
         int i=0;
         
         while(temp!=null) //In worst case it is O(n)
         {
             if(temp.data==n)
                 return i;
             
             temp=temp.next;
             i++;
         }
         
         return -1;
 	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=TakeInput();
		
		System.out.println(findNode(head,13));
    }

}
