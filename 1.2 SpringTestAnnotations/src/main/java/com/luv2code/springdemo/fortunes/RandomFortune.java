package com.luv2code.springdemo.fortunes;

import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class RandomFortune implements FortuneService {
	
	
	private ArrayList<FortuneService> services;
	private Random rand = new Random();
	
	public RandomFortune() {
	}
	
	@PostConstruct
	private void postConstruct() {
		this.services = new ArrayList<FortuneService>();
		this.services.add(new HappyFortuneService());
		this.services.add(new NormalFortuneService());
		this.services.add(new SadFortuneService());
	}
	
	
	public void addService(FortuneService service) {
		this.services.add(service);
	}
	
	@Override
	public String getFortune() {
		
		
		int i = this.rand.nextInt(services.size());
		
		return services.get(i).getFortune();
		
		
	}

}
