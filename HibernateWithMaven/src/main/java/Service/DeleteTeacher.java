package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Teacher;
import Entity.TeacherDetails;

public class DeleteTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviews.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			s.beginTransaction();
			Course t = s.get(Course.class, 1);
			s.delete(t);
			
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}

	}

}
