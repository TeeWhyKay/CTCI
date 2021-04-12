package com.datastruct.trees;

public class Tree<E> {
	Node<E> root;
	
	public void setRoot(Node<E> root) {
		this.root = root;
	}
	
	public void inOrderTraversal(Node<E> node) {
		if(node != null) {
			inOrderTraversal(node.getLeft());
			System.out.println(node.getData());
			inOrderTraversal(node.getRight());
		}
	}
	
	public void preOrderTraversal(Node<E> node) {
		if(node != null) {
			System.out.println(node.getData());
			preOrderTraversal(node.getLeft());
			preOrderTraversal(node.getRight());
		}
	}
	
	public void postOrderTraversal(Node<E> node) {
		if(node != null) {
			postOrderTraversal(node.getLeft());
			postOrderTraversal(node.getRight());
			System.out.println(node.getData());
		}
	}
	public static void main(String[] args) {
		Tree<Integer> myTree = new Tree<Integer>();
		Node<Integer> n1 = new Node<Integer>(1);
		Node<Integer> n2 = new Node<Integer>(2);
		Node<Integer> n3 = new Node<Integer>(3);
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		myTree.setRoot(n1);
		n1.setLeftChild(n2);
		n2.setLeftChild(n3);
		n1.setRightChild(n4);
		n4.setRightChild(n5);
		n4.setLeftChild(n6);
		
		myTree.inOrderTraversal(myTree.root);
		System.out.println("----");
		myTree.postOrderTraversal(myTree.root);
		System.out.println("----");
		myTree.preOrderTraversal(myTree.root);
	}

}
