package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Teacher;

public class RetriveOneteacher {
	public static void main(String[] args) {
		SessionFactory f= new Configuration().configure().addAnnotatedClass(Teacher.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		try {
			s.beginTransaction();
			Teacher t= s.get(Teacher.class, 3);
			System.out.println(t);
			System.out.println("Completed");
		}
		catch(Exception e){
			System.out.println("hey Went Wrong");
			e.printStackTrace();
		}finally {
			s.close();
			f.close();
		}
	}

}
