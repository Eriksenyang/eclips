package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Course;
import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Review;

public class CreateCourseAndReviewsDemo {

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

			//create a course
			Course tempCourse = new Course("Pacman - How to Score ");
			
			//add some reviews
			tempCourse.addReview(new Review("Create course1 "));
			tempCourse.addReview(new Review("Create course2 "));
			tempCourse.addReview(new Review("Create course 3"));
			
			//save the course ... and leverage the cascade all 
			System.out.println("save Course : "+ tempCourse.getReviews());
			session.save(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();
			factory.close();
		}
	}

}
