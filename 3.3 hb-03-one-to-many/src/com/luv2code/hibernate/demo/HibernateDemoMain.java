package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class HibernateDemoMain {

	public static void main(String[] args) {
		
		System.out.println("heyo");

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();

		System.out.println("heyoooo");

		InstructorDemo instructorDemo = new InstructorDemo();
		
		instructorDemo.CreateInstructors(factory);
		instructorDemo.CreateCourses(factory);
		instructorDemo.GetInstructorCourses(factory);
		instructorDemo.DeleteCourse(factory);
		
		factory.close();
		
	}

	
}
