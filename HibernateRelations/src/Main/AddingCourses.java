package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Student;
import Entity.Teacher;
import Entity.TeacherDetails;

public class AddingCourses {
	public static void main(String[] args) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Reviews.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		Course c1 = new Course("Python");
		Course c2 = new Course("Java");
		Course c3 = new Course("Dotnet");
		Course c4 = new Course("FrontEnd");
		Course c5 = new Course("C++");
		Course c6 = new Course("Golang");
		try {
			s.beginTransaction();
			Teacher t1 = s.get(Teacher.class, 3);
			t1.add(c6);
			t1.add(c5);
			t1.add(c4);
			t1.add(c3);
			
			s.save(c3);
			s.save(c4);
			s.save(c5);
			s.save(c6);

			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
			f.close();
		}
	}
}
