package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session Factory
		SessionFactory factory = new Configuration()
			                       	 .configure("hibernate.cfg.xml")
			                       	 .addAnnotatedClass(Instructor.class)
			                       	 .addAnnotatedClass(InstructorDetail.class)
			                       	 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			//create the objs
//			Instructor tempInstructor = 
//					new Instructor("had","Darby","darby@luv2code.com");
//		
//			InstructorDetail tempInstructorDetail =
//					new InstructorDetail("http://www.luv2code.com",
//							"Luv 2 code");
			
			Instructor tempInstructor = 
					new Instructor("Madhu","Patel","madhu@luv2code.com");
		
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.youtube.com",
							"Guitar");
			
			//associate the obj
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start the transaction
			session.beginTransaction();
			
			//save the instructor and instructorDetail(CascadeType.ALL )
			System.out.println("save instructor & instructorDetail "+ tempInstructor);
			session.save(tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally{
			factory.close();
		}
	}

}
