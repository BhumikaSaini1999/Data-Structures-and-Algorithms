package LinkedList1;

//You have been given a singly linked list of integers along with an integer 'N'. 
//Write a function to append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.

//Input Format:
//The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//The first line of each test case or query contains the elements of the singly linked list separated by a single space. 
//The second line contains the integer value 'N'. It denotes the number of nodes to be moved from last to the front of the singly linked list.

//Sample Input 1 :
//2
//1 2 3 4 5 -1
//3
//10 20 30 40 50 60 -1
//5
//Sample Output 1 :
//3 4 5 1 2
//20 30 40 50 60 10

import java.util.Scanner;

import LinkedList.Node;

public class AppendLastNtoFirst {
	
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
     
     public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
 		//Your code goes here
         
         if(head==null)  //Edge Case
             return head;
         
         int pos=length(head)-n; //position of node which will be new head
         Node<Integer> temp=head;
         
         
         while(temp.next!=null)
         {
             temp=temp.next;
         }
         
         temp.next=head; //Last node of current LL will point next to head
         
         temp=head;
         int i=0;
         while(i<pos-1) //traverse LL till previous of pos Node
         {
             temp=temp.next;
             i++;
         }
         
         Node<Integer> posNode=temp.next; //saving pos node
         temp.next=null; //previous of pos Node will point next to null
         
         head=posNode; //new head of pos Node
         return head;
 	}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Node<Integer> head=TakeInput();
			
			System.out.println(appendLastNToFirst(head,3));
	    }

}
