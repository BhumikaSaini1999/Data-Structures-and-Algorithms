package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Using DFS Approach
//Using HashMaps
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneOfGraph_DFS {

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
		
		Map<Integer,Node> map=new HashMap<Integer,Node>();
		return CloneGraphUtil(node,map);
	}

	private static Node CloneGraphUtil(Node node, Map<Integer, Node> map) {
		// TODO Auto-generated method stub
		if(map.containsKey(node.val))
			return map.get(node.val);
			
		Node copy=new Node(node.val);
		map.put(node.val,copy);
		for(Node neighbor : node.neighbors)
		{
			copy.neighbors.add(CloneGraphUtil(neighbor,map));
		}
		return copy;
	}

}
