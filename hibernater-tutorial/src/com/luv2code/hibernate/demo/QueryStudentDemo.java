package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session Factory
		SessionFactory factory = new Configuration()
			                       	 .configure("hibernate.cfg.xml")
			                       	 .addAnnotatedClass(Student.class)
			                       	 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
				// start the transaction
			session.beginTransaction();
			
			//query student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the student
			displayStudents(theStudents);
			
			//last name to doe
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			System.out.println("Print Last name Doe");
			displayStudents(theStudents);
			
			//last name = doe or first name= Daffy
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			System.out.println("Print Last name Doe/Daffy");
			displayStudents(theStudents);
			
			//email
			theStudents = session.createQuery("from Student s where s.email LIKE '%@love.com'").getResultList();
			System.out.println("Print email like");
			displayStudents(theStudents);
			
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done");
		}finally{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents ) {
			System.out.println(tempStudent);
		}
	}

}
