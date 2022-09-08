package Stack;

public class StackWithUnlimitedCapacity {
	
	private int data[];
	private int top;
	
	public StackWithUnlimitedCapacity()
	{
		data=new int[5];
		top=-1;
	}
	
	public StackWithUnlimitedCapacity(int capacity)
	{
		data=new int[capacity];
		top=-1;
	}
	
	public int size() { //O(1)
		return top+1;
	}
	
	public boolean isEmpty() //O(1)
	{
		return (top==-1);
	}
	
	public int top() throws StackEmptyException { //O(1)
		
		if(top==-1)
		{
			throw new StackEmptyException();
		}
		
		int temp=data[top];
		return temp;
	}
	
	public void push(int element){ //O(n) only if capacity is getting doubled otherwise O(1)
		
		if(size()==data.length)
		{
			//Double capacity of previous capacity 
			int temp[]=new int[data.length];
			for(int i=0;i<data.length;i++)
			{
				temp[i]=data[i];
			}
			
			int newCapacity=data.length*2;
			data=new int[newCapacity];
			
			for(int i=0;i<temp.length;i++)
			{
				data[i]=temp[i];
			}	
		}
		
		top++;
		data[top]=element;
	}
	
	public int pop() throws StackEmptyException {  //O(1)
		
		if(top==-1)
		{
			throw new StackEmptyException();
		}
		
		int temp=data[top];
		top--;
		return temp;
	}
}
