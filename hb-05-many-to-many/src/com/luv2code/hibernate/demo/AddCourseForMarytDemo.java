package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Course;
import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Review;
import com.luv2code.hibernate.demo.entiry.Student;

public class AddCourseForMarytDemo {

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

			//get the student Mary from DB
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			System.out.println("Student "+ tempStudent);
			System.out.println("course "+ tempStudent.getCourses());
			
			//create more courses
			Course tempCourse1 = new Course("Rubik's cu");
			Course tempCourse2 = new Course("Atari 2600");
			
			//add Mary to those courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			//save the course
			System.out.println("\n save course");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			session.close();
			factory.close();
		}
	}

}
