package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class HibernateDemoMain {

	public static void main(String[] args) {
		
		System.out.println("heyo");

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		System.out.println("heyoooo");
		
		StudentDemo studentDemo = new StudentDemo();
		
		studentDemo.CreateStudent(factory);
		studentDemo.CreateMultiple(factory);
		studentDemo.ReadStudent(factory);
		studentDemo.queryStudents(factory);
		studentDemo.updateStudent(factory);
		studentDemo.updateAllEmails(factory);
		studentDemo.deleteSingleJava(factory);
		studentDemo.deleteSingleHQL(factory);
		studentDemo.addStudentWithBirthDate(factory);
		
		factory.close();
		
	}

	
}
