package com.luv2code.springdemo.coaching;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.fortunes.FortuneService;

// This Bean is defined in the DemoConfig.java file
@Component
public class SwimCoach implements Coach {
	
	@Autowired
	@Qualifier("normalFortuneService")
	private FortuneService service;
	
	// noarg constructor
	public SwimCoach() {
	}
	
	// we are injecting the dependency in the config file
	public SwimCoach(FortuneService service) {
		this.service = service;
		System.out.println("***Swim constructor");
	}
	
	@Autowired
	@Qualifier("happyFortuneService")
	// Overriding the previous fortune
	public void setFortuneService(FortuneService service) {
		this.service = service;
		System.out.println("***setter");
	}

	@Override
	public String getDailyWorkout() {
		return "Swim Workout";
	}
	
	@Override
	public String getDailyFortune() {
		return "SwimCoach: " + service.getFortune();
	}

	
	@PreDestroy
	private void destructionMethod() {
		System.out.println("***Swim Destruction");
	}
}
