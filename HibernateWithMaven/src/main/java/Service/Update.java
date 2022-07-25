package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Teacher;
import Entity.TeacherDetails;

public class Update {
	public static void main(String[] args) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviews.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			s.beginTransaction();
			s.createQuery("update TeacherDetails set Hobby ='Coding' where id=1").executeUpdate();
			
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}
	}

}
