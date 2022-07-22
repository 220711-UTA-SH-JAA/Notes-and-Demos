package com.revature;

public class Node {
	
	Node next;
	
	int number;
	
	public Node(int number) {
		this.number = number;
		next = null;
		
	}
	
	public Node(int number, Node next) {
		this.number = number;
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	

	

}
