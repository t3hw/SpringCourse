package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.luv2code.springdemo.coaching.Coach;
//import com.luv2code.springdemo.coaching.CricketCoach;
import com.luv2code.springdemo.coaching.CricketCoach;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load spring config file
		System.out.println("*Loading Context*");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-xml.xml"); 
		
		// retrieve bean from spring container
		System.out.println("*Getting Bean*");
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods on the bean
		System.out.println("*Calling methods*");
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getClass().equals(CricketCoach.class)? ((CricketCoach)theCoach).getTeam() : "not a cricket coach");
		
		// close the context
		System.out.println("*Closing Context*");
		context.close();
		
		System.out.println("*Done*");

	}

}
