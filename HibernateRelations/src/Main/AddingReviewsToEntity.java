package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Student;
import Entity.Teacher;
import Entity.TeacherDetails;

public class AddingReviewsToEntity {
	public static void main(String[] args) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Reviews.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		try {
			s.beginTransaction();
//			Course c = new Course("Csharp");
			Course c = s.get(Course.class, 1);
			//Teacher t = s.get(Teacher.class, 1);
			
			c.add(new Reviews("Fabulous"));
			c.add(new Reviews("Good content"));
			c.add(new Reviews("Excellent Explanation"));
			c.add(new Reviews("Good"));
			//t.add(c);
			s.save(c);
			s.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}
	}

}
