package LinkedList;

import java.util.Scanner;

public class TakeInput {
	
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
//				Node<Integer> temp=head;
//				while(temp.next!=null)  //O(n^2)
//				{
//					temp=temp.next;
//				}
//				temp.next=newNode;
				
				
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
	
	static int length(Node<Integer> head)  //O(n)
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
        print(head);
        
        System.out.println();
        System.out.println("Length of LinkedList= "+length(head));
	}
}
