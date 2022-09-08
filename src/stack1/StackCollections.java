package stack1;

import java.util.Stack;

public class StackCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack=new Stack<Integer>();
		int arr[]= {34,78,90,12,34,56};
		
		for(int i:arr)
		{
			stack.push(i);
		}
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.peek());
			stack.pop();
		}

	}

}
