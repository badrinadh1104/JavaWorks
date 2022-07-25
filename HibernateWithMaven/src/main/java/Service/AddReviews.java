package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Teacher;
import Entity.TeacherDetails;

public class AddReviews {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviews.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			s.beginTransaction();
			Course c = new Course("Java");
			Teacher t = s.get(Teacher.class, 1);
			
			t.add(c);
			c.add(new Reviews("King"));
//			Reviews r2 = new Reviews("Good content");
//			c.add(r2);
//			Reviews r3 = new Reviews("Excellent Explanation");
//			c.add(r3);
//			s.save(r1);
//			s.save(r2);
			s.save(c);
			
			
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}

	}

}
