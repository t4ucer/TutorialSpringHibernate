package lkozlows.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		//QUERY STUDENTS
		List<Student> theStudents = session.createQuery("from Student").getResultList();
		
		for (Student tempStudent : theStudents) {
		System.out.println(tempStudent);
		}
		
		theStudents = session.createQuery("from Student s where s.lastName='Kozlowska'").getResultList();
		
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
			}
		
		session.getTransaction().commit();
		
		System.out.println("Done!");
		
		
		
	}

}
