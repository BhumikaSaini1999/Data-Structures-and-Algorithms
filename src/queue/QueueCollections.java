package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Queue is an interface
		Queue<Integer> queue=new LinkedList<>();
		queue.add(89);
		queue.add(76);
		queue.add(18);
		
		
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.size());
	}

}
