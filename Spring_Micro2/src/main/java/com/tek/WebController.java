package com.tek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebController {
	@Autowired
	RestTemplate restTemplate;
	@RequestMapping("/calling")
	public void method() {
		restTemplate.getForObject("http://vehicle-web-microservice/vehicle", Vehicle.class);
	}

}
