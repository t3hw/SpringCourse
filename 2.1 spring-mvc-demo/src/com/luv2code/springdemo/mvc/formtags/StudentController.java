package com.luv2code.springdemo.mvc.formtags;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	// Injecting the country list from properties
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;

	// Injecting the country list from properties
	@Value("#{languageOptions}")
	private Map<String, String> languageOptions;

	@PostConstruct
	public void postConstruct() {

	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a new student object
		Student theStudent = new Student();

		// add student object to the model
		theModel.addAttribute("student", theStudent);

		// add the countries to the model
		theModel.addAttribute("countries", countryOptions);

		// add the countries to the model
		theModel.addAttribute("languages", languageOptions);
		
		return "formtags/student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {

		// log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		return "formtags/student-confirmation";
	}

}
