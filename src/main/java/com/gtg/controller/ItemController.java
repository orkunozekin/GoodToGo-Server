package com.gtg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gtg.model.Item;
import com.gtg.repository.ItemRepository;

@RestController
@CrossOrigin("*")
public class ItemController {
	
	
	private ItemRepository itemRepo;
	
	@GetMapping("/allItems")
	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}
	
	@GetMapping("/")
	public String getDefaultResponse() {
		return "Hello";
	}
	
	
	@PostMapping("/newItem")
	public ResponseEntity<String> addNewItem(@RequestBody Item item) {
		if(item.getItemName() != null) {
			itemRepo.save(item);
			return new ResponseEntity<String>("Item created", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Failed to create", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<String> deleteItem(@PathVariable long id) {
		Item item = itemRepo.findByItemId(id);
		if(item != null) {
			itemRepo.delete(item);
			return new ResponseEntity<String>("Item deleted", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>("Failed to delete", HttpStatus.BAD_REQUEST);
	}
	
	
	@Autowired
	public ItemController(ItemRepository itemRepo) {
		super();
		this.itemRepo = itemRepo;
	}
	
	
	
	
	
}
