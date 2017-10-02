package com.tek.call;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.tek.output.OutputHelper;

public class App {
	public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Output.xml"});
    	OutputHelper output = (OutputHelper)context.getBean("OutputHelper");
    	output.generateOutput();
    }

}
	