package com.tek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tek.Dao.ItemDao;
import com.tek.model.Item;
import com.tek.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	ItemService itemservice;

	@Autowired
	ItemDao itemDao;

	@RequestMapping(value = "/item/", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> listAllItems() {
		List<Item> items = itemservice.findAllItems();

		if (items.isEmpty()) {

			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Item> getItem(@PathVariable("id") int id) {
		System.out.println("Fetching Item with id " + id);
		Item item = itemservice.findById(id);
		if (item == null) {
			System.out.println("Item with id " + id + " not found");
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public ResponseEntity<Void> createItem(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Item " + item.getName());

		itemDao.save(item);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(item.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Item> updateItem(@PathVariable("id") int id, @RequestBody Item item) {
		System.out.println("Updating item " + id);

		Item currentItem = itemservice.findById(id);
		currentItem.setName(item.getName());
		currentItem.setId(item.getId());
		currentItem.setPrice(item.getPrice());

		itemservice.updateItem(currentItem);
		return new ResponseEntity<Item>(currentItem, HttpStatus.OK);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Item> deleteItem(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Item with id " + id);

		Item item = itemservice.findById(id);
		if (item == null) {
			System.out.println("Unable to delete. Item with id " + id + " not found");
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		int id1 = (int) id;
		itemDao.delete(id1);
		return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
	}

}
