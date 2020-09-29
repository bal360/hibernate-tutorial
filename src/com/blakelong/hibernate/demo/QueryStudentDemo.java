package com.blakelong.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.blakelong.hibernate.demo.entity.Student;
import java.util.*;

public class QueryStudentDemo {
	
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("FROM Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName="Doe"
			theStudents = session.createQuery("FROM Student WHERE lastName='Doe'").getResultList();
			
			// display students with last name of Doe
			System.out.println("\nStudent with last name of Doe:");
			displayStudents(theStudents);
			
			// query students: lastName='Doe' OR firstName='Mika'
			theStudents = session.createQuery("FROM Student WHERE lastName='Doe' OR firstName='Mika'").getResultList();
			System.out.println("\nStudent with last name of Doe OR first name of Mika:");
			displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
