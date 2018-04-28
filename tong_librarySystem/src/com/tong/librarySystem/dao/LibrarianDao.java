package com.tong.librarySystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tong.librarySystem.util.DbUtil;

public class LibrarianDao {

	public static boolean validate(int admin_no,int admin_psw){//验证管理员登录信息
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
	
}
