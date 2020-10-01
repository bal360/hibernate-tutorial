package com.blakelong.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.blakelong.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create new session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// start a transaction
			session.beginTransaction();
			
			// retrieve student with given id
//			Student myStudent = session.get(Student.class, studentId);
//			System.out.println("\nGetting student with id of: " + myStudent.getId());
			
			// delete the student
//			session.delete(myStudent);
			

			// ------- alternate way to delete using HQL and query -------
			System.out.println("\nDeleting student with id of: 2");
			session.createQuery("DELETE FROM Student WHERE id=2").executeUpdate();
			
			// delete the student = commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
