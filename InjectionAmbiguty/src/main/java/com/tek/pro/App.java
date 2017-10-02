package com.tek.pro;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "Config.xml" });
		Customer custm = (Customer) context.getBean("Cust");
		System.out.println(custm);

	}

}
