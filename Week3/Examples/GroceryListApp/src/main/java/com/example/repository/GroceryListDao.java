package com.example.repository;

import com.example.models.Customer;
import com.example.models.GroceryList;
import com.example.models.Item;

public interface GroceryListDao {

	void createList(GroceryList gl);
	
	void createItemReference(GroceryList gl, Item i);
	
	void deleteItemReference(GroceryList gl, Item i);
	
	GroceryList getListByName(String name);
	
}
