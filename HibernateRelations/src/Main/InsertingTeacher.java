package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Course;
import Entity.Reviews;
import Entity.Student;
import Entity.Teacher;
import Entity.TeacherDetails;

public class InsertingTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Reviews.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session s = f.getCurrentSession();
		Teacher t1 = new Teacher("Lokesk", "Pula", "Lokesh@gmail.com");
		Teacher t2 = new Teacher("Saikumar", "Pula", "Sai@gmail.com");
		Teacher t3 = new Teacher("PraveenKumar", "Pula", "Praveen@gmail.com");
		t1.setTeacherD(new TeacherDetails("WatchingCricket", "Pune"));
		t2.setTeacherD(new TeacherDetails("PlayingCricket", "Hyderabad"));
		t3.setTeacherD(new TeacherDetails("CodingJava", "Canada"));
//		Course c1 = new Course("Python");
//		Course c2 = new Curse("Java");
//		Course c3 = new Course("Dotnet");
//		Course c4 = new Course("FrontEnd");
//		Course c5 = new Course("C++");
//		Course c6 = new Course("Golang");
//		t1.add(c1);
//		t2.add(c2);
//		t3.add(c3);
//		t1.add(c4);
//		t1.add(c5);
//		t1.add(c6);
		try {
			s.beginTransaction();
			s.save(t1);
			s.save(t2);
			s.save(t3);
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			f.close();
			s.close();
		}

	}

}
