package com.tong.librarySystem.entity;

public class Reader {
	private int reader_id;
	private static Reader reader_no;
	private String reader_name;
	private String reader_psw;
	private int reader_tel;
	public int getReader_id() {
		return reader_id;
	}
	public void setReader_id(int reader_id) {
		this.reader_id = reader_id;
	}
	public static Reader getReader_no() {
		return reader_no;
	}
	public void setReader_no(Reader reader_no) {
		this.reader_no = reader_no;
	}
	public String getReader_name() {
		return reader_name;
	}
	public void setReader_name(String reader_name) {
		this.reader_name = reader_name;
	}
	public String getReader_psw() {
		return reader_psw;
	}
	public void setReader_psw(String reader_psw) {
		this.reader_psw = reader_psw;
	}
	public int getReader_tel() {
		return reader_tel;
	}
	public void setReader_tel(int reader_tel) {
		this.reader_tel = reader_tel;
	}
	
	
}
