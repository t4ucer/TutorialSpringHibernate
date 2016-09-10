package lkozlows.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.Student;

public class ReadStudentDemo {

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
		System.out.println(tempStudent);
		session.save(tempStudent);
		
		session.getTransaction().commit();
		
		
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		System.out.println("\nStudent id"+tempStudent.getId());
		
		Student myStudent = session.get(Student.class, tempStudent.getId());
		System.out.println("Read student: "+ myStudent);
		
		session.getTransaction().commit();
		
		System.out.println("Done!");
		
		
		
	}

}
