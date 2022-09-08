package stackUsingLL;

import Stack.StackEmptyException;

//Here elements we are pushing at the tail node
//O(n)=>pop() except this all are O(1)

public class StackUsingLL_Ineffecient<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public StackUsingLL_Ineffecient() {
		head=null;
		tail=null;
		size=0;	
	}
	
	public int size() { //O(1)
		return size;
	}
	
	public boolean isEmpty() { //O(1)
		return (size()==0);
	}
	
	public void push(T element) { //O(1)
		
		Node<T> newNode=new Node<T>(element);
		
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
		size++;	
	}
	
	public T top() throws StackEmptyException {//O(1)

		
		if(size()==0)
		{
			throw new StackEmptyException();
		}
		
		T temp=tail.data;
		return temp;	
	}
	
	public T pop() throws StackEmptyException { //O(n)=>Bcoz to delete the last node, anyways we have to traverse the LL
		
		if(size()==0)
		{
			throw new StackEmptyException();
		}
		
		T removeData=tail.data;
		
		int pos=size()-1-1; //position index which has an access of last node
		Node<T> temp=head;
		
		int i=0;
		while(i<pos-1)
		{
			temp=temp.next;
			i++;
		}
		temp.next=null;
		size--;
		
		return removeData;
	}

}
