package com.example.repository;

import java.util.List;

import com.example.models.Item;

public interface ItemDao {
	
	void createItem(Item i);
	
	List<Item> getAllItems();
	
	Item getItemByName(String itemName);
	
	void updateItem(Item i);
	
	void deleteItem(int id);

}
