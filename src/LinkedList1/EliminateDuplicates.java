//Eliminate duplicates from LL
//You have been given a singly linked list of integers where the elements are sorted in ascending order.
//Write a function that removes the consecutive duplicate values such that the given list only contains unique elements and returns the head to the updated list.

//Input format :
//The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
//The first and the only line of each test case or query contains the elements(in ascending order) of the singly linked list separated by a single space.

//Sample Input 1 :
//1
//1 2 3 3 3 3 4 4 4 5 5 7 -1
//Sample Output 1 :
//1 2 3 4 5 7 

//Sample Input 2 :
//2
//10 20 30 40 50 -1
//10 10 10 10 -1
//Sample Output 2 :
//10 20 30 40 50
//10


package LinkedList1;

import java.util.Scanner;

import LinkedList.Node;

public class EliminateDuplicates {
	
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
	
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		//Your code goes here
        
        if(head==null || head.next==null)
            return head;
        
        Node<Integer> currNode=head;
        Node<Integer> nextNode=head.next;
        Node<Integer> prevNode=null;
        
        boolean flag=false;
        while(currNode.next!=null)
        {
            int currData=currNode.data;
            int nextData=nextNode.data;
            
            if(currData!=nextData)
            {
               if(flag==true)
               {
                   prevNode.next=currNode.next;
                   flag=false;
               }
            }
            else
            {
                if(flag==false)  //if duplicate found first time then save currNode in prevNode
                {
                    prevNode=currNode;
                    flag=true;
                }
            }
            
            currNode=currNode.next;
            nextNode=currNode.next;
        }
        
        if(flag==true) // In case of input=> 10->10->10->10->10
        {
            prevNode.next=currNode.next;
        }
        
        return head;
        
        
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head=TakeInput();
		removeDuplicates(head);

	}

}
