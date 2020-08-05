package com.luv2code.springdemo.mvc.validations;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a new student object
		Customer theCustomer = new Customer();

		// add student object to the model
		theModel.addAttribute("customer", theCustomer);

		return "validations/customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer TheCustomer, BindingResult theBindingResult) {

		System.out.println("\n\n\n\n\n");
		// log the input data
		System.out.println("LastName: |" + TheCustomer.getLastName() + "|");
		System.out.println("FreePasses: |" + TheCustomer.getFreePasses() + "|");
		System.out.println("PostalCode: |" + TheCustomer.getPostalCode() + "|");
		System.out.println("CourseCode: |" + TheCustomer.getCourseCode() + "|");
		System.out.println("BindingResult: " + theBindingResult);
		
		
		if (theBindingResult.hasErrors()) {
			return "validations/customer-form";
		} else {
			return "validations/customer-confirmation";
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, trimmer);
	}
}
