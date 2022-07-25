package com.example.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.models.GroceryItem;

public class GroceryMockRepo {
	
	//Our Mock Database will be a Map
	private Map<Integer, GroceryItem> mockDB = new HashMap<Integer, GroceryItem>();
	
	public GroceryItem saveItem(GroceryItem gi) {
		//This would be an actual query to the database
		int id = mockDB.size() +1;
		//Simulating a DB setting the id for like the real world
		gi.setId(id);
		mockDB.put(id, gi);
		return mockDB.get(id);
	}
	
	public GroceryItem getItem(int id) {
		//This would be a query to the DB
		return mockDB.get(id);
	}
	
	public Collection<GroceryItem> getAllItems(){
		return mockDB.values();
	}
	
	public GroceryItem updateItem(GroceryItem gi) {
		//We can assume that the only thing that wont change/get updated on the object is the primary id
		mockDB.replace(gi.getId(), gi);
		return mockDB.get(gi.getId());
	}
	
	public void deleteItem(int id) {
		mockDB.remove(id);
	}

}
