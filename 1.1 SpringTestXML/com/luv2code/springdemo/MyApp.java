package com.luv2code.springdemo;

import com.luv2code.springdemo.coaching.*;
import com.luv2code.springdemo.coaching.Coach;

public class MyApp {

	public static void main(String[] args) {

		// create the object
		//Coach theCoach = new TrackCoach();
		//Coach theCoach = new BaseballCoach();
		Coach theCoach = new CricketCoach();
		
		//use the object
		System.out.println(theCoach.getDailyWorkout());
		theCoach.getDailyWorkout();
		
		
	}

}
