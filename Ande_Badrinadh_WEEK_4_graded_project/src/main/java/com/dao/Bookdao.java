//Book dao class used to write functions  to store data in Database MySQl
package com.dao;
import java.util.List;

import java.util.Scanner;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Book;
import com.service.Bookservice;

import DatabaseLog.Main;
//creating class Bookdao to connect with database
public class Bookdao {
	Scanner scan = new Scanner(System.in);
	
	//method to store book in database

	public int storeBook(Book b) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			s.beginTransaction();
			s.save(b);
			s.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			Main.WriteWarnlog(e.getMessage());
		} finally {
			f.close();
			s.close();
		}
		return 0;
	}
	
	//method to delete book from the database

	public int DeleteBook() {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		List<Book> booklist = RetriveBooks();
		System.out.println("Book Information");
		for(Book i: booklist) {
			System.out.println(i.getId()+" "+i.getName());
		}
		System.out.println("Please Enter the Book name id you want to delete");
		int id= Integer.parseInt(scan.nextLine());
		
		try {
			s.beginTransaction();
			Book b = s.get(Book.class, id);
			try {
			s.delete(b);
			s.getTransaction().commit();
			return 1;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e) {
			Main.writeTolog(e.getMessage());
		} finally {
			f.close();
			s.close();
		}
		return 0;
	}

	
	//method to updatebook in the database
	
	public int UpdateBook() {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		List<Book> booklist = RetriveBooks();
		System.out.println("Book Information");
		for(Book i: booklist) {
			System.out.println(i.getId()+" "+i.getName());
		}
		System.out.println("Please Enter the Book name id you want to Update");
		int id= Integer.parseInt(scan.nextLine());
		try {
			s.beginTransaction();
			Book b = s.get(Book.class, id);
			try {
			System.out.println("Enter Book Price");
			double price = Double.parseDouble(scan.nextLine()); 
			System.out.println("Enter  number of copies sold");
			int copies = Integer.parseInt(scan.nextLine());
			b.setPrice(price);
			b.setCopiesSold(copies);
			s.getTransaction().commit();
			return 1;
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				System.out.println("some thing went wrong try again");
			}
		} catch (Exception e) {
			Main.writeTolog(e.getMessage());
		} finally {
			f.close();
			s.close();
		}
		return 0;
	}
	
	//method to get the list of books

	public List<Book> RetriveBooks() {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		List<Book> bookslist = null;
		try {
			s.beginTransaction();
			bookslist = s.createQuery("from Book").list();
			s.getTransaction().commit();
			return bookslist;
		} catch (Exception e) {
			Main.writeTolog(e.getMessage());
			e.printStackTrace();
		} finally {
			f.close();
			s.close();
		}
		return null;
	}
	
	//method to arrange the books in order
	
	public List<Book> ArrangeOrder(String stmt) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		List<Book> bookslist = null;
		try {
			s.beginTransaction();
			bookslist = s.createQuery(stmt).list();
			s.getTransaction().commit();
			return bookslist;
		} catch (Exception e) {
			Main.writeTolog(e.getMessage());
			e.printStackTrace();
		} finally {
			f.close();
			s.close();
		}
		return null;
	}

	

}
