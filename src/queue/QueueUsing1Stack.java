package queue;

import java.util.Stack;

public class QueueUsing1Stack {
	
	private Stack<Integer> stack=new Stack<Integer>();
	
	public int size() //O(1)
	{
		return stack.size();
	}
	
	public boolean isEmpty() //O(1)
	{
		return stack.size()==0;
	}

	public void enqueue(int element) //O(n)
	{
		if(stack.size()==0)
		{
			stack.push(element);
			return;
		}
		
		int x=stack.pop();
		enqueue(element); //Recursion stack
		stack.push(x);
		
	}
	
	public int dequeue() throws QueueEmptyException //O(1)
	{
		if(stack.size()==0)
			throw new QueueEmptyException();
		
		int temp=stack.pop();
		return temp;
	}
	
	public int front() throws QueueEmptyException //O(1)
	{
		if(stack.size()==0)
			throw new QueueEmptyException();
		
		int temp=stack.peek();
		return temp;
	}
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		
		QueueUsing1Stack q=new QueueUsing1Stack();
		
		for(int i=0;i<10;i++)
		{
			q.enqueue(i+1);
		}
		
		while(!q.isEmpty())
		{
			System.out.println(q.front());
			q.dequeue();
		}

	}

}
