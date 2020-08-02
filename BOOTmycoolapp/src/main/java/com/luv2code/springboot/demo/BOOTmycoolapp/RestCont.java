package com.luv2code.springboot.demo.BOOTmycoolapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCont {
	@Value("${test.val}")
	String prop;
	
	
	@GetMapping("/")
	public String sayHello() {
		//return "Hello world! the time is: " + LocalDateTime.now();
		
	 
		String str = "asdasdasd";
		
		
		
		return str + "test" + prop;
	}
	
	@GetMapping("/workout")
	public String getWorkout() {
		return "MyWorkout";
		
	}
	
	
	@GetMapping("/fortune")
	public String getFortune() {
		return "MyFortune";
		
	}
}
