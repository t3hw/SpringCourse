package com.luv2code.springdemo.mvc.basics;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller method to process the HTML form

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld-formprocessor";
	}

	// a new controller method to readread form data and add data to the model
	@RequestMapping("/processFormV2")
	public String doFormAndModelStuff(HttpServletRequest request, Model model) {

		// read the request parameter
		String theName = request.getParameter("studentName");

		// convert the data to all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Yo! " + theName;

		// add the message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

	// Using spring to pull the request param into a method parameter
	@RequestMapping("/processFormV3")
	public String doFormStuffRequestParam(@RequestParam("studentName") String theName, Model model) {

		// convert the data to all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Whats Up?! " + theName;

		// add the message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

	@RequestMapping("/backToMenu")
	public String returnToMenu() {
		return "main-menu";
	}

}
