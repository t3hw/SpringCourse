package com.luv2code.hibernate.demo;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Student;

public class StudentDemo {

	private void displayStudents(List<Student> theStudents) {
		// display the students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	public void CreateStudent(SessionFactory factory) {
		System.out.println("**** CreateStudent ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating new student object");
			Student tempStudent = new Student("Paul", "Wall", "paul@wall.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student");
			session.save(tempStudent);

			// commit transaction

			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void CreateMultiple(SessionFactory factory) {
		System.out.println("**** CreateMultiple ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create 3 student object
			System.out.println("Creating 3 student object");
			Student tempStudent1 = new Student("Jon", "Doe", "JD@wall.com");
			Student tempStudent2 = new Student("Mary", "Public", "Mary@wall.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "BApple@wall.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction

			session.getTransaction().commit();

			System.out.println(tempStudent1);
			System.out.println(tempStudent2);
			System.out.println(tempStudent3);

			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void ReadStudent(SessionFactory factory) {
		System.out.println("**** ReadStudent ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create 3 student object
			System.out.println("Creating Duffy Duck");
			Student tempStudent1 = new Student("Duffy", "Duck", "duffy@duck.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving Duffy");
			session.save(tempStudent1);
			System.out.println(tempStudent1);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Committing!");

			// find out the student's id: primary key
			int studentId = tempStudent1.getId();

			System.out.println("Retrieving from DB");
			session = factory.getCurrentSession();

			session.beginTransaction();
			Student selectedStudent = session.get(Student.class, studentId);
			session.getTransaction().commit();

			System.out.println(selectedStudent);

			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public void queryStudents(SessionFactory factory) {
		System.out.println("**** queryStudents ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// query students
			System.out.println("Get all students");
			List<Student> theStudents = session.createQuery("from Student s").getResultList();

			displayStudents(theStudents);

			// use where clause
			System.out.println("\n\nGet last name Doe or first name Daffy");
			theStudents = session.createQuery("from Student s " + "where s.lastName='Doe' " + "or s.firstName='Daffy'")
					.getResultList();

			displayStudents(theStudents);

			// use like modifier clause
			System.out.println("\n\nGet 'wall' email address");
			theStudents = session.createQuery("from Student s " + "where s.email like '%wall.com'").getResultList();

			displayStudents(theStudents);

			// commit session
			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public void updateStudent(SessionFactory factory) {
		System.out.println("**** updateStudent ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Update STOODENT");

			int studentID = 1;

			Student student;

			// start a transaction
			session.beginTransaction();

			// getting student
			student = session.get(Student.class, studentID);

			student.setFirstName("STOODENT");

			// commit transaction

			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public void updateAllEmails(SessionFactory factory) {
		System.out.println("**** updateAllEmails ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// getting student
			session.createQuery("update Student set email='foo@gmail.com'")
				.executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}
	
	public void deleteSingleJava(SessionFactory factory) {
		System.out.println("**** deleteSingleJava ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Deleting Student - java");

			int studentID = 2;

			Student student;

			// start a transaction
			session.beginTransaction();

			// getting student
			student = session.get(Student.class, studentID);

			session.delete(student);

			// commit transaction

			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public void deleteSingleHQL(SessionFactory factory) {
		System.out.println("**** deleteSingleHQL ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// getting student
			session.createQuery("delete Student where id = 3")
				.executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}
	

	public void addStudentWithBirthDate(SessionFactory factory) {
		System.out.println("**** addStudentWithBirthDate ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating new student object");

			String dateString = "04/10/1230";
			Date birthDate = DateUtils.parseDate(dateString);
			Student tempStudent = new Student("Geralt", "Of Rivia", "geralt@witcher.com", birthDate);
			
			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student");
			session.save(tempStudent);

			// commit transaction

			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		
	}
}
