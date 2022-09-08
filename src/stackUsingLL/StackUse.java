package stackUsingLL;

import Stack.StackEmptyException;

public class StackUse {

	public static void main(String[] args) throws StackEmptyException {
		// TODO Auto-generated method stub
		
//		stackUsingLL<Integer> stack=new stackUsingLL<>();
//		
//		for(int i=0;i<10;i++)
//		{
//			stack.push(i+1);
//		}
//		
//		System.out.println("Current size of stack is "+stack.size());
//		while(!stack.isEmpty())
//		{
//			System.out.println(stack.pop()+"-->"+stack.size());
//		}
//		
		//System.out.println(stack.pop());
		
		StackUsingLL_Ineffecient<Integer> stack1=new StackUsingLL_Ineffecient<>();
		
		for(int i=0;i<10;i++)
		{
			stack1.push(i+1);
		}
		
		System.out.println("Current size of stack is "+stack1.size());
		while(!stack1.isEmpty())
		{
			System.out.println(stack1.pop()+"-->"+stack1.size());
		}
		//System.out.println(stack1.pop());
	}

}
