package com.example.models;

public class Item {
	
	private int itemId;
	private String itemName;
	private ItemType itemType;
	private double price;
	
	public Item() {
		super();
	}

	public Item(int itemId, String itemName, ItemType itemType, double price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemType = itemType;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemType=" + itemType + ", price=" + price
				+ "]";
	}
}
