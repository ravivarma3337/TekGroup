package com.tek.mainprocess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tek.service.CustomerService;

public class MainProcess {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "SpringConfig.xml" });
																		//bootstrap the spring container.
		CustomerService cust = (CustomerService) context.getBean("customerService");
														//requesting spring to give us an instance of CusmerServce.
		System.out.println(cust);
		

	}

}
