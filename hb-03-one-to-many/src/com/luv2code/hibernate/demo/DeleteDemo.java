package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start the transaction
			session.beginTransaction();

			// get instructor by primary key
			int theId = 1;
			Instructor tempInstructor = 
					session.get(Instructor.class, theId);
			System.out.println("found the Instructor: "+ tempInstructor);
			
			// delete the instructors
			if(tempInstructor != null) {
				System.out.println("deleting" );
				//also delete Instructor-detail record
				session.delete(tempInstructor);
			}
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		} finally {
			factory.close();
		}
	}

}
