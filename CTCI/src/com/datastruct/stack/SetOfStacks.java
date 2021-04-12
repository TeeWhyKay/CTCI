package com.datastruct.stack;

import java.util.EmptyStackException;

public class SetOfStacks<T> {
    aStack<T> currentStack;
    int threshold;
    int length = 0;

    public SetOfStacks(int threshold) { //constructor for SetOfStacks (that takes in the integer threshold)
        this.threshold = threshold;
    }

    public class aStack<T> {
        int nodeCount;
        aStack<T> next;
        StackNode<T> top; //top of the stack


        public class StackNode<T> { //wrapper for the item T
            T data;
            StackNode<T> next;
    
            public StackNode(T data) {
                this.data = data;
            }
        }

        //push
        public void push(T data) {
            
            StackNode<T> newNode = new StackNode<T>(data);
            newNode.next = top;
            top = newNode;
            nodeCount++;
        }
        //pop
        public T pop() {
            if(top == null) return null;
            StackNode<T> popped = top;
            top = top.next;
            nodeCount--;
            return popped.data;
        }
        //peek
        public T peek() {
            if(isEmpty()) return null;
            return top.data;
        }
        //isEmpty()
        public boolean isEmpty() {
            return top == null;
        }
        
        
    }
    
    public void push(T item) {
        if(currentStack == null) { //if the setofstack is completely empty
            aStack<T> newStack = new aStack<T>();
            newStack.push(item);
            currentStack = newStack;
            length++;
            return;
        }
        if(this.currentStack.nodeCount == this.threshold) { //checking if the stack is full
            aStack<T> newStack = new aStack<T>();
            newStack.push(item);
            newStack.next = currentStack;
            currentStack = newStack;
            length++;
        } else {
            this.currentStack.push(item);
        }
    }

    public T pop() {
        while(currentStack.isEmpty()) { //if current stack is empty,
            currentStack = currentStack.next; //check next stack 
            length--;
            if(currentStack == null) { 
                throw new EmptyStackException(); //this will occur only if the stack of stack is truly empty;
            }
        }
        return currentStack.pop(); //the next stack has an item.
    }
    
    public T pop(int index) {
    	if(index > length -1) {
    		return null;
    	} else {
    		aStack<T> traverseStack = currentStack;
    		while(index > 0) {
    			traverseStack = traverseStack.next;
    			index--;
    		}
    		return traverseStack.pop();
    	}
    }

    public T peek() {
        if(currentStack.isEmpty()) { //if current stack is empty,
            currentStack = currentStack.next; //check next stack 
            if(currentStack == null || currentStack.isEmpty()) { 
                throw new EmptyStackException(); //this will occur only if the stack of stack is truly empty;
            }
        }
        return currentStack.peek(); //the next stack has an item.
    }

    public boolean isEmpty() {
        return currentStack == null;
    }

    
    public static void main(String[] args) throws Exception {
        SetOfStacks<Integer> mySetOfStacks = new SetOfStacks<Integer>(3);
        
        mySetOfStacks.push(1);
        mySetOfStacks.push(2);
        mySetOfStacks.push(3);
        mySetOfStacks.push(4);
        mySetOfStacks.push(5);
        mySetOfStacks.push(6);
        mySetOfStacks.push(7);
        mySetOfStacks.push(8);
        mySetOfStacks.push(9);
        
        System.out.println(mySetOfStacks.pop(2));
        mySetOfStacks.push(10);
        System.out.println(mySetOfStacks.pop());
        
    }
}

