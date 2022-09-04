package LinkedList1;

import java.util.Scanner;

import LinkedList.Node;

//Time->O(n),Space=>O(1)
public class ReverseLinkedList {
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head=TakeInput();
		head=reverseLinkedList(head);
		print(head);

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

	private static void print(Node<Integer> head) {
		// TODO Auto-generated method stub
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		
	}

}
