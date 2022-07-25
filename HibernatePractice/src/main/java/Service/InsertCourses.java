package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Teacher;
import Entity.TeacherDetails;

public class InsertCourses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
			Teacher t = s.get(Teacher.class, 1);
			
			s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
