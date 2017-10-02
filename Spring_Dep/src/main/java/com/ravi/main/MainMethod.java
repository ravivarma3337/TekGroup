package com.ravi.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tek.sub.OutputHelper;

public class MainMethod {

	public static void main(String[] args) {
		ApplicationContext context =
		    	   new ClassPathXmlApplicationContext(new String[] {"Spring.xml"});

		    	OutputHelper output = (OutputHelper)context.getBean("OutputHelper");
		    	output.generateOutput();


	}

}
