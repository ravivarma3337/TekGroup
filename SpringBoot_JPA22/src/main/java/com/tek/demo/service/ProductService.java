package com.tek.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tek.demo.Dao.ProductRepository;
import com.tek.demo.model.Product;

@Service
public class ProductService {
	private static final AtomicInteger counter = new AtomicInteger();
	@Autowired
	ProductRepository productrepository;
	private static List<Product> products;

	public List<Product> findAllProducts() {
		return productrepository.findAll();
	}

	public Product findById(int id) {

		return productrepository.findOne(id);

	}

	public void saveProduct(Product product) {
		product.setId(counter.incrementAndGet());
		productrepository.save(product);
	}

	public void updateProduct(Product product) {

		productrepository.save(product);
	}

	/*
	 * public Product findByName(String name) { for (Product product : products) {
	 * if (product.getName().equalsIgnoreCase(name)) { return (Product)
	 * productdao.getProducts(); } } return null; }
	 */

	public void deleteProductById(int id) {

		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if (product.getId() == id) {
				iterator.remove();
			}
		}
	}

	/*
	 * public boolean isProductExist(Product product) { return
	 * findByName(product.getName()) != null; }
	 */

}
