package com.luv2code.fortunes;

import java.util.ArrayList;
import java.util.Random;

public class RandomFortune implements FortuneService {
	
	
	ArrayList<FortuneService> services;
	
	public RandomFortune() {
		this.services = new ArrayList<FortuneService>();
		this.services.add(new HappyFortuneService());
		this.services.add(new NormalFortuneService());
		this.services.add(new SadFortuneService());
	}
	
	
	@Override
	public String getFortune() {
		Random rand = new Random();
		
		int i = rand.nextInt(services.size());
		
		return services.get(i).getFortune();
		
		
	}

}
