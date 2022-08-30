package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exceptions.ListDoesNotExistException;
import com.example.models.GroceryList;
import com.example.models.Item;
import com.example.models.User;
import com.example.repository.GroceryListRepository;
import com.example.repository.UserRepository;

@Service
@Transactional
public class GroceryListService {
	
	private GroceryListRepository glRepo;
	private UserRepository userRepo;
	
	@Autowired
	public GroceryListService(GroceryListRepository glRepo, UserRepository userRepo) {
		this.glRepo = glRepo;
		this.userRepo = userRepo;
	}
	
	public GroceryList createList(GroceryList gl) {
		
		User u = userRepo.findById(gl.getUser().getUserId()).get();
		gl.setUser(u);
		glRepo.save(gl);
		return glRepo.getByListName(gl.getListName()).get();
	}
	
	public GroceryList addItem(Item i, String listName) {
		GroceryList gl = glRepo.getByListName(listName).orElseThrow(ListDoesNotExistException::new);
		
		List<Item> items = gl.getItems();
		
		items.add(i);
		
		gl.setItems(items);
		
		glRepo.save(gl);
		
		return gl;
	}
	
	public GroceryList removeItem(Item i, String listName) {
		GroceryList gl = glRepo.getByListName(listName).orElseThrow(ListDoesNotExistException::new);
		
		List<Item> items = gl.getItems().stream().filter(item -> !item.getItemName().equals(i.getItemName())).toList();
		
		gl.setItems(items);
		
		return gl;
	}

}
