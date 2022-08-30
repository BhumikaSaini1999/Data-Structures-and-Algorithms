package LinkedList;

//Generic Class
public class Node<T> {
	
	T data;
	Node<T> next;
	
	Node(T data)
	{
		this.data=data;
		next=null; //Single Node is not referring anywhere
	}
}
