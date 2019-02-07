package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session Factory
				SessionFactory factory = new Configuration()
					                       	 .configure("hibernate.cfg.xml")
					                       	 .addAnnotatedClass(Student.class)
					                       	 .buildSessionFactory();
				//create session
				Session session = factory.getCurrentSession();
				
				try {			
					//create 3 student obj
				  System.out.println("creating 3 students obj");
				  Student tempStudent1 = new Student("John","Doe","john@love.com");
				  Student tempStudent2 = new Student("Mary","Public","mary@love.com");
				  Student tempStudent3 = new Student("Bonita","App","bonita@love.com");
					// start the transaction
					session.beginTransaction();
					// save student obj
					System.out.println("save student");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					//commit transaction
					session.getTransaction().commit();
					System.out.println("done");
				}finally{
					factory.close();
				}
			}
	}

