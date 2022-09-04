package LinkedList1;

import java.util.Scanner;

import LinkedList.Node;

//You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.

//Time=>O(n)+O(n)+O(n)=>duplication+reverse+comparison for palindrome=>O(n)
//Space=>O(n)
public class PalindromeLinkedList {
	
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
      
      
      private static void print(Node<Integer> head) {
  		// TODO Auto-generated method stub
  		
  		while(head!=null)
  		{
  			System.out.print(head.data+" ");
  			head=head.next;
  		}
  		
  	}
      
 
      public static boolean isPalindrome(Node<Integer> head) {//O(n)
  		//Your code goes here
          if(head==null || head.next==null)
              return true;
          
          Node<Integer> newHead=duplicateLinkedList(head);
          Node<Integer> reversedHead=reverseLinkedList(newHead);
          
          while(head!=null)
          {
        	  if(reversedHead.data!=head.data)
        		  return false;
        	  
        	  head=head.next;
        	  reversedHead=reversedHead.next;
        	  
          }
          return true;
  	}
      
      private static Node<Integer> reverseLinkedList(Node<Integer> head) { //O(n)
  		// TODO Auto-generated method stub
  		
  		if(head==null || head.next==null)
  			return head;
  		
  		Node<Integer> prev=null,curr=head,next=curr.next;
  		
  		while(curr!=null)
  		{
  			curr.next=prev;
  			prev=curr;
  			curr=next;
  			
  			if(curr!=null)
  			  next=curr.next;
  		}
  		return prev;
  	}

	private static Node<Integer> duplicateLinkedList(Node<Integer> head) {//O(n)
		// TODO Auto-generated method stub
		
		Node<Integer> newHead=null,prev=null;
		while(head!=null)
		{
			Node<Integer> newNode=new Node<Integer>(head.data);
			if(newHead==null)
			{
				newHead=newNode;
			}
			else
			{
				prev.next=newNode;
			}
			
			prev=newNode;
			head=head.next;
		}
		
		return newHead;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head=TakeInput();
		
		System.out.println(isPalindrome(head));
	}

}
