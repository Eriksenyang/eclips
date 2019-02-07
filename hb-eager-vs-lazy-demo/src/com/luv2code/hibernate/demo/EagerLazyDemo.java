package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Course;
import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start the transaction
			session.beginTransaction();

			// get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("luv@ Instructor: " + tempInstructor);
			
		
			System.out.println("luv@ Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();

			//close the session
			session.close();
			
			System.out.println("\n the session is closed \n");
			// solution1- load when session is open
			// get course for the instructor
			System.out.println("luv@ Courses: " + tempInstructor.getCourses());

			System.out.println("luv@ done");
		} finally {

			session.close();
			factory.close();
		}
	}

}
