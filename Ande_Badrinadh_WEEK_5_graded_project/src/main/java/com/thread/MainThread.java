package com.thread;

import com.main.MagicOfBooks;
import DatabaseLog.Main;

public class MainThread {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main.writeTolog(" Main Thread started");
		MagicOfBooks t = new MagicOfBooks();
		Thread thread = new Thread(t);
		//start the Program
		thread.start();

	}

}
//Book [id=1, name=Telugu Literature, authorname=Anamaya, description=Telugu Literature By Anamaya, genre=Literature, Price=52.6, CopiesSold=20]
//Book [id=2, name=Hindi Literature, authorname=premchandh, description=Hindi Literature by premChandh, genre=Literature, Price=33.88, CopiesSold=10]
//Book [id=3, name=English Literature, authorname=stephen hawkins, description=English literature by stephen hawkins, genre=Literature, Price=99.5, CopiesSold=90]
//Book [id=4, name=Satya ke Prayog, authorname=Mohandas Karamchand Gandhi, description=Satya ke Prayog by Mohandas Karamchand Gandhi, genre=autobiography, Price=105.66, CopiesSold=150]
