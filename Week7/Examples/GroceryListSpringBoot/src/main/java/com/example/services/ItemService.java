package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exceptions.ItemDoesNotExistException;
import com.example.models.Item;
import com.example.repository.ItemRepository;

@Service
@Transactional
public class ItemService {
	
	private ItemRepository itemRepo;
	
	@Autowired
	public ItemService(ItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}
	
	//To Save and to update, we use the .save() method
	public Item saveOrUpdateItem(Item i) {
		itemRepo.save(i);
		return itemRepo.getByItemName(i.getItemName()).get();
	}
	
	public Item getItemByName(String name) {
		return itemRepo.getByItemName(name).orElseThrow(ItemDoesNotExistException::new);
	}
	
	public void deleteItem(Item i) {
		itemRepo.delete(i);
	}

}
