package com.blakelong.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.blakelong.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()	
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// start transaction
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: " + studentId);
			
			// retrieve student with given id
			Student myStudent = session.get(Student.class, studentId);
			
			// update first name - only in memory at this point
			// all we need is setFirstName and commit since this is already a persisted object
			System.out.println("Updating student...");
			myStudent.setFirstName("Juan");
			
			// save to db - commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			System.out.println(myStudent);
			
			
		} finally {
			factory.close();
		}
		
		
	}

}
