package com.service;

import java.util.logging.*;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import java.util.logging.SimpleFormatter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Book;
import com.dao.Bookdao;

import DatabaseLog.Main;
import Exceptions.UpdateException;
import Exceptions.WrongInputError;
//book service class 


public class Bookservice {
	private static Logger logger = Logger.getLogger(Bookservice.class);
	Scanner scan = new Scanner(System.in);

	// method to take the book details from user
	public Book insertBook() {

		Book book = null;
		try {
			Main.writeTolog("Adding Book");
			System.out.println("Enter the Book Id");
			int id = Integer.parseInt(scan.nextLine());
			System.out.println("Enter Bookname");
			String bname = scan.nextLine();
			System.out.println("Enter Book Genre");
			String genre = scan.nextLine();
			System.out.println("Enter Book Author");
			String bauthor = scan.nextLine();
			System.out.println("Enter Book description");
			String bdescription = scan.nextLine();
			System.out.println("Enter  Book Price");
			double price = Double.parseDouble(scan.nextLine());
			System.out.println("Enter number of copies sold");
			int copies = Integer.parseInt(scan.nextLine());
			book = new Book(id, bname, bauthor, price, bdescription, genre, copies);

		} catch (Exception e) {
			logger.warn("Adding Book Error", e);
			logger.info(e.getMessage());
			System.out.println(e.getMessage());
			logger.info("Some Thing Went Wrong Try Again");
			System.out.println("Some Thing Went Wrong Try Again");
		}
		return book;

	}

	// method to check whether book is stored or not

	public String storeBook(Book b) {
		Bookdao bdao = new Bookdao();
		if (bdao.storeBook(b) > 0) {

			Main.writeTolog("Book added sucessFully");
			return "REcord Inserted Sucessfully";
		} else {
			logger.error("Adding Book UnsuccessFul");
			return "Record dint't store";
		}
	}

	// method to check whether book of given book id ,is deleted or not
	public String deleteBook() {
		Bookdao bdao = new Bookdao();
		if (bdao.DeleteBook() > 0) {
			logger.info("Book deleted SucessFully");
			return "Book Deleted!";
		} else {
			try {
				throw new UpdateException("Can't delete the Record");

			} catch (Exception e) {
				// logger.error("Record Not Deleted", e);
				logger.error("Failed to delete the book");
				logger.info(e.getMessage());
			}
			return "Record Not Deleted";
		}
	}

	// method to take the details of the book to update

	public String UpdateBook() {
		logger.info("Updating book");
		Bookdao bdao = new Bookdao();
		if (bdao.UpdateBook() > 0) {
			logger.info("Book updated sucessfully");
			// Mylogger.writeTolog("Book updated sucessfully");
			return "Book Updated!";
		} else {
			try {
				throw new UpdateException("Can't update the Record");

			} catch (Exception e) {
				logger.error("Failed to update the book", e);
				// Mylogger.writeTolog("Failed to update the book", e);
				// TODO: handle exception
				logger.info(e.getMessage());
				System.out.println(e.getMessage());
			}
			return "Update UnSuccessful";
		}
	}

	// method to display all the books

	public String Displayall() {
		Main.writeTolog("Books Description");
		Bookdao bdao = new Bookdao();
		if (!bdao.RetriveBooks().isEmpty()) {
			List<Book> bookslist = bdao.RetriveBooks();
			System.out.println("=====================================================================================");
			for (Book book : bookslist) {
				System.out.println(book.getId() + " " + book.getName());
				Main.writeTolog(book.getId() + " " + book.getName());
			}
			Main.writeTolog("Please Enter the Book name id you want to Describe");
			System.out.println("Please Enter the Book name id you want to Describe");
			int bkid = Integer.parseInt(scan.nextLine());
			logger.info(bkid);
			for (Book book : bookslist) {
				if (book.getId() == bkid) {
					System.out.println("Book name :- " + book.getName());
					System.out.println("Book Genre :- " + book.getGenre());
					System.out.println("Book Author :- " + book.getAuthorname());
					System.out.println("Book description :- " + book.getDescription());
					System.out.println("Book Price :- " + book.getPrice());
					System.out.println("Book Copies sold :- " + book.getCopiesSold());
				}
			}

			System.out.println("=====================================================================================");
			logger.info("Book details Displayed");
			// Mylogger.writeTolog("Book details Displayed");
			return "Successfully retrived";
		} else {
			try {
				throw new WrongInputError("Booklist is empty");
			} catch (Exception e) {
				// TODO: handle exception
				logger.warn("No Book is Available");
				logger.error(e.getMessage());
				System.out.println("No Book is Available");
				return "Sorry UnSucessFul";
			}

		}
	}

	// method to count the total number of books

	public String CountBooks() {
		Bookdao bdao = new Bookdao();
		if (!bdao.RetriveBooks().isEmpty()) {
			logger.info("Total number of books displayed");
			// Mylogger.writeTolog("Total number of books displayed");
			logger.info("TOTAL BOOKS :" + bdao.RetriveBooks().size());
			System.out.println("TOTAL BOOKS :" + bdao.RetriveBooks().size());
			return "Successfully retrived";
		} else {
			logger.info("Total number of books displayed");
			// Mylogger.writeTolog("Total number of books displayed");
			logger.info("TOTAL BOOKS :" + bdao.RetriveBooks().size());
			System.out.println("TOTAL BOOKS :" + bdao.RetriveBooks().size());
			return "SucessFully retrived";
		}
	}

