package com.tek.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Car {
	
	@Id
	private int id;
	@Column
	private String price;
	@Column
	private String name;
	
	@OneToOne
	private CarDetails details;

	public CarDetails getDetails() {
		return details;
	}

	public void setDetails(CarDetails details) {
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
		return "Car [id=" + id + ", price=" + price + ", name=" + name + "]";
	}

	public Car(int id, String name, String price,CarDetails details) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
		this.details=details;
	}

	public Car() {

	}
}
