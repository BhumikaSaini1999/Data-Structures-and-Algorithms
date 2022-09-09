package queue;

import java.util.LinkedList;
import java.util.Queue;

import Stack.StackEmptyException;

//When pop operation is ineffecient
public class StackUsing2Queues_Pop {

	private Queue<Integer> q1 = new LinkedList<Integer>();
	private Queue<Integer> q2 = new LinkedList<Integer>();

	public int size() // O(1)
	{
		return q1.size();
	}

	public boolean isEmpty() // O(1)
	{
		return (size() == 0);
	}

	public void push(int element) // O(1)
	{
		q1.add(element);
	}

	public int pop() throws StackEmptyException // O(n)
	{
		if (q1.size() == 0) {
			throw new StackEmptyException();
		}

		int n = q1.size() - 1;
		while (n > 0) {
			q2.add(q1.remove());
			n--;
		}
		int res = q1.remove();

		Queue<Integer> temp = new LinkedList<Integer>();// Swap q1 and q2
		temp = q1;
		q1 = q2;
		q2 = temp;

		return res;
	}

	public int top() throws StackEmptyException // O(n)
	{
		if (q1.size() == 0) {
			throw new StackEmptyException();
		}

		int n = q1.size() - 1;
		while (n > 0) {
			q2.add(q1.remove());
			n--;
		}
		int res = q1.remove(); // to empty the queue q1 after last operation

		q2.add(res); // push last element to q2 as its top() operation
		Queue<Integer> temp = new LinkedList<Integer>();// Swap q1 and q2
		temp = q1;
		q1 = q2;
		q2 = temp;

		return res;
	}

	public static void main(String[] args) throws StackEmptyException{
		// TODO Auto-generated method stub

		StackUsing2Queues_Pop stack = new StackUsing2Queues_Pop();

		for (int i = 0; i < 10; i++) {
			stack.push(i + 1);
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.top());
			stack.pop();
		}

	}

}
