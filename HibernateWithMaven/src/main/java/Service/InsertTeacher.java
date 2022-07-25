package Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Teacher;
import Entity.TeacherDetails;

public class InsertTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Reviews.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			s.beginTransaction();
			Teacher t = new Teacher("sai", "Pula", "sai@gmail.com");
			TeacherDetails ts = new TeacherDetails("Hyderabad","Coding");
			t.setTeacherService(ts);
			s.save(t);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}

	}

}
