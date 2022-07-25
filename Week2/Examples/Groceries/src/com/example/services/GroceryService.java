package com.example.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.example.models.GroceryItem;
import com.example.repository.GroceryMockRepo;

/* Core logic will happen */
public class GroceryService {

	//Dependency injection, helps keep our code loosely coupled
	private GroceryMockRepo mockRepo;
	
	public GroceryService(GroceryMockRepo mockRepo) {
		this.mockRepo = mockRepo;
	}
	
	//Type would probably want to be some enum/class also stored on the DB being referenced
	public GroceryItem createNewItem(String name, double value, String type) {
		GroceryItem gi = new GroceryItem(name, value, type);
		return mockRepo.saveItem(gi);
	}
	
	public List<GroceryItem> getAllItems() {
		ArrayList<GroceryItem> items = new ArrayList<>();
		
		Iterator<GroceryItem> gIter = mockRepo.getAllItems().iterator();
		
		while(gIter.hasNext()) {
			items.add(gIter.next());
		}
		
		return items;
	}
	
	public void deleteItem(int id) {
		mockRepo.deleteItem(id);
	}
	
}
