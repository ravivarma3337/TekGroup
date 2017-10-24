package com.tek;


public class Vehicle {
	
	private int id;
	private String price;
	private String name;
	
	private VehicleDetails details;

	public VehicleDetails getDetails() {
		return details;
	}

	public void setDetails(VehicleDetails details) {
		this.details = details;
	}

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
		return "Vehicle [id=" + id + ", price=" + price + ", name=" + name + "]";
	}

	public Vehicle(int id, String name, String price,VehicleDetails details) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
		this.details=details;
	}

	public Vehicle() {

	}
}
