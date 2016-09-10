package lkozlows.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		int studentId = 1;
		session =  factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("\nStudent id"+studentId);
		
		Student myStudent = session.get(Student.class, studentId);
		
		System.out.println("Student before update: "+ myStudent);
		
		//single UPDATE
		myStudent.setFirstName("Scooby");
		System.out.println("Student AFTER update: "+ myStudent);
		
		List <Student> theStudents = session.createQuery("from Student").getResultList();
		
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
			}
		
		//multi UPDATE
		session.createQuery("update Student set email='kokoddddddddkok@gmail.com'").executeUpdate();
		
		
		theStudents = session.createQuery("from Student").getResultList();
		
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
			}
		session.getTransaction().commit();
		
	
		
	
		
		System.out.println("Done!");
		
		
		
	}

}
