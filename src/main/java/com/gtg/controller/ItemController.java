package com.gtg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtg.model.Item;
import com.gtg.repository.ItemRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ItemController {
	
	
	private ItemRepository itemRepo;
	
	@GetMapping("/allItems")
	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}
	
	
	@PostMapping("newItem")
	public String addNewItem(@RequestBody Item item) {
		if(item.getItemName() != null) {
			itemRepo.save(item);
			return "Item successfully created";
		}
		return "Failed to create item. Try again!"; 
	}

	
	@Autowired
	public ItemController(ItemRepository itemRepo) {
		super();
		this.itemRepo = itemRepo;
	}
	
	
	
	
	
}
