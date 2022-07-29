package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {

	private int listId;
	private String listName;
	private Customer customer;
	private List<Item> items;
	
	public GroceryList() {
		super();
		this.items = new ArrayList<>();
	}

	//Will be the one we probabaly use in the dao
	public GroceryList(String listName, Customer customer) {
		super();
		this.listName = listName;
		this.customer = customer;
		this.items = new ArrayList<>();
	}

	public GroceryList(int listId, String listName, Customer customer, List<Item> items) {
		super();
		this.listId = listId;
		this.listName = listName;
		this.customer = customer;
		this.items = items;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "GroceryList [listId=" + listId + ", listName=" + listName + ", customer=" + customer + ", items="
				+ items + "]";
	}
}
