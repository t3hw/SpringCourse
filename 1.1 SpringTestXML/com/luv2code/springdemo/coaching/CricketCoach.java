package com.luv2code.springdemo.coaching;

import com.luv2code.fortunes.FortuneService;

public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("inside cricket constructor");
	}
		
	private FortuneService service;
	private String emailAddress;
	private String team;
	
	public void initStuff() {
		System.out.println("initilizing!");
	}
	
	public void destroyStuff() {
			
		System.out.println("CLOSINGGGG");
	}


	public void setService(FortuneService service) {
		System.out.println("inside setservice");
		this.service = service;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		System.out.println("inside setEmailAddress");
		this.emailAddress = emailAddress;
	}


	
	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		System.out.println("inside setTeam");
		this.team = team;
	}
	
	public void setFortuneService(FortuneService service) {
		this.service = service;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "cricket daily workout";
	}

	@Override
	public String getDailyFortune() {
		return "Cricket fortune: " + service.getFortune();
	}

}
