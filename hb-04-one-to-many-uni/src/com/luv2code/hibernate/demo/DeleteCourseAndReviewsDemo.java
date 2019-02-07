package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Course;
import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			//get course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			//print course
			System.out.println("Delete the course ： " +tempCourse);
			
			//delete 
			session.delete(tempCourse);
		
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();
			factory.close();
		}
	}

}
