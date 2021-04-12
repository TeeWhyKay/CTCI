package com.datastruct.graphs;

import java.util.ArrayList;

public class Node {
	public String data;
	public ArrayList<Node> children;
	public boolean marked;
	
	Node(String item) {
		this.data = item;
		children = new ArrayList<Node>();
	}
	
	public void addChildren(Node node) {
		children.add(node);
	}
}
