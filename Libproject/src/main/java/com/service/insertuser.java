package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.User;
import com.model.WishListedBk;
import com.model.completedBk;

public class insertuser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf = new Configuration().configure().addAnnotatedClass(User.class)
				.addAnnotatedClass(completedBk.class).addAnnotatedClass(WishListedBk.class).buildSessionFactory();
		Session s = sf.openSession();
		try {
			s.beginTransaction();
			User  u = new User("Badrinadh","1234", "6302103964", "badri@gmail.com", "Role_User");
			completedBk bk = new completedBk(1);
			WishListedBk bk2 = new WishListedBk(2);
			u.addBookIDtocompletedLList(bk);
			u.addBookIDtoWishlist(bk2);
			s.save(u);
			s.save(bk2);
			s.save(bk);
			s.getTransaction().commit();
		}finally {
			s.close();
		}
		

	}

}
