package com.gtg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="item_id")
	private long itemId;
	
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_type")
	private String itemType;
	
	//Constructors
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(long itemId, String itemName, String itemType) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
	}

	public Item(String itemName, String itemType) {
		super();
		this.itemName = itemName;
		this.itemType = itemType;
	}
	
	
	
	//Getters and Setters
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	
	
	//toString
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + "]";
	}
	
	
	
	
	
}
