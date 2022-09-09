package queue;

import java.util.Stack;

//Here enqueue operation is ineffecient
public class QueueUsing2Stacks {
	
	private Stack<Integer> s1=new Stack<Integer>();
	private Stack<Integer> s2=new Stack<Integer>();

	public int size() //O(1)
	{
		return s1.size();
	}
	
	public boolean isEmpty() //O(1)
	{
		return (s1.size()==0);
	}
	
	public int front() //O(1)
	{
		return s1.peek();
	}
	
	public void enqueue(int element) //O(n)
	{
	   if(s1.size()==0)
	   {
		   s1.push(element);
	   }
	   else
	   {
		   while(!s1.isEmpty())
		   {
			   s2.push(s1.pop());
		   }
		   s1.push(element);
		   
		   while(!s2.isEmpty())
		   {
			   s1.push(s2.pop());
		   }
	   }
	}
	
	public int dequeue() throws QueueEmptyException //O(1)
	{
		if(s1.size()==0)
		{
			throw new QueueEmptyException();
		}
		int temp=s1.pop();
		return temp;
	}
	
	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub

		QueueUsing2Stacks q=new QueueUsing2Stacks();
		
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
