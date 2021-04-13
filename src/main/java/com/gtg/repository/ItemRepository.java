package com.gtg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtg.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	
	public List<Item> findAll();
	public Item findByItemId(long id);
	
}
