package queue;

public class QueueUsing {

	public static void main(String[] args) throws QueueFullException, QueueEmptyException {
		// TODO Auto-generated method stub
		
//		MyQueue q=new MyQueue();
//		
//		for(int i=0;i<5;i++)
//		{
//			q.enqueue(i);
//		}
//		
//		while(!q.isEmpty())
//		{
//			System.out.println(q.dequeue());
//		}
		
		//System.out.println(q.dequeue());
		
		
		DynamicQueue q=new DynamicQueue();
		for(int i=0;i<20;i++)
		{
			q.enqueue(i);
		}
		
		while(!q.isEmpty())
		{
			System.out.println(q.dequeue());
		}
	}

}
