package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session Factory
		SessionFactory factory = new Configuration()
			                       	 .configure("hibernate.cfg.xml")
			                       	 .addAnnotatedClass(Student.class)
			                       	 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			//create a student obj
		  System.out.println("creating new student obj");
		  Student tempStudent = new Student("Daffy","Duck","daffy@love.com");
			// start the transaction
			session.beginTransaction();
			// save student obj
			System.out.println("save student " + tempStudent);
		
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			
			//new code find the student's id
			System.out.println("Saved student. Generated id : " + tempStudent.getId());
			
			//get new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id
			System.out.println("\nGetting studnet id : " + tempStudent.getId());
			
		     Student myStudent = session.get(Student.class, tempStudent.getId());
		     
		     System.out.println("get complete: "+ myStudent); 
			// commit the transaction
			session.getTransaction().commit();
		     
			System.out.println("done");
		}finally{
			factory.close();
		}
	}

}
