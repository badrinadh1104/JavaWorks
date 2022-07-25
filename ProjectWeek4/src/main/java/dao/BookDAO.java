package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Book;
public class BookDAO {
	public int storeBook(Book b) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			s.beginTransaction();
			s.save(b);
			s.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			f.close();
			s.close();
		}
		return 0;
	}

}
