package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Teacher;
import Entity.TeacherDetails;

public class InsertTeacherDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).buildSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
			Teacher t = new Teacher("Ande", "Badrinadh", "badri@gl.com");
			TeacherDetails td = new TeacherDetails( "Hyderabad", "JavaLearner");
			t.setTeacherDetails(td);
			s.save(t);
			s.getTransaction().commit();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
