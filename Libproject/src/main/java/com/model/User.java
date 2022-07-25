package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Username;
	private String password;
	private String phone;
	private String email;
	private String usertype;
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private List<WishListedBk> wishlist;
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private List<completedBk> completedlist;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String phone, String email, String usertype) {
		super();
		Username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.usertype = usertype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public List<WishListedBk> getWishlist() {
		return wishlist;
	}
	public void setWishlist(List<WishListedBk> wishlist) {
		this.wishlist = wishlist;
	}
	public List<completedBk> getCompletedlist() {
		return completedlist;
	}
	public void setCompletedlist(List<completedBk> completedlist) {
		this.completedlist = completedlist;
	}
	public void addBookIDtoWishlist(WishListedBk bk) {
		if(wishlist==null) {
			wishlist= new ArrayList<WishListedBk>();
		}
		wishlist.add(bk);
	}
	public void addBookIDtocompletedLList(completedBk bk) {
		if(completedlist==null) {
			completedlist= new ArrayList<completedBk>();
		}
		completedlist.add(bk);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + Username + ", password=" + password + ", phone=" + phone + ", email="
				+ email + ", usertype=" + usertype + ", wishlist=" + wishlist + ", completedlist=" + completedlist
				+ "]";
	}
	
	
}




/*
 id:number;
    userName:String;
    Password:String;
    Phone:String;
    Email:String;
    Usertype:String;
    WishList:number[];
    Completed:number[];
  */
 