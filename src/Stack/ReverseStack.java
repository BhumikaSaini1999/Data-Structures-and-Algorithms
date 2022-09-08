package Stack;

import java.util.Stack;

//Time=>O(n*n),space=>O(1)[Not using extra space]
//Auxiliary space=>O(n)

//Reverse stack without using extra space=>Recursion
public class ReverseStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack);
		reverse(stack);
		System.out.println(stack);
		

	}

	private static void reverse(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		
		if(stack.isEmpty())
			return;
		
		int x=stack.pop();
		reverse(stack);
		insertAtBottom(x,stack);
	}

	private static void insertAtBottom(int x, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		
		if(stack.isEmpty())
		{
			stack.push(x);
			return;
		}
		
		int a=stack.pop();
		insertAtBottom(x,stack);
		stack.push(a);
		
	}

}
