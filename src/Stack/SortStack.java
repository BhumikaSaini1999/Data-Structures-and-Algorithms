package Stack;

import java.util.Stack;

//Sort stack=> largest element at the top and smallest element at the bottom.
//Time=>O(n*n),space=>O(1)[Not using extra space]
//Auxiliary space=>O(n)

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(11);
		stack.push(2);
		stack.push(32);
		stack.push(3);
		stack.push(41);
		
		System.out.println(stack);
		sort(stack);
		System.out.println(stack);

	}

	private static void sort(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		
		if(stack.isEmpty())
			return;
		
		int x=stack.pop();
		sort(stack);
		insertAtCorrectPosition(x,stack);
	}

	private static void insertAtCorrectPosition(int x, Stack<Integer> stack) {
		// TODO Auto-generated method stub
		
		if(stack.isEmpty())
		{
			stack.push(x);
			return;
		}
		
		if(stack.peek()<x)
		{
			stack.push(x);
		}
		else
		{
			int a=stack.pop();
			insertAtCorrectPosition(x,stack);
			stack.push(a);
		}
	}

}
