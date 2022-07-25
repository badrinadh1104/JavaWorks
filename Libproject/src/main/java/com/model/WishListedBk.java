package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WishListedBk {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int BookId;
	public WishListedBk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WishListedBk( int bookId) {
		super();
		BookId = bookId;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	
//	private User user;

}
