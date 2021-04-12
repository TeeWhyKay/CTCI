package com.datastruct.trees;

public class Node<E> {
	public E data;
	public Node<E>[] children;
	
	@SuppressWarnings("unchecked")
	public Node(E item) {
		this.data = item;
		children = new Node[2];
	}
	
	public void setRightChild(Node<E> right) {
		children[1] = right;
	}
	
	public void setLeftChild(Node<E> left) {
		children[0] = left;
	}
	
	public Node<E> getRight() {
		return children[1];
	}
	
	public Node<E> getLeft() {
		return children[0];
	}
	
	public E getData() {
		return this.data;
	}
	
}
