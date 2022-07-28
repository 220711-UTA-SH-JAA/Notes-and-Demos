package com.example.services;

import java.util.List;

import com.example.models.Item;
import com.example.models.ItemType;
import com.example.repository.ItemDao;

public class ItemService {
	
	private ItemDao itemDao;
	
	public ItemService(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	public void addItem(String name, String type, double price) {
		
		
		Item i = new Item(0, name, ItemType.valueOf(type.toUpperCase()), price);
		
		itemDao.createItem(i);
	}
	
	public List<Item> retrieveAllItems() {
		return itemDao.getAllItems();
	}
	
	public Item getItemByName(String name) {
		return itemDao.getItemByName(name);
	}
	
	public void updateItem(String name, String newName, String type, String price) {
		Item i = getItemByName(name);
		
		if(i == null) {
			return;
		}
		
		if(!newName.equals("")) {
			i.setItemName(newName);
		}
		
		if(!type.equals("")) {
			i.setItemType(ItemType.valueOf(type.toUpperCase()));
		}
		
		if(!price.equals("")) {
			Double priceD = Double.parseDouble(price);
			i.setPrice(priceD);
		}
		
		itemDao.updateItem(i);
	}
	
	public void removeItemFromStore(int id) {
		itemDao.deleteItem(id);
	}

}
