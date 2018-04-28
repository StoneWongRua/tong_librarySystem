package com.tong.librarySystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.tong.librarySystem.util.DbUtil;

public class ReaderDao {
	
	public static boolean checkId(int reader_no) {
		boolean status = false;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from reader where reader_no = ?");
			ps.setInt(1, reader_no);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "该用户不存在");
			System.out.println(e);
		}
		return status;
	}

	public static boolean validate(int reader_no,int reader_psw){//验证用户名及密码
		boolean status = false;
		try{
			
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from reader where reader_no=? and reader_psw=?");
			ps.setInt(1, reader_no);
			ps.setInt(2, reader_psw);
			ResultSet rs = ps.executeQuery();
			status = rs.next();			
			con.close();
			
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int sign(int reader_no,int reader_psw){//注册
		int status = 0;
		
		try{
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into reader(reader_no, reader_psw) values(?,?)");
			ps.setInt(1, reader_no);
			ps.setInt(2,reader_psw);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){
			
			System.out.println(e);
			
			}
		return status;
	}
}
