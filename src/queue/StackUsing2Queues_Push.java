package queue;

import java.util.LinkedList;
import java.util.Queue;

import Stack.StackEmptyException;

//When push operation is ineffecient
public class StackUsing2Queues_Push {

	private Queue<Integer> q1 = new LinkedList<Integer>();
	private Queue<Integer> q2 = new LinkedList<Integer>();

	public int size() // O(1)
	{
		return q2.size();
	}

	public boolean isEmpty() // O(1)
	{
		return (size() == 0);
	}

	public void push(int element) // O(n)
	{
		q1.add(element); // enqueue to q1

		while (!q2.isEmpty()) {
			q1.add(q2.remove()); // Dequeue all remaining elements from q2 and enqueue to q1
		}

		Queue<Integer> temp = new LinkedList<Integer>();// Swap q1 and q2
		temp = q1;
		q1 = q2;
		q2 = temp;
	}

	public int pop() throws StackEmptyException // O(1)
	{
		if (q2.size() == 0) {
			throw new StackEmptyException();
		}
		int temp = q2.remove();
		return temp;
	}

	public int top() throws StackEmptyException // O(1)
	{
		if (q2.size() == 0) {
			throw new StackEmptyException();
		}
		int temp = q2.peek();
		return temp;
	}

	public static void main(String[] args) throws StackEmptyException {
		// TODO Auto-generated method stub
		StackUsing2Queues_Push stack = new StackUsing2Queues_Push();

		for (int i = 0; i < 10; i++) {
			stack.push(i + 1);
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.top());
			stack.pop();
		}

	}

}
