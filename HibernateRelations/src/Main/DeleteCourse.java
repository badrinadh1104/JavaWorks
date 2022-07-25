package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Teacher;
import Entity.TeacherDetails;

public class DeleteCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(TeacherDetails.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		try {
			s.beginTransaction();
			Course c = s.get(Course.class, 1);
			s.delete(c);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
			f.close();

		}

	}

}
