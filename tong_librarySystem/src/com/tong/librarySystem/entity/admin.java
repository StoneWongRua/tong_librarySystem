
package com.tong.librarySystem.entity;

public class Admin {
	private static int admin_id;
	private static int admin_no;
	private static int admin_psw;
	
	public int getAdmin_id() {
		return admin_id;
	}
	public static void setAdmin_id(int admin_id) {
		Admin.admin_id = admin_id;
	}
	public static int getAdmin_no() {
		return admin_no;
	}
	public static void setAdmin_no(int admin_no) {
		Admin.admin_no = admin_no;
	}
	public static int getAdmin_psw() {
		return admin_psw;
	}
	public static void setAdmin_psw(int admin_psw) {
		Admin.admin_psw = admin_psw;
	}
	
}
