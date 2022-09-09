package queue;

import java.util.LinkedList;
import java.util.Queue;

// Here push operation is ineffecient =>O(n)
public class StackUsing1Queue {

	Queue<Integer> q = new LinkedList<Integer>();

	int size() // O(1)
	{
		return q.size();
	}

	boolean isEmpty() // O(1)
	{
		return (q.size() == 0);
	}

	int top() // O(1)
	{
		int temp = q.peek();
		return temp;
	}

	void push(int element) // O(n)
	{
		q.add(element); // adding the element to queue at rear end
		if (q.size() > 0) {
			int n = q.size() - 1; // Calculate size of queue from starting to rear-1

			while (n > 0) {
				int temp = q.remove(); // Keep removing the element from the queue
				q.add(temp); // adding it to the rear end
				n--;
			}
		}
	}

	int pop() throws QueueEmptyException // O(1)
	{
		if (q.size() == 0) {
			throw new QueueEmptyException();
		}

		int temp = q.remove();
		return temp;
	}

	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub

		StackUsing1Queue stack = new StackUsing1Queue();

		for (int i = 0; i < 10; i++) {
			stack.push(i + 1);
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
