package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Student;

public class DeleteStudentDemo {

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
		     
	//delete 
//		     System.out.println("delete : " + myStudent );
//		     session.delete(myStudent);
		     
		     // use query to delete
		     System.out.println("delete : id =2"    );
		     session.createQuery("delete from Student where id=2").executeUpdate();
		     
			
			session.getTransaction().commit();
						
			System.out.println("done");
		}finally{
			factory.close();
		}
	}

}
