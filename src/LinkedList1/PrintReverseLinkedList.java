package LinkedList1;

//Recursive Approach
//Time->O(n)
//Space-> In terms of stack call space=>O(n)
import java.util.Scanner;

import LinkedList.Node;

public class PrintReverseLinkedList {
	
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
	
	public static void printReverse(Node<Integer> root) {  //Recursion
		//Your code goes here
        if(root==null)
            return;
        
        printReverse(root.next);
        
        System.out.print(root.data+" ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head=TakeInput();
		printReverse(head);
	}

}
