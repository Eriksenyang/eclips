package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Student;

public class CreateStudentDemo {

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
		  Student tempStudent = new Student("Paul","Wall","paul@love.com");
			// start the transaction
			session.beginTransaction();
			// save student obj
			System.out.println("save student");
			session.save(tempStudent);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("done");
		}finally{
			factory.close();
		}
	}

}
