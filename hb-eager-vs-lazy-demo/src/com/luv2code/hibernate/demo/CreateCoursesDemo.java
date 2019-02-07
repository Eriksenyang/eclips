package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entiry.Course;
import com.luv2code.hibernate.demo.entiry.Instructor;
import com.luv2code.hibernate.demo.entiry.InstructorDetail;
import com.luv2code.hibernate.demo.entiry.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		//create session Factory
		SessionFactory factory = new Configuration()
			                       	 .configure("hibernate.cfg.xml")
			                       	 .addAnnotatedClass(Instructor.class)
			                       	 .addAnnotatedClass(InstructorDetail.class)
			                       	.addAnnotatedClass(Course.class)
			                       	 .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
						session.beginTransaction();
						
						// get the instructor from db
						int theId = 1;
						Instructor tempInstructor = session.get(Instructor.class, theId);		
					
						
						// create some courses
						Course tempCourse1 = new Course("5");
						Course tempCourse2 = new Course("6");
						
						// add courses to instructor
						tempInstructor.add(tempCourse1);
						tempInstructor.add(tempCourse2);
						
						
						// save the courses
						session.save(tempCourse1);
						session.save(tempCourse2);
						
						// commit transaction
						session.getTransaction().commit();
						
						System.out.println("Done!");
		}finally{
			
			session.close();
			factory.close();
		}
	}

}
