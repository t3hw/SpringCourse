package com.luv2code.springdemo.coaching;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.luv2code.springdemo.fortunes.FortuneService;

@Component
@Scope("prototype")
public class TennisCoach implements Coach,DisposableBean {

	@Autowired
	//@Qualifier("sadFortuneService")
	@Qualifier("randomFortune")
	private FortuneService service;
	@Value("${foo.email}")
	private String emailAddress;
	@Value("${foo.team}")
	private String team;

	//@Autowired
	public TennisCoach(/*FortuneService service*/) {
		//this.service = service;
		System.out.println("***tennis constructor");
	}
	
	
	// Init Method
	@PostConstruct
	public void doStartupStuff() {
		System.out.println("***Tennis startup");
	}
	
	//@Autowired
	public void setFortuneService(/*FortuneService service*/) {
		//this.service = service;
		System.out.println("***setter");
	}

	@Override
	public String getDailyWorkout() {
		return "Tennis Workout";
	}
	
	@Override
	public String getDailyFortune() {
		return "TennisCoach: " + service.getFortune();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	
	// Destruction Method
	@PreDestroy
	public void destructionMethod() {
		System.out.println("***Tennis destroy");
		System.out.println(this.getEmailAddress());
		System.out.println(this.getTeam());
		
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("DESTROYING THIS: " + this);
		
	}
}
