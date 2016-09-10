package lkozlows.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Jojo","Kozlowska","jojo@gmail.com");
		
		session.beginTransaction();
		
		System.out.println("Saving student...");
		session.save(tempStudent);
		
		session.getTransaction().commit();
		
		System.out.println("Done!");
		
		
		
	}

}
