package com.test;

public class Greeting {
	
	public String message="default hello";
	public int age;
	
	Greeting(String message, int age)
	{
		this.message = message;
          this.age = age;
	}
	
	public void greet()
	{
		 System.out.println("spring says : " +message+ "with age : "+ age);
	}

}
