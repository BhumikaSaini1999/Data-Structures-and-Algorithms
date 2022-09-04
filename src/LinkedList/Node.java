package LinkedList;

//Generic Class
public class Node<T> {
	
	public T data;
	public Node<T> next;
	
	public Node(T data)
	{
		this.data=data;
		next=null; //Single Node is not referring anywhere
	}
}
