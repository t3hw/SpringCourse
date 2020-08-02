package com.luv2code.springdemo.coaching;

import com.luv2code.fortunes.FortuneService;

public class TrackCoach implements Coach {
	
	public TrackCoach() {
	}
	
	FortuneService service;

	public TrackCoach(FortuneService service) {
		this.service = service;
	}

	@Override
	public String getDailyWorkout() {
		return "track training routine";
	}
	
	@Override
	public String getDailyFortune() {
		return "Just Do It: " + service.getFortune();
	}

}
