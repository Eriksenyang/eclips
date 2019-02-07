package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Course;
import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Review;
import com.luv2code.hibernate.demo.entiry.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

		// create session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			//create a course
			Course tempCourse = new Course("Pacman - How to Score ");
			
			System.out.println("\n save course " + tempCourse);
			session.save(tempCourse);
			
			//create student
			Student tempStudent1 = new Student("John","Soe","john@luv2.com");
			Student tempStudent2 = new Student("Mary","public","mary@luv2.com");
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			//save teh students
			System.out.println("\n save student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("saved student "+ tempCourse.getStudents());
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();
			factory.close();
		}
	}

}
