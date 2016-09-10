package lkozlows.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.com.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		int studentId = 4;
		session =  factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("\nStudent id "+studentId);
		
		Student myStudent = session.get(Student.class, studentId);
		
		System.out.println("\nStudent skasowany: "+ myStudent);
		//delete
		session.delete(myStudent);
		
		session.createQuery("delete from Student where id=3").executeUpdate();
		session.getTransaction().commit();
		
	
		
	
		//END
		System.out.println("Done!");
		
		
		
	}

}
