package queueUsingLL;

import queue.QueueEmptyException;

public class QueueUsingLL<T> {
	
	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	public QueueUsingLL() {
		front=null;
		rear=null;
		size=0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return (size()==0);
	}
	
	public void enqueue(T element)
	{
		Node<T> newNode=new Node<T>(element);
		if(size()==0)
		{
			front=newNode;
			rear=newNode;
		}
		
		rear.next=newNode;
		rear=newNode;
		size++;
	}
	
	public T dequeue() throws QueueEmptyException
	{
		if(size()==0)
		{
			throw new QueueEmptyException();
		}
		
		T temp=front.data;
		
		front=front.next;
		if(size()==1) //if only 1 node in Queue
		{
			rear=null;
		}
		size--;
		return temp;
	}
	
	public T front() throws QueueEmptyException
	{
		if(size()==0)
			throw new QueueEmptyException();
        
        T temp=front.data;
        return temp;
	}

}
