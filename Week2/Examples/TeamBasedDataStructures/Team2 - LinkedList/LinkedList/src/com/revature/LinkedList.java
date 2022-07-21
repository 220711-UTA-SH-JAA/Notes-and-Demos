package com.revature;

public class LinkedList{
	
	//declaring private variables
	private Node head;
	private int size;
	
	
	//default constructor that creates a new list of size zero
	//head is null by default
	public LinkedList() {
		this.size = 0;
		
	}
	
	//method to add a new number to the end of the list
	public void add(int number) {
		
		//if the head is null (list is empty)
		if(head == null) {
			
			//create Node object passing in the number
			head = new Node(number);
			
			//increasing the size of the list by 1
			size++;
			return;
			
		}
		
		//declaring the current node and making it equal to the head
		Node currentNode = head;
		
		//looping until the node after the current node is null
		while(currentNode.getNext() != null) {
			
			currentNode = currentNode.getNext();
		}
		
		//setting the current node equal to the number that was passed in
		currentNode.setNext(new Node(number));

		size++;
		
		

		
	}
	
	//removing a number in the list that is passed in at the index stated
	public void removeAtPosition(LinkedList list, int index) {
		
		if(index > size) {
			return;
		}
		
		//declaring the current node as the head of the list
		Node currentNode = list.head;
		
		//if the index is 0, meaning you want to delete the first number on the list and it isn't empty
		//we are going to set the head/current node to be equal to next node. Which removes the number.
		if(index == 0 && currentNode != null) {
			list.head = currentNode.getNext();
			
		}//if the index is equal to the size we have to make sure the last node points to null
		else if(index == size) {
			for(int i = 0; i < index - 1; i++) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(null);
				
		}else {
			for(int i = 0; i < index - 1; i++) {
				currentNode = currentNode.getNext();
			}
			//currentnode.getnext -> want to delete
			//to replace we need to get the node after currentnode.getnext
			currentNode.setNext(currentNode.getNext().getNext());
		}
		
		//make sure to decrease the size of the list
		size--;
		
		
	}
	

	
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		
		Node currentNode = head;
		
		String result = "LinkedList: ";
		
		while(currentNode != null) {
			result += "" + currentNode.getNumber() + " ";
			currentNode = currentNode.getNext();
		
		}
		
		return result;
		
	}
	

	
	
}
