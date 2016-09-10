package lkozlows.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {

		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		System.out.println("Creating new student object...");
		Student tempStudent2 = new Student("Lukasz","Kozlowski","luki@gmail.com");
		Student tempStudent3 = new Student("Wera","Duda","Duda@Dudal.com");
		
		session.beginTransaction();
		
		System.out.println("Saving student...");
		session.save(tempStudent2);
		session.save(tempStudent3);
		
		session.getTransaction().commit();
		
		System.out.println("Done!");
		
		
		
	}
}
