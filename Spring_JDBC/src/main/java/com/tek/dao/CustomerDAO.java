package com.tek.dao;

import com.tek.model.Customer;

public interface CustomerDAO {
	public void insert(Customer customer);

	public Customer findByCustomerId(int custId);
}
