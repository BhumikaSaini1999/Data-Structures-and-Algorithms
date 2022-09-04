package LinkedList1;

import java.util.Scanner;

import LinkedList.Node;

//Time=>O(n),Space=>O(1)
public class PalindromeLinkedListBetter {
	
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

    private static Node<Integer> reverseLinkedList(Node<Integer> newHead) {
		
 	   Node<Integer> curr=newHead,prev=null,next=curr.next;
 	   
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
    
    private static boolean isPalindrome(Node<Integer> head) {
		// TODO Auto-generated method stub
    	
    	Node<Integer> fast=head,slow=head;
    	
    	//Using slow and fast pointers approach we are finding out midpoint
    	while(fast.next!=null && fast.next.next!=null) //O(n/2)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	Node<Integer> newHead=slow.next; //slow gives us mid point
    	slow.next=null;
    	
    	Node<Integer> reversedHead=reverseLinkedList(newHead); //O(n)
    	
    	while(reversedHead!=null) //O(n/2)
    	{
    		if(head.data!=reversedHead.data)
    			return false;
    		reversedHead=reversedHead.next;
    		head=head.next;
    	}
		return true;
	}
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        Node<Integer> head=TakeInput();
		
		System.out.println(isPalindrome(head));

	}

}
