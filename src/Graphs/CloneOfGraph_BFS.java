package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Using BFS Approach
//Using HashMaps
public class CloneOfGraph_BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
		
		List<Node> adj=new ArrayList<Node>();
		adj.add(node2);
		adj.add(node3);
		node1.neighbors=adj;
		
		adj=new ArrayList<Node>();
		adj.add(node1);
		adj.add(node4);
		node2.neighbors=adj;
		
		adj=new ArrayList<Node>();
		adj.add(node1);
		adj.add(node4);
		node3.neighbors=adj;

		adj=new ArrayList<Node>();
		adj.add(node2);
		adj.add(node3);
		node4.neighbors=adj;
		
		System.out.println("------Original Graph--------");
		bfs(node1);
		
		System.out.println("------Cloned Graph--------");
		Node clone=CloneGraph(node1);
		bfs(clone);
	}

	private static void bfs(Node clone) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<Node>();
		HashMap<Node,Boolean> visit=new HashMap<Node,Boolean>();
		q.add(clone);
		visit.put(clone,true);
		
		while(!q.isEmpty())
		{
			Node front=q.poll();
			System.out.println("Value: "+front.val);
			System.out.println("Address: "+front);
			
			for(Node neighbor:front.neighbors)
			{
				if(visit.get(neighbor)==null)
				{
					q.add(neighbor);
					visit.put(neighbor,true);
				}
			}
		}
		
	}

	private static Node CloneGraph(Node node) {
		// TODO Auto-generated method stub
		if(node==null)
			return null;
		
		Map<Node,Node> map=new HashMap<Node,Node>();
		return CloneGraphUtil(node,map);
	}

	private static Node CloneGraphUtil(Node node, Map<Node, Node> map) {
		// TODO Auto-generated method stub
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		
		Node copy=null;
		if(!map.containsKey(node))//Obviously first node won't be in a map

		{
			copy=new Node(node.val);
			map.put(node, copy);
		}
		Node clone=copy;  //This clone node we will return
		
		while(!q.isEmpty())
		{
			Node front=q.poll();
			for(Node neighbor:front.neighbors)
			{
				if(!map.containsKey(neighbor))                     //If neighbor not visited
				{
					copy=new Node(neighbor.val);                   //Creating copy of it
					map.put(neighbor, copy);                       //Marking it as visited
					map.get(front).neighbors.add(copy);            //Updating neighbors list
					q.add(neighbor);
				}
				else
				{
					map.get(front).neighbors.add(map.get(neighbor));    //Updating neighbors list of copy node
				}
			}
		}
		return clone;
	}

}
