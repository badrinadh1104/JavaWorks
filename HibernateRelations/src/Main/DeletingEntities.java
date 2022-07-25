package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Teacher;
import Entity.TeacherDetails;

public class DeletingEntities {
	public static void main(String[] args) {
		SessionFactory f= new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		try {
			s.beginTransaction();
			//s.createQuery("delete from Teacher where TFname ='Saikumar'").executeUpdate();
			TeacherDetails t1 = s.get(TeacherDetails.class, 2);
			s.delete(t1);
			s.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			f.close();
			s.close();
		}
	}

}
