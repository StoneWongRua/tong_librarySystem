package com.tong.librarySystem.entity;

import java.sql.Connection;
import java.sql.ResultSet;

public class Book {
	private int ISBN;
	private String book_name;
	private String book_author;
	private String book_publisher;
	private int book_quantity;
	private int book_issued;

	
	
	public Book() {
		super();
	}
	
	public Book(int ISBN, String book_name, String book_author, String book_publisher,int book_quantity, int book_issued ) {
		super();
		this.book_name = book_name;
		this.book_publisher = book_publisher;
		this.book_author = book_author;
		this.book_issued = book_issued;
		this.book_quantity = book_quantity;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_publisher() {
		return book_publisher;
	}

	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}

	public int getBook_quantity() {
		return book_quantity;
	}

	public void setBook_quantity(int book_quantity) {
		this.book_quantity = book_quantity;
	}

	public int getBook_issued() {
		return book_issued;
	}

	public void setBook_issued(int book_issued) {
		this.book_issued = book_issued;
	}

}
