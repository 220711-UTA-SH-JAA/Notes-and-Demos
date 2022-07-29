package com.example.services;

import java.util.List;

import com.example.models.Customer;
import com.example.models.GroceryList;
import com.example.models.Item;
import com.example.repository.GroceryListDao;
import com.example.repository.ItemDao;

public class GroceryListService {
	
	private GroceryListDao listDao;
	private ItemDao itemDao;
	
	public GroceryListService(GroceryListDao listDao, ItemDao itemDao) {
		this.listDao = listDao;
		this.itemDao = itemDao;
	}
	
	public GroceryList addNewList(Customer c, String listName) {
		GroceryList gl = new GroceryList(listName, c);
		listDao.createList(gl);
		return gl;
	}
	
	public void addItemToList(String listName, String itemName) {
		//Get the list by its name, we need a new DAO method
		GroceryList list = listDao.getListByName(listName);
		
		Item i = itemDao.getItemByName(itemName);
		List<Item> items = list.getItems();
		items.add(i);
		listDao.createItemReference(list, i);
	}
	
	public void removeItemFromList(String listName, String itemName) {
		GroceryList list = listDao.getListByName(listName);
		Item item = itemDao.getItemByName(itemName);
		List<Item> items = list.getItems();

		for(int i=0; i<items.size(); i++) {
			if(items.get(i).getItemName().equals(itemName)) {
				items.remove(i);
			}
		}
		
		listDao.deleteItemReference(list, item);
	}
	
	public GroceryList getListByName(String listName) {
		return listDao.getListByName(listName);
	}

}
