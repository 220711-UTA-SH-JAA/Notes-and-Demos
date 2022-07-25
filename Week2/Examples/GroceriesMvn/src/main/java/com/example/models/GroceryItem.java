package com.example.models;

import java.util.Objects;

/*
 * Comparable Interface
 * This is an interface that defines natural ordering for a class/object
 * - It provides the compareTo() method to the class
 * - Allows us to compare objects, typically to sort/order them
 * 
 * Typically, this is used with the Collections utility to sort lists/collections for you
 */

public class GroceryItem implements Comparable<GroceryItem>{
	
	private int id;
	private String name;
	private double value;
	private String type;
	
	public GroceryItem() {
		super();
	}

	public GroceryItem(String name, double value, String type) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
	}
	
	public GroceryItem(int id, String name, double value, String type) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GroceryItem [id=" + id + ", name=" + name + ", value=" + value + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, type, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryItem other = (GroceryItem) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(type, other.type)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}

	//Comparing "this" object to the object passed into the parameter
	@Override
	public int compareTo(GroceryItem o) {

		//The compareTo method should return:
		//	- 0 if the two objects are the same/equal
		// 	- <0 if "this" object is smaller than the one passed into the parameter
		//  - >0 if "this" object is larger than the one passed into the parameter
		
		if(this.getValue() < o.getValue()) {
			return -1;
		}
		
		if(this.getValue() > o.getValue()) {
			return 1;
		}
		
		return 0;
	}
}
