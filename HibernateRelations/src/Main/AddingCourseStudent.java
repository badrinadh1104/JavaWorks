package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Student;
import Entity.Teacher;
import Entity.TeacherDetails;

public class AddingCourseStudent {
	public static void main(String[] args) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Reviews.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		try {
			s.beginTransaction();
			Course c = s.get(Course.class, 2);
			Student s1 = new Student("Badrinadh", "Ande", "Badri@2001");
			Student s2 = new Student("Sainadh", "Ande ", "SAi@2001");
			c.addstudent(s1);
			c.addstudent(s2);
			s.save(s1);
			s.save(s2);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}

	}
}