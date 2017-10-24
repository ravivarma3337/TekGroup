package com.tek.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.tek.demo.model.Product;

@Service
public class ProductService {
	private static final AtomicLong counter = new AtomicLong();
	 private static List<Product> products;
     
	    static{
	    	products= populateDummyProducts();
	    }
	 
	    public List<Product> findAllProducts() {
	        return products;
	    }
	     
	    public Product findById(long id) {
	        for(Product product : products){
	            if(product.getId() == id){
	                return product;
	            }
	        }
	        return null;
	    }
	     
	    public Product findByName(String name) {
	        for(Product product : products){
	            if(product.getName().equalsIgnoreCase(name)){
	                return product;
	            }
	        }
	        return null;
	    }
	     
	    public void saveProduct(Product product) {
	    	product.setId(counter.incrementAndGet());
	        products.add(product);
	    }
	 
	    public void updateProduct(Product product) {
	        int index = products.indexOf(product);
	        products.set(index, product);
	    }
	 
	    public void deleteProductById(long id) {
	         
	        for (Iterator<Product> iterator = products.iterator(); iterator.hasNext(); ) {
	        	Product product = iterator.next();
	            if (product.getId() == id) {
	                iterator.remove();
	            }
	        }
	    }
	 
	    public boolean isProductExist(Product product) {
	        return findByName(product.getName())!=null;
	    }
	   private static List<Product> populateDummyProducts(){
	        List<Product> products = new ArrayList<Product>();
	        products.add(new Product(counter.incrementAndGet(),"Dell","7000"));
	        products.add(new Product(counter.incrementAndGet(),"HP","8000"));
	        products.add(new Product(counter.incrementAndGet(),"Lenovo","9000"));
	        products.add(new Product(counter.incrementAndGet(),"Apple","10000"));
	        return products;
	    }
	

}
