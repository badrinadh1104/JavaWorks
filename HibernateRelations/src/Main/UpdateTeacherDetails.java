package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Teacher;
import Entity.TeacherDetails;

public class UpdateTeacherDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory f= new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		try {
			s.beginTransaction();
			s.createQuery("update Teacher set TFname='LokeshKumar' where TFname='Lokesk'").executeUpdate();
			s.createQuery("update Teacher set TLname ='Pula' where TLname='Thalari'").executeUpdate();
			s.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			f.close();
			s.close();
		}

	}

}
