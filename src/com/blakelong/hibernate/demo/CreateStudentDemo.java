package com.blakelong.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.blakelong.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create student object
			System.out.println("Creating student object...");
			Student tempStudent = new Student("Blake", "Long", "bal@email.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Save the student");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
