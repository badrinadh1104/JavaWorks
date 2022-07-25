package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Teacher;
import Entity.TeacherDetails;

public class RetriveTeacherAndCourseDetails {
	public static void main(String[] args) {
		SessionFactory f= new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(Course.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Reviews.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		try {
			s.beginTransaction();
			Teacher t = s.get(Teacher.class, 3);
			System.out.println("*****TeacherDetails*****");
			System.out.println(t);
			System.out.println("*****Course Details*****");
			System.out.println(t.getCourse());
			s.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}
	}

}
