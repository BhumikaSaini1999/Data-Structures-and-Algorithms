package Stack;

//Time complexity of Stack Operations=>O(1)
public class StackUsingArray {
	
	private int data[];
	private int top;
	
	public StackUsingArray()
	{
		data=new int[5];
		top=-1;
	}
	
	public StackUsingArray(int capacity)
	{
		data=new int[capacity];
		top=-1;
	}
	
	public int size() {  //O(1)
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
	
	public void push(int element) throws StackFullException { //O(1)
		
		if(size()==data.length)
		{
			throw new StackFullException();
		}
		
		top++;
		data[top]=element;
	}
	
	public int pop() throws StackEmptyException { //O(1)
		
		if(top==-1)
		{
			throw new StackEmptyException();
		}
		
		int temp=data[top];
		top--;
		return temp;
	}
}
