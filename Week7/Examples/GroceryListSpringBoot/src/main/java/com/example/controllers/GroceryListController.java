package com.example.controllers;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.GroceryList;
import com.example.models.Item;
import com.example.services.GroceryListService;
import com.example.services.ItemService;

@RestController
@RequestMapping("/list")
public class GroceryListController {
	
	private GroceryListService glService;
	private ItemService itemService;

	@Autowired
	public GroceryListController(GroceryListService glService, ItemService itemService) {
		this.glService = glService;
		this.itemService = itemService;
	}
	
	@PostMapping("/create")
	public GroceryList createList(@RequestBody GroceryList list) {
		return glService.createList(list);
	}
	
	@PutMapping("/add")
	public GroceryList addItem(@RequestBody LinkedHashMap<String, String> body) {
		Item i = itemService.getItemByName(body.get("item"));
		
		return glService.addItem(i, body.get("name"));
	}
	
	@DeleteMapping("/remove")
	public GroceryList removeItem(@RequestBody LinkedHashMap<String, String> body) {
		Item i = itemService.getItemByName(body.get("item"));
		
		return glService.removeItem(i, body.get("name"));
	}
	
}
