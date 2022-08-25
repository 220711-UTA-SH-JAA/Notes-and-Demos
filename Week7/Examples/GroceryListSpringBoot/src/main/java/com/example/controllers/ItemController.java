package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Item;
import com.example.services.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	
	private ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping("/create")
	public Item createItem(@RequestBody Item i) {
		System.out.println(i);
		return itemService.saveOrUpdateItem(i);
	}
	
	@GetMapping("/{name}")
	public Item getItem(@PathVariable(name="name")String name) {
		return itemService.getItemByName(name);
	}
	
	@PutMapping("/update")
	public Item updateItem(@RequestBody Item i) {
		return itemService.saveOrUpdateItem(i);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteItem(@RequestBody Item i){
		itemService.deleteItem(i);
		
		return new ResponseEntity<String>("Item deleted", HttpStatus.OK);
	}
	

}
