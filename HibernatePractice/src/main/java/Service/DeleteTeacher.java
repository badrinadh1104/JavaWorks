package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Teacher;
import Entity.TeacherDetails;

public class DeleteTeacher {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(Teacher.class).addAnnotatedClass(TeacherDetails.class).buildSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
			TeacherDetails td = s.get(TeacherDetails.class,3);
			Teacher t = s.get(Teacher.class, 2);
			if(td!=null) {
				s.delete(td);
				System.out.println("Deleted SuccessFully "+td);
			}else {
				System.out.println("sorry");
			}
			s.getTransaction().commit();

		}finally {
			s.close();
		}
	}

}
