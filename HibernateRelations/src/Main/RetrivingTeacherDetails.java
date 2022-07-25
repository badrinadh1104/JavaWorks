package Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Teacher;

public class RetrivingTeacherDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		List<Teacher> teacherlist = null;
		try {
			s.beginTransaction();
			teacherlist = s.createQuery("from Teacher").list();
			for (Teacher i : teacherlist) {
				System.out.println(i);
			}
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
			f.close();
		}

	}

}
