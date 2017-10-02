package com.tek.mainmethod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tek.dao.CustomerDAO;
import com.tek.model.Customer;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringCustomer.xml");

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Customer customer = new Customer(1, "uigyu", 23);
		Customer customer11 = new Customer(2, "qwerty", 22);
		Customer customer2 = new Customer(3, "asdfgh", 21);
		Customer customer3 = new Customer(4, "zxcvbn", 20);

		customerDAO.insert(customer);
		customerDAO.insert(customer11);
		customerDAO.insert(customer2);
		customerDAO.insert(customer3);

		Customer customer1 = customerDAO.findByCustomerId(1);
		System.out.println(customer1);

	}

}
