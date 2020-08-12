package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
									.buildSessionFactory();

		System.out.println("heyoooo");

		InstructorDemo instructorDemo = new InstructorDemo();
		
		instructorDemo.CreateInstructors(factory);
		instructorDemo.DeleteInstructor(factory);
		instructorDemo.GetInstructorDetail(factory);
		instructorDemo.CascadeDeleteInstructor(factory);
		instructorDemo.DeleteInstructorDetail(factory);
		
		factory.close();
		
	}

	
}
