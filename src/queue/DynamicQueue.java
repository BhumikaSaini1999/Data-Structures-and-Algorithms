package queue;

//Dynamic Circular Queue=> capacity is doubled when queue is full
//All operations are O(1)
public class DynamicQueue{
	
	private int data[];
	private int front;
	private int rear;
	private int size;
	
	public DynamicQueue()
	{
		data=new int[5];
		front=-1;
		rear=-1;
		size=0;
	}
	
	public DynamicQueue(int capacity)
	{
		data=new int[capacity];
		front=-1;
		rear=-1;
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
	
	public int front() throws QueueEmptyException
	{
		if(size()==0)
		{
			throw new QueueEmptyException();
		}
		int temp=data[front];
		return temp;
	}
	
	public void enqueue(int element)
	{
		if(size()==data.length)
		{
			doubleCapacity();
		}
			
		if(size()==0)
		{
			front++;
		}
		
		rear=(rear+1)%data.length; //rear always stays in between 0 to data.length-1
		
//		rear++;
//		if(rear==data.length)
//		{
//			rear=0;
//		}
		data[rear]=element;
		size++;
	}

	private void doubleCapacity() {
		
		int temp[]=data;
		data=new int[2*data.length];
		
		for(int i=front;i<temp.length;i++)
		{
			data[i]=temp[i];
		}
		
		for(int i=0;i<=front-1;i++)
		{
			data[i]=temp[i];
		}
		
		front=0;
		rear=temp.length-1;	
	}

	public int dequeue() throws QueueEmptyException
	{
		if(size()==0)
		{
			throw new QueueEmptyException();
		}
		
		int temp=data[front];
		
		front=(front+1)%data.length; //works in a circular fashion
//		front++;
//		if(front==data.length)
//			front=0;
		
		size--;
		return temp;
	}
	

}
