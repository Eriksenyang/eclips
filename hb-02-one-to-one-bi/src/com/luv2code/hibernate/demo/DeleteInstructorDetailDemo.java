package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start the transaction
			session.beginTransaction();
			
			//get the instructor-detail obj
			int theId = 4;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			//print the instructor-detail
			System.out.println("Instructor Detail : "+ tempInstructorDetail);                   
			
			//print the associated instructor
			System.out.println("The associate Instructor : "+
			       tempInstructorDetail.getInstructor());
		 
			//delete instructor-detail
			System.out.println("Delete Instructor-detail : "+
				       tempInstructorDetail);
			
			//remove the associated obj ref
			//break bi directional link
			//*****
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		} 
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
