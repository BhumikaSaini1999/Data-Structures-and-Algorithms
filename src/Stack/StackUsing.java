package Stack;

public class StackUsing {

	public static void main(String[] args) throws StackEmptyException{
		// TODO Auto-generated method stub
		
//		StackUsingArray stack=new StackUsingArray(20);
//		stack.push(89);
//		stack.push(78);
//		stack.push(23);
//		stack.push(45);
//		stack.push(67);
//		stack.push(100);
//		stack.push(101);
		
//		while(!stack.isEmpty())
//		{
//			System.out.println(stack.pop());
//		}
		
		
		StackWithUnlimitedCapacity stack1=new StackWithUnlimitedCapacity(2);
		stack1.push(89);
		stack1.push(78);
		stack1.push(23);
		stack1.push(45);
		stack1.push(67);
		stack1.push(100);
		stack1.push(101);
		stack1.push(90);
		
		while(!stack1.isEmpty())
		{
			System.out.println(stack1.pop());
		}
		
	}

}
