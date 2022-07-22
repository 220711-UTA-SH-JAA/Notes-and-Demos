package com.example.models;

import java.util.Objects;

public class GroceryItem {
	
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

	@Override
	public String toString() {
		return "GroceryItem [name=" + name + ", value=" + value + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, type, value);
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
		return Objects.equals(name, other.name) && Objects.equals(type, other.type)
				&& Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}
}
