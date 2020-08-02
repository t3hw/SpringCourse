package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.luv2code.springdemo.coaching.Coach;
import com.luv2code.springdemo.coaching.SwimCoach;
import com.luv2code.springdemo.fortunes.FortuneService;
import com.luv2code.springdemo.fortunes.SadFortuneService;

@Configuration
@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:app.properties")
public class DemoConfig {
	
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
	
}
