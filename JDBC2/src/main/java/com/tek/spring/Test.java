package com.tek.spring;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tek.spring.EmployeeDao;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");
		int nw = dao.saveEmployee(new Employee(1, "aparna", 21));
		int ns = dao.saveEmployee(new Employee(3, "ujwala", 24));
		// int status = dao.saveEmployee(new Employee(10, "Amit", 35));
		System.out.println(nw);
		System.out.println(ns);
	}

}
