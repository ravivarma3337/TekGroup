package com.tek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Appli {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		HelloWorld object = (HelloWorld) context.getBean("hello");
		object.printHello();
	}
}
