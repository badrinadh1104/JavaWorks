package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Teacher;
import Entity.TeacherDetails;

public class UpdatingIndividualEntity {

	public static void main(String[] args) {
		SessionFactory f= new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		try {
			s.beginTransaction();
			TeacherDetails t = s.get(TeacherDetails.class,1 );
			t.setHobby("ReadingBooks");
			s.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}

	}

}
