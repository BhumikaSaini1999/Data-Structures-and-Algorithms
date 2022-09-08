package LinkedList2;

import java.util.Scanner;

import LinkedList.Node;

//Naive approach=> calculate length of LL=> calculate mid index=>then traverse upto mid index=>return mid of LL
//2 pointer approach=> fast and slow pointers
//Time=>O(n),Space=>O(1)
public class Midpoint {
	
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
   
   public static Node<Integer> midPoint(Node<Integer> head) { //O(n/2)
       //Your code goes here
       
       if(head==null || head.next==null)
           return head;
       
       Node<Integer> slow=head,fast=head;
       
       //fast.next!=null=>for odd, fast.next.next=>for even
       while(fast.next!=null && fast.next.next!=null)
       {
           slow=slow.next;
           fast=fast.next.next;
       }
       return slow;
       
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=TakeInput();
		
		Node<Integer> mid=midPoint(head);
		System.out.println(mid.data);

	}

}
