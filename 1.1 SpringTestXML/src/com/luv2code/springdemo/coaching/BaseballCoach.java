package com.luv2code.springdemo.coaching;

import com.luv2code.fortunes.FortuneService;

public class BaseballCoach implements Coach {
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService service) {
		this.fortuneService = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "baseball trainin g";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}	
