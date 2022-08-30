package LinkedList;

public class LinkedListUse1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> node1=new Node<Integer>(10);
		Node<Integer> node2=new Node<Integer>(67);
		Node<Integer> node3=new Node<Integer>(19);
		Node<Integer> node4=new Node<Integer>(30);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		Node<Integer> head=node1;
		
		print(head);
		System.out.println();
		print(head);
	}

	private static void print(Node<Integer> head) {
		// TODO Auto-generated method stub
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		
		while(head!=null) //This loop won't work because head is null
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		
	}

}
