package com.main;

import java.util.Scanner;
import com.bean.Book;
import com.service.Bookservice;

import DatabaseLog.Main;
import Exceptions.WrongInputError;

//implementing thread concept
public class MagicOfBooks implements Runnable {
	@Override
	// implementing thread concept
	public void run() {
		Bookservice bs = new Bookservice();
		Scanner scan = new Scanner(System.in);
		int choice;
		String con1 = null;
		int con2;
		String con3;
		boolean strt = true;
		// program MENU start
		while (strt) {
			Main.writeTolog("Please Enter Your Role(User/Admin)");
			System.out.println("Please Enter Your Role(User/Admin)");
			String name = scan.nextLine();
			Main.writeTolog(name);
			if (name.equalsIgnoreCase("Admin")) {
				do {
					System.out.println("************** MENU ***********\n" + "1:Add Books\n" + "2.Delete Books\n"
							+ "3.UpdateBooks\n" + "4.Display all the Books\n" + "Enter your Choice");
					choice = Integer.parseInt(scan.nextLine());
					if (choice >= 1 && choice <= 4) {
						switch (choice) {
						// to insert the book
						case 1:
							Book b = bs.insertBook();
							System.out.println(bs.storeBook(b));
							Main.writeTolog("Do you want to continue");
							System.out.println("Do you want to continue");
							con1 = scan.nextLine();
							Main.writeTolog(con1);
							if (con1.equalsIgnoreCase("no")) {
								System.out.println("Press 1 from Main Menu and 0 For Exit!");
								int num1 = Integer.parseInt(scan.nextLine());
								if (num1 == 0) {
									strt = false;
									Main.writeTolog("Program ends");
								}
							}
							break;
						case 2:
							// to delete the book
							System.out.println(bs.deleteBook());
							Main.writeTolog("Do you want to continue");
							System.out.println("Do you want to continue");
							con1 = scan.nextLine();
							Main.writeTolog(con1);
							if (!con1.equalsIgnoreCase("yes")) {
								System.out.println("Press 1 from Main Menu and 0 For Exit!");
								int num1 = Integer.parseInt(scan.nextLine());
								if (num1 == 0) {
									strt = false;
									Main.writeTolog("Program ends");
								}
							}
							break;
						case 3:
							// to update book
							System.out.println(bs.UpdateBook());
							Main.writeTolog("Do you want to continue");
							System.out.println("Do you want to continue");
							con1 = scan.nextLine();
							Main.writeTolog(con1);
							if (con1.equalsIgnoreCase("no")) {
								System.out.println("Press 1 from Main Menu and 0 For Exit!");
								int num1 = Integer.parseInt(scan.nextLine());
								if (num1 == 0) {
									strt = false;
									Main.writeTolog("Program ends");
								}
							}
							break;
						case 4:
							// to switch to inner menu
//							System.out.println(bs.Displayall());
							boolean condi = true;
							int input;
							while (condi) {
								// inner menu display
								System.out.println("************** MENU ***********\n" + "1:Display Book Count\n"
										+ "2.Dislay via Genre\n" + "3.Book Information\n"
										+ "4.Arrange Books From Low to high\n" + "5.Arrange Price from High to Low\n"
										+ "6.Arrange Best selling On top\n" + "Enter your Choice");
								input = Integer.parseInt(scan.nextLine());
								switch (input) {
								// Total count Of Books
								case 1:
									System.out.println(bs.CountBooks());
									break;
								// Display book by Genre
								case 2:
									bs.DisplayallbyType();
									break;
								case 3:
									// Display book Discription
									System.out.println(bs.Displayall());
									break;
								case 4:
									// display book in Ascending Order
									bs.Arrange(1);
									break;
								case 5:
									// display book in Descending Order
									bs.Arrange(2);
									break;
								case 6:
									// Display Most Selling Book;
									bs.Arrange(3);
									break;
								default:
									try {
										throw new WrongInputError("Entered the Wrong Input");
									} catch (Exception e) {
										// TODO: handle exception
										System.out.println(e.getMessage());
									}
								}
								Main.writeTolog("Do you want to continue");
								System.out.println("Do you want to continue");
								con3 = scan.nextLine();
								Main.writeTolog(con3);
								if (con3.equalsIgnoreCase("no")) {
									System.out.println("Press 1 from Main Menu and 0 For Exit!");
									int num1 = Integer.parseInt(scan.nextLine());
									if (num1 == 0) {
										Main.writeTolog("Program ends");
										strt = false;
										con1 = "no";
									} else {
										con1 = "yes";
									}
									condi = false;

								}
							}
							break;


						default:
							//throwing user defined exception
							try {
								throw new WrongInputError("Entered the Wrong Input");
							} catch (Exception e) {
								// TODO: handle exception
								Main.WriteWarnlog(e.getMessage());
								System.out.println(e.getMessage());
							}

						}
					} else {
						//throwing user defined exception
						try {
							con1 = "y";
							throw new WrongInputError("Entered the Wrong Input");
						} catch (Exception e) {
							Main.writeTolog("Entered the wrong input");
							// TODO: handle exception
							System.out.println(e.getMessage());
						}
					}

				} while (con1.equalsIgnoreCase("yes"));//condition to repeat the menu
			} else {
				Main.writeTolog("Invalid Role!. Please Reenter");
				System.out.println("Invalid Role!.\nPlease ReEnter\r");
			}

		}
		System.out.println("Thank You");
		Main.writeTolog("Thank you!");

	}

}

//System.out.println("Do you want to Continue badri");
//con1=scan.nextLine();
//if(con1.equalsIgnoreCase("no")) {
//	strt=false;
//}