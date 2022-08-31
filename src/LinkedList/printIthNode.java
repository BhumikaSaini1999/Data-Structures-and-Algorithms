package LinkedList;

import java.util.Scanner;

public class printIthNode {
	
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

    public static void printIthNode(Node<Integer> head, int i){
	//Your code goes here
    
    int tempIndex=0;
    while(head!=null)
    {
        if(tempIndex==i)
        {
            System.out.print(head.data);
            return;
        }
        
        head=head.next;
        tempIndex++;
    }
}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=TakeInput();
		printIthNode(head,4);
	}

}
