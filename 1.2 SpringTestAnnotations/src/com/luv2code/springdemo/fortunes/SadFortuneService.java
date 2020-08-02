package com.luv2code.springdemo.fortunes;

import org.springframework.stereotype.Component;

// This Bean is defined in the DemoConfig.java file
@Component
public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Sad Fortune";
	}

}
