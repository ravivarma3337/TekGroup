package com.tek.process;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tek.output.OutputHelper;

public class App {
	public static void main(String[] args) {
		/*
		 * Normal Calling IOutputGenerator io = new CsvOutputGenerator();
		 * io.genrateOutput();
		 */

		// Using Spring

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "NewSpring.xml" });

		OutputHelper ot = (OutputHelper) context.getBean("OutputHelper1");
	

	}

}
