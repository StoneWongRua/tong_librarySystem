package com.tong.librarySystem.entity;

import java.util.Date;

public class Borrow {
	private int borrow_id;
	private int ISBN;
	private String book_name;
	private int reader_no;
	private int reader_tel;
	private static Date borrow_date;
	private int admin_no;
	private static Date return_date;
	private int if_back;
	
	public static Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	public int getIf_back() {
		return if_back;
	}
	public void setIf_back(int if_back) {
		this.if_back = if_back;
	}
	public int getBorrow_id() {
		return borrow_id;
	}
	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
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
	public int getReader_no() {
		return reader_no;
	}
	public void setReader_no(int reader_no) {
		this.reader_no = reader_no;
	}
	public int getReader_tel() {
		return reader_tel;
	}
	public void setReader_tel(int reader_tel) {
		this.reader_tel = reader_tel;
	}
	public static Date getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}
	public int getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}
	
}
