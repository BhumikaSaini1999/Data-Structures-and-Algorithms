package LinkedList2;

import java.util.Scanner;

import LinkedList.Node;

//you have been given two sorted(in ascending order) singly linked lists of integers.
//Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) 
//and return the new head to the list.
public class MergeTwoSortedLists {
	
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

     static void print(Node<Integer> head) //O(n)
 	 {
 		while(head!=null)
 		{
 			System.out.print(head.data+" ");
 			head=head.next;
 		}
 	 }
	
     
     public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter two sorted Linked Lists: ");
		Node<Integer> t1=TakeInput();
		Node<Integer> t2=TakeInput();
		
		Node<Integer> newHead=mergeTwoSortedLists(t1,t2);
		print(newHead);
	}

	private static Node<Integer> mergeTwoSortedLists(Node<Integer> t1, Node<Integer> t2) {
		// TODO Auto-generated method stub
		
		if(t1==null)
			return t2;
		if(t2==null)
			return t1;
		
		Node<Integer> finalHead=null,finalTail=null;
		if(t1.data<t2.data)
		{
			finalHead=t1;
			finalTail=t1;
		}
		else
		{
			finalHead=t2;
			finalTail=t2;
		}
		
		while(finalTail.next!=null)
		{
			if(t1.data<t2.data)
			{
				t1=t1.next;
				finalTail.next=t2;
				finalTail=t2;
			}
			else
			{
				t2=t2.next;
				finalTail.next=t1;
				finalTail=t1;
			}
		}
		
		if(t1.data<t2.data && t1.next==null)
			finalTail.next=t2;
		if(t2.data<t1.data && t2.next==null)
			finalTail.next=t1;
		return finalHead;
	}

}
