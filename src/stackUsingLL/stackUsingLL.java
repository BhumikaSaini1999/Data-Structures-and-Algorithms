package stackUsingLL;

import Stack.StackEmptyException;

//More effecient =>All operations are O(1)=> Here we are inserting the element at the beginning of LL and updating head everytime
public class stackUsingLL<T>{
	
	private Node<T> head;
	private int size; //Its required otherwise to calculate the length of LL we have to traverse each time which will be =>O(n)
	                  // By using this size we are making ensure to size++ while pushing and size-- while popping
	
	public stackUsingLL() {
		head=null;
		size=0;	
	}
	
	public boolean isEmpty() {
		
		return (size==0);
	}
	
	public int size() {
		return size;
	}
	
	public T top() throws StackEmptyException {
		
		if(size()==0) //if head==null that is also making ensure that stack is empty
		{
			throw new StackEmptyException();
		}
		
		return head.data;
	}
	
	public void push(T element) {
		
		Node<T> newNode=new Node<>(element);
		newNode.next=head;
		head=newNode;
		
		size++;
	}
	
	public T pop() throws StackEmptyException {
		
		if(size()==0)
		{
			throw new StackEmptyException();
		}
		
		T temp=head.data;
		
		head=head.next;
		size--;
		return temp;
	}

}
