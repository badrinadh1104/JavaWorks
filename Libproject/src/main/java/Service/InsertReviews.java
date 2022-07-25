package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Teacher;
import Entity.TeacherDetails;

public class InsertReviews {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviews.class).buildSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
			Teacher t = s.get(Teacher.class, 1);
			Course c = t.getCourses().get(1);
			c.addreviews(new Reviews("Good"));
			c.addreviews(new Reviews("Superb"));
			c.addreviews(new Reviews("Excellent"));
//			t.addCourse(c);
//			s.save(c);
			s.getTransaction().commit();
		}finally {
			s.close();
		}
	}

}