	// method to arrange in the order according to the user choice

	public void Arrange(int choice) {
		Bookdao bdao = new Bookdao();
		// int choice;
		List<Book> booklist = null;
		String con;
		String s;
		// System.out.println("1:Price - Low to High\n" + "2.Price - High to Low\n" +
		// "3.Most selling Book");
		// choice = Integer.parseInt(scan.nextLine());
		if (choice > 0 && choice <= 4) {
			switch (choice) {
			case 1:
				logger.info("books order by price ascending");
				Main.writeTolog("");
				// Mylogger.writeTolog("books order by price ascending");
				s = "from Book order by Price";
				booklist = bdao.ArrangeOrder(s);
				if (!booklist.isEmpty()) {
					System.out.println("=============================================================");
					System.out.println("Books According to price Low to High");
					logger.info("Books According to price Low to High");
					for (Book book : booklist) {
						logger.info(book.getName() + "\t price " + book.getPrice());
						System.out.println(book.getName() + "\t price " + book.getPrice());
					}
					System.out.println("=============================================================");
				} else {
					try {
						throw new UpdateException("No Book is availabe");
					} catch (Exception e) {
						logger.error(e.getMessage());
						logger.info("No Book is Available");
						System.out.println(e.getMessage());
						// TODO: handle exception
					}
				}
				break;
			case 2:
				logger.info("books order by price decending");
				// Mylogger.writeTolog("books order by price decending");
				s = "from Book order by Price desc";
				booklist = bdao.ArrangeOrder(s);
				if (!booklist.isEmpty()) {
					System.out.println("=============================================================");
					logger.info("Books According to price High to Low");
					System.out.println("Books According to price High to Low");
					for (Book book : booklist) {
						logger.info(book.getName() + "\t price " + book.getPrice());
						System.out.println(book.getName() + "\t price " + book.getPrice());
					}
					System.out.println("=============================================================");
				} else {
					try {
						throw new UpdateException("No Book is availabe");
					} catch (Exception e) {
						Main.writeTolog(e.getMessage());
						System.out.println(e.getMessage());
						// TODO: handle exception
					}
				}

				break;
			case 3:

				logger.info("Best selling books");
				// Mylogger.writeTolog("Best selling books ");
				s = "from Book order by CopiesSold desc";
				booklist = bdao.ArrangeOrder(s);
				if (!booklist.isEmpty()) {
					System.out.println("=============================================================");
					System.out.println("Best selling Books");
					for (Book book : booklist) {
						Main.writeTolog(book.getName() + "\t CopiesSold " + book.getCopiesSold());
						System.out.println(book.getName() + "\t CopiesSold " + book.getCopiesSold());
					}
					System.out.println("=============================================================");
				} else {
					try {
						throw new UpdateException("No Book is availabe");
					} catch (Exception e) {
						logger.info("No book is avilable");
						logger.error(e.getMessage());
						System.out.println(e.getMessage());
						// TODO: handle exception
					}
				}

				break;

			default:
				logger.warn("Wrong input");
				System.out.println("Wrong Input");
			}
		} else {
			try {
				throw new WrongInputError("wrong Input Error");
			} catch (Exception e) {
				// TODO: handle exception
				logger.error(e.getMessage());
				System.out.println(e.getMessage());
			}
		}

	}

	// method to display the books related to autobiography

	public String DisplayallbyType() {
		Bookdao bdao = new Bookdao();
		boolean check = false;
		if (!bdao.RetriveBooks().isEmpty()) {
			System.out.println("Please Enter the book Genre");
			String bookname = scan.nextLine();
			List<Book> bookslist = bdao.RetriveBooks();
			for (Book book : bookslist) {
				if (book.getGenre().equalsIgnoreCase(bookname)) {
					check = true;
					break;
				}
			}
			System.out.println("=====================================================================================");
			if (check) {
				logger.info("Display the Books by Genre type");
				for (Book book : bookslist) {
					if (book.getGenre().equalsIgnoreCase(bookname)) {
						logger.info(book.getId() + "\t" + book.getName());
						System.out.println(book.getId() + "\t" + book.getName());

					}
				}

			} else {
				try {
					throw new UpdateException("No Book Found With " + bookname + " genre");
				} catch (Exception e) {
					// TODO: handle exception
					logger.error(e.getMessage());
					logger.warn("No Book Found with the Genre"+bookname);
					// Mylogger.writeTolog("No Book Found with the Genre ", e);
					System.out.println(e.getMessage());
				}
			}
			System.out.println("=====================================================================================");

			return "Successfully retrived";
		} else {
			try {
				throw new UpdateException("No Book is availabe");
			} catch (Exception e) {
				logger.error(e.getMessage());
				logger.info("No book is avilable");
				System.out.println(e.getMessage());
			}
			return "Sorry UnSucessFul";
		}
	}

}
