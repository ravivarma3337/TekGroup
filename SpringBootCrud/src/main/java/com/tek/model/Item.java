package com.tek.model;


public class Item {
	private int id;
	private String price;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName(String name) {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", price=" + price + ", name=" + name + "]";
	}

	public Item(int id, String name, String price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public Item() {

	}
}
