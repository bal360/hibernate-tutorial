package com.blakelong.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.blakelong.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	
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
			Student tempStudent = new Student("Mika", "Long", "mika@email.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Save the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// Now read student from database
			// find the student's id: primary key
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("\n Getting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
