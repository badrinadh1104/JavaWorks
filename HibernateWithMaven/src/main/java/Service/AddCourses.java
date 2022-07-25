package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Teacher;
import Entity.TeacherDetails;

public class AddCourses {
	public static void main(String[] args) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviews.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			s.beginTransaction();
		    Course c = new Course("Dot");
			Teacher t = new Teacher("Pula","Lokesh","Lokesh@123gmail.com");
			
		c.add(new Reviews("Fabulous"));
//			c.add(new Reviews("Good content"));
//			c.add(new Reviews("Excellent Explanation"));
//			c.add(new Reviews("Good"));
//			t.add(c);
//		    t.add(c);
//		    s.save(t);
			s.save(t);
			//s.save(c);
			s.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}
	}

}
