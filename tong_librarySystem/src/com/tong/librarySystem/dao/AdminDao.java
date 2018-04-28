package com.tong.librarySystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.tong.librarySystem.util.DbUtil;

public class AdminDao {
	
	public static boolean checkId(int admin_no) {
		boolean status = false;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from admin where admin_no = ?");
			ps.setInt(1, admin_no);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "该用户不存在。");
			System.out.println(e);
		}
		return status;
	}

	public static boolean validate(int admin_no,int admin_psw){//验证用户名和密码
		boolean status = false;
		try{
			
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from admin where admin_no=? and admin_psw=?");
			ps.setInt(1, admin_no);
			ps.setInt(2, admin_psw);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
			}
		
		return status;
	}

	public static int sign(int admin_no,int admin_psw){
		int status = 0;
		
		try{
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into admin(admin_no, admin_psw) values(?,?)");
			ps.setInt(1, admin_no);
			ps.setInt(2,admin_psw);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){
			
			System.out.println(e);
			
			}
		return status;
	}
	
}