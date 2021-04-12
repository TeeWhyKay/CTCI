package com.datastruct.graphs;

import java.util.ArrayList;
import java.util.LinkedList;


public class Graph {
	public ArrayList<Node> allNodes;
	
	public Graph() {
		allNodes = new ArrayList<Node>();
	}
	
	public void addNode(Node node) {
		allNodes.add(node);
	}
	public Node breathFirstSearch(String searchTerm, Node root) {
		//using a queue to iteratively add each level of node to search
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		root.marked = true;
		
		while(!queue.isEmpty()) {
			Node r = queue.removeFirst();
			if(r.data == searchTerm) {
				return r;
			}
			for(Node n : r.children) {
				if(n.marked == false) {
					n.marked = true;
					queue.add(n);
				}
			}
		}
		return null; //when no node is found
	}
	
	
	public Node depthFirstSearch(String searchTerm, Node root) {
		if (root== null) return null;
		if (root.data == searchTerm) return root;
		root.marked = true;
		for(Node n : root.children) {
			if (n.marked == false) {
				depthFirstSearch(searchTerm, n);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node target = new Node("Target");
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		
		a.addChildren(b);
		a.addChildren(c);
		a.addChildren(d);
		
		c.addChildren(e);
		c.addChildren(target);
		
		d.addChildren(f);
		
		Graph graph = new Graph();
		
		graph.addNode(a);
		graph.addNode(b);
		graph.addNode(c);
		graph.addNode(d);
		graph.addNode(e);
		graph.addNode(f);
		graph.addNode(target);
		
		Node result = graph.breathFirstSearch("Test", a);
		if(result != null) {
			System.out.println(result.data);
		} else {
			System.out.println("Unable to find node in graph");
		}
		
		
		//the other way to find if a route exists between two nodes is Djikstra's Algorithm
		
	}

}
