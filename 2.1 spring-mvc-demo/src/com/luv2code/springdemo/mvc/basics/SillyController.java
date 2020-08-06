package com.luv2code.springdemo.mvc.basics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class SillyController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
		
	}
	
	@RequestMapping("/processFormV3")
	public String processForm(){
		return "helloworld";
	}
}
