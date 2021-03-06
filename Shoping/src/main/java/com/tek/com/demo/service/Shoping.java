package com.tek.com.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tek.com.demo.model.Items;
import com.tek.com.demo.model.Order;
import com.tek.com.demo.repository.Connection;
@Component
public class Shoping {
	@Autowired
	Connection connect;

	List<Items> itemslist = new ArrayList<Items>(Arrays.asList(new Items("1", "Audi", 65000, "R8"),
			new Items("2", "Honda", 75000, "Acod"),
			new Items("3", "Dodge", 85000, "Charger"),
			new Items("4", "Nisan", 50000, "Altima"),
			new Items("5", "Porsche", 100000, "911"),
			new Items("6", "BMW", 150000, "i8")));

	public List<Items> getItems() {
		return itemslist;
	}

	public int save(Order r) {
		return connect.save(r);
	}

	public Items getitem(String id) {
		Items item = null;
		Items returnItem = null;
		Optional<Items> optional = itemslist.stream().filter(t -> t.getItemNo().equals(id)).findFirst();

		if (optional.isPresent()) {
			item = optional.get();
		}
		return item;
	}
}
