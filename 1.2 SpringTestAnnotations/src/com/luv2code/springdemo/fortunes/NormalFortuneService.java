package com.luv2code.springdemo.fortunes;

import org.springframework.stereotype.Component;

@Component
public class NormalFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Normal Fortune";
	}

}
