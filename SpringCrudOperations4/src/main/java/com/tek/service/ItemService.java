package com.tek.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tek.Dao.ItemDao;
import com.tek.model.Item;

@Service
public class ItemService {
	private static final AtomicLong counter = new AtomicLong();
	@Autowired
	ItemDao itemdao;
	private static List<Item> items;

	public List<Item> findAllItems() {
		return itemdao.getItems();
	}

	public Item findById(int id) {

		return itemdao.getItemById(id);

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
		item.setId((int) counter.incrementAndGet());
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

}
