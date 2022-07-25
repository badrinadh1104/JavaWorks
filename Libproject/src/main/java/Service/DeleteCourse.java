package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Teacher;
import Entity.TeacherDetails;

public class DeleteCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviews.class).buildSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
//			Teacher t = s.get(Teacher.class, 1);
			Course c = s.get(Course.class, 2);
			s.delete(c);
			s.getTransaction().commit();
		}finally {
			s.close();
		}

	}

}
