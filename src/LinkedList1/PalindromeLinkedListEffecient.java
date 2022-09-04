package LinkedList1;

import java.util.Scanner;

import LinkedList.Node;

//Time=>O(n),space=>O(1)
public class PalindromeLinkedListEffecient {
	
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
   
   public static int length(Node<Integer> head)  //Calculating length of LinkedList
   {
       int length=0;
       while(head!=null)
       {
           length++;
           head=head.next;
       }
       return length;
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
	   
	    if(head==null || head.next==null)
		   return true;
	   
	    Node<Integer> temp=head;
	    int length=length(head); //O(n)
	    int mid=length/2;
	    
	    int i=0;
	    while(i<mid-1) //O()
	    {
	    	temp=temp.next;
	    	i++;
	    }
	    Node<Integer> newHead=temp.next;
	    temp.next=null;
	    
	    Node<Integer> reversedHead=reverseLinkedList(newHead); //O(n)
	    
	    while(head!=null) //O(n/2)
	    {
	    	if(head.data!=reversedHead.data)
	    		return false;
	    	
	    	head=head.next;
	    	reversedHead=reversedHead.next;
	    }
		
		return true;
	}
   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=TakeInput();
		
		System.out.println(isPalindrome(head));

	}
}
