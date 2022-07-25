package com.example.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.exceptions.ItemNotFoundException;
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
	
	public void deleteItem(String name) {
		try {
			GroceryItem item = this.getItemByName(name);
			
			mockRepo.deleteItem(item.getId());
			System.out.println("Item was deleted");
		} catch(ItemNotFoundException e) {
			System.out.println("Item being deleted was not found");
		}
	}
	
	public GroceryItem getItemByName(String name) {
		Iterator<GroceryItem> gIter = mockRepo.getAllItems().iterator();
		
		while(gIter.hasNext()) {
			GroceryItem gi = gIter.next();
			if(gi.getName().equals(name)) {
				return gi;
			}
		}
		
		throw new ItemNotFoundException();
	}
	
	public double getCost() {
		List<GroceryItem> items = this.getAllItems();
		
		double cost = 0;
		
		for(GroceryItem gi : items) {
			cost+=gi.getValue();
		}
		
		return cost;
	}
	
}
