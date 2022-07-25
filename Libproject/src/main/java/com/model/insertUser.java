package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class insertUser {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(User.class)
				.addAnnotatedClass(completedBk.class).addAnnotatedClass(WishListedBk.class).buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
//		User user = new User("Badrinadh", "1234", "6302103964", "badri2gmail.com", "ROLE_USER");
		User user =s.get(User.class, 1);
//		WishList wl = new WishList(2);
//		completedList cl = new completedList(1);
//		user.AddtoWishList(wl);
//		user.AddtoCompletedList(cl);
//		s.save(cl);
//		s.save(wl);
//		s.save(user);
		//System.out.println(user.getCompletedList().get(1).getBookId());
		
		s.getTransaction().commit();

	}
}
