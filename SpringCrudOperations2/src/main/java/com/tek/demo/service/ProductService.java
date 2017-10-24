package com.tek.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tek.demo.Dao.ProductDao;
import com.tek.demo.model.Product;

@Service
public class ProductService {
	private static final AtomicLong counter = new AtomicLong();
	@Autowired
	ProductDao productdao;
	private static List<Product> products;

	public List<Product> findAllProducts() {
		return productdao.getProducts();
	}

	public Product findById(long id) {

		return productdao.getProductById(id);

	}

	public Product findByName(String name) {
		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				return (Product) productdao.getProducts();
			}
		}
		return null;
	}

	public void saveProduct(Product product) {
		product.setId((int) counter.incrementAndGet());
		products.add(product);
	}

	public void updateProduct(Product product) {
		productdao.update(product);
	}

	public void deleteProductById(int id) {

		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if (product.getId() == id) {
				iterator.remove();
			}
		}
	}

	public boolean isProductExist(Product product) {
		return findByName(product.getName()) != null;
	}

}
