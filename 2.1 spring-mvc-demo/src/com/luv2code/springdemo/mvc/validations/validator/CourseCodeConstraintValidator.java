package com.luv2code.springdemo.mvc.validations.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String[] coursePrefixes;

	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefixes = courseCode.value();
	}
	
	@Override
	public boolean isValid(String courseCode, ConstraintValidatorContext constraint) {
		
		boolean result = false;
		
		// Loop through the prefixes and see if they match the constraint
		if (courseCode != null) {
			for (String prefix : coursePrefixes) {
				if (courseCode.startsWith(prefix)) {
					result = true;
					break;
				}
			}			
		} 
		else {
			result = true;
		}
		
		return result;
	}
}
