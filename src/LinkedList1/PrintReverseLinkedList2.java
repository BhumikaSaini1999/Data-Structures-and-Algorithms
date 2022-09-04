package LinkedList1;

//Iterative Approach
//Time->O(n^2)
//Space-> O(1)
import java.util.Scanner;

import LinkedList.Node;

public class PrintReverseLinkedList2 {
	
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
	
	public static void printReverse(Node<Integer> root) {  //Recursion
		//Your code goes here
		
		int length=length(root);
		
		for(int i=length-1;i>=0;i--)  //O(n^2)
		{
			Node<Integer> temp=root;
			int j=0;
			while(j<i)
			{
				temp=temp.next;
				j++;
			}
		    System.out.print(temp.data+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head=TakeInput();
		printReverse(head);
	}

}
