package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class InstructorDemo {
	public void CreateInstructors(SessionFactory factory) {
		System.out.println("**** CreateInstructor ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
			System.out.println("Creating new Instructor object");
			Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail tempDetails = new InstructorDetail("http://www.luv2code.com/youtube", "CODING!");
//			Instructor tempInstructor2 = new Instructor("Ravid", "Gontov", "rvdgntv@gmail.com");
//			InstructorDetail tempDetails2 = new InstructorDetail("http://www.luv2code.com/t3hw", "things!");
//			Instructor tempInstructor3 = new Instructor("Louis", "Louis", "oxy@l4d.com");
//			InstructorDetail tempDetails3 = new InstructorDetail("http://www.luv2code.com/PILLS_HERE", "Taking pills!");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempDetails);
//			tempInstructor2.setInstructorDetail(tempDetails2);
//			tempInstructor3.setInstructorDetail(tempDetails3);


			// start a transaction
			session.beginTransaction();

			// save the instructor object
			System.out.println("Saving the instructor: " + tempInstructor);
			session.save(tempInstructor);
//			session.save(tempInstructor2);
//			session.save(tempInstructor3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	
	public void CreateCourses(SessionFactory factory) {
		System.out.println("**** CreateCourses ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int instructorId = 1;
			Instructor tempInstructor = session.get(Instructor.class, instructorId);
			
			// create some courses
			Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			Course tempCourse3 = new Course("Beat Saber - Slash Like A Pro");
			
			// add courses to instructor
			tempInstructor.addCourse(tempCourse1);
			tempInstructor.addCourse(tempCourse2);
			tempInstructor.addCourse(tempCourse3);
			
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}


	public void GetInstructorCourses(SessionFactory factory) {
		System.out.println("**** GetInstructorCourses ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the instructor from db
			int instructorId = 1;
			Instructor tempInstructor = session.get(Instructor.class, instructorId);
			
			System.out.println("Instructor: " + tempInstructor);
			
			
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}


	public void DeleteCourse(SessionFactory factory) {
		System.out.println("**** DeleteCourse ****");
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get the course from the db
			int id = 2;
			Course course = session.get(Course.class, id);
			
			// delete course
			session.delete(course);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
	}

	
	
//	public void DeleteInstructor(SessionFactory factory) {
//		System.out.println("**** DeleteInstructor ****");
//		
//		// create session
//		Session session = factory.getCurrentSession();
//
//		try {
//			// start a transaction
//			session.beginTransaction();
//
//			
//			// get instructor by primary id
//			int id = 1;
//			Instructor tempInstructor = session.get(Instructor.class,  id);
//			
//			// got the instructor object
//			System.out.println("Instructor found: " + tempInstructor);
//			
//			// delete the instructor
//			if (tempInstructor != null ) {
//				System.out.println("Deleting: " + tempInstructor);
//				
//				// note: will cascade down the FK tree
//				session.delete(tempInstructor);
//			}
//			
//			// commit transaction
//			session.getTransaction().commit();
//
//			System.out.println("Done!");
//
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		}
//		finally {
//			session.close();
//		}
//		
//	}
//
//	public void GetInstructorDetail(SessionFactory factory) {
//		System.out.println("**** GetInstructorDetail ****");
//		
//		// create session
//		Session session = factory.getCurrentSession();
//
//		try {
//			// start a transaction
//			session.beginTransaction();
//			
//			// get the instructor detail object
//			int detailId = 2;
//			InstructorDetail tempDetails = session.get(InstructorDetail.class, detailId);
//			
//			// print the instructor detail
//			System.out.println("tempInstructorDetail: " + tempDetails);
//			
//			// print the associate instructor
//			System.out.println("the associated instructor: " + tempDetails.getParentInstructor());
//
//			// commit transaction
//			session.getTransaction().commit();
//
//			System.out.println("Done!");
//
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		}
//		finally {
//			session.close();
//		}
//		
//	}
//
//	public void CascadeDeleteInstructor(SessionFactory factory) {
//		System.out.println("**** CascadeDeleteInstructor ****");
//		
//		// create session
//		Session session = factory.getCurrentSession();
//
//		try {
//			// start a transaction
//			session.beginTransaction();
//			
//			// get the instructor detail object
//			int detailId = 2;
//			InstructorDetail tempDetails = session.get(InstructorDetail.class, detailId);
//			
//			// print the instructor detail
//			System.out.println("tempInstructorDetail: " + tempDetails);
//			
//			// print the associate instructor
//			System.out.println("the associated instructor: " + tempDetails.getParentInstructor());
//
//			// now delete it
//			System.out.println("DELETING! " + tempDetails.getParentInstructor());
//			session.delete(tempDetails.getParentInstructor());
//			
//			
//			// commit transaction
//			session.getTransaction().commit();
//
//			System.out.println("Done!");
//
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		}
//		finally {
//			session.close();
//		}
//		
//	}
//
//
//	public void DeleteInstructorDetail(SessionFactory factory) {
//		System.out.println("**** DeleteInstructorDetail ****");
//		
//		// create session
//		Session session = factory.getCurrentSession();
//
//		try {
//			// start a transaction
//			session.beginTransaction();
//			
//			// get the instructor detail object
//			int detailId = 3;
//			InstructorDetail tempDetails = session.get(InstructorDetail.class, detailId);
//			
//			// print the instructor detail
//			System.out.println("tempInstructorDetail: " + tempDetails);
//			
//			// print the associate instructor
//			System.out.println("the associated instructor: " + tempDetails.getParentInstructor());
//
//
//			// remove the associated object reference
//			// break the bi-directional link
//			tempDetails.getParentInstructor().setInstructorDetail(null);
//
//			// now delete it
//			System.out.println("DELETING! " + tempDetails);
//			session.delete(tempDetails);
//			
//			// commit transaction
//			session.getTransaction().commit();
//
//			System.out.println("Done!");
//
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			e.printStackTrace();
//		}
//		finally {
//			session.close();
//		}
//		
//	}


}
