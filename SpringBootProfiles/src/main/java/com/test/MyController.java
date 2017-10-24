package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
    Environment env;
	@Value("${tek.test}")
	String txt=null;
    
	@RequestMapping(value="/get")
	public Resp get()
	{
		Resp r = new Resp(txt+env.getProperty("tek.test"));
		return r;
	}
    
}
