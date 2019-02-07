package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session Factory
		SessionFactory factory = new Configuration()
			                       	 .configure("hibernate.cfg.xml")
			                       	 .addAnnotatedClass(Student.class)
			                       	 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
				int studentId = 1;
			
			//get new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id
			System.out.println("\nGetting studnet id : " + studentId);
			
		     Student myStudent = session.get(Student.class, studentId);
		     
		     System.out.println("update student: "); 
		     myStudent.setFirstName("Scooby");
		     	     
			// commit the transaction
			session.getTransaction().commit();
		    
			//Update email 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("update email: "); 
			session.createQuery("update Student set email='foo@gmail.com'")
			                  .executeUpdate();
			
			session.getTransaction().commit();
			
			
			System.out.println("done");
		}finally{
			factory.close();
		}
	}

}
