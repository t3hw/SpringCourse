package com.luv2code.springdemo.mvc.formtags;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;

	private String lastName;

	private String country;
	private String[] operatingSystems;

	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	 
	private String favoriteLanguage; 

	public Student() {
		// populate country options: used ISO country code
		countryOptions = new LinkedHashMap<>();

		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("IL", "Israel");
		
		
        // populate favorite language options
        favoriteLanguageOptions = new LinkedHashMap<>();

        // parameter order: value, display label
        //
        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("C#", "C#");
        favoriteLanguageOptions.put("PHP", "PHP");
        favoriteLanguageOptions.put("Ruby", "Ruby");
        favoriteLanguageOptions.put("Pascal", "Pascal");
	}

	
	// Getter/Setter methods
	
	/**
	 * @return the countryOptions
	 */
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param set firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param set lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param to the country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the favoriteLanguage
	 */
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	/**
	 * @param favoriteLanguage the favoriteLanguage to set
	 */
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	/**
	 * @return the favoriteLanguageOptions
	 */
	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	/**
	 * @return the operatingSystems
	 */
	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	/**
	 * @param operatingSystems the operatingSystems to set
	 */
	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

}
