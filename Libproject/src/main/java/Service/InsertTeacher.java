package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Teacher;
import Entity.TeacherDetails;

public class InsertTeacher {
	
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
			Teacher t = new Teacher("Ande", "Badrinadh", "badri@gmail.com");
			TeacherDetails td = new TeacherDetails("Hyderabad", "Reading Books");
			t.setTeacherDetails(td);
			s.save(t);
			s.getTransaction().commit();
		}finally {
			s.close();
		}
	}

}
