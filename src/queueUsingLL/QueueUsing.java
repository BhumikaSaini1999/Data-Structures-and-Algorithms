package queueUsingLL;

import queue.QueueEmptyException;

public class QueueUsing {

	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		
		QueueUsingLL<Integer> q=new QueueUsingLL<>();
		
		for(int i=0;i<10;i++)
		{
			q.enqueue(i+1);
		}
		
		while(!q.isEmpty())
		{
			System.out.println(q.dequeue());
		}

	}

}
