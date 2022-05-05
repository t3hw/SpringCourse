package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.springdemo.coaching.Coach;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach theCoach2 = context.getBean("tennisCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach2.getDailyFortune());
		
		// close the context
		context.close();

	}

}
