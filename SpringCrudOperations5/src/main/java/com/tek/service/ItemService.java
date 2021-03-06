package com.tek.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tek.Dao.ItemRepository;
import com.tek.model.Item;

@Service
public class ItemService {
	private static final AtomicInteger counter = new AtomicInteger();
	@Autowired
	ItemRepository itemrepository;
	private static List<Item> items;

	public List<Item> findAllItems() {
		return itemrepository.findAll();
	}

	/*public Item findById(int id) {

		return Itemdao.getItemById(id);

	}

	public Item findByName(String name) {
		for (Item item : items) {
			if (item.getName().equalsIgnoreCase(name)) {
				return (Item) itemdao.getItems();
			}
		}
		return null;
	}

	public void saveItem(Item item) {
		item.setId(counter.incrementAndGet());
		items.add(item);
	}

	public void updateItem(Item item) {
		itemdao.update(item);
	}

	public void deleteItemById(int id) {

		for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
			Item item = iterator.next();
			if (item.getId() == id) {
				iterator.remove();
			}
		}
	}

	public boolean isItemExist(Item item) {
		return findByName(item.getName()) != null;
	}
*/
}
