package com.tong.librarySystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tong.librarySystem.util.DbUtil;


public class ReturnBookDao {//�鼮�黹
	public static int delete(String bookcallno,int studentid){
		int status = 0;
		try{
			Connection con = DbUtil.getConnection();
			
			status = updatebook(bookcallno);//����ʣ�����Լ����������
			
			if(status > 0){
			
				PreparedStatement ps = con.prepareStatement("delete from issuebooks where bookcallno=? and studentid=?");//�ӡ�������顱��ɾ�����������Ϣ
				ps.setString(1,bookcallno);
				ps.setInt(2,studentid);
				status = ps.executeUpdate();
				
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
	
	public static int updatebook(String bookcallno){//���¿����Ϣ��
		int status = 0;
		int quantity = 0, issued = 0;
		try{
			Connection con = DbUtil.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select quantity,issued from books where callno=?");
			ps.setString(1,bookcallno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				quantity = rs.getInt("quantity");
				issued = rs.getInt("issued");
			}
			
			if(issued > 0){
			PreparedStatement ps2 = con.prepareStatement("update books set quantity=?,issued=? where callno=?");
			
			ps2.setInt(1,quantity+1);
			ps2.setInt(2,issued-1);
			ps2.setString(3,bookcallno);
			
			status = ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
			}
		return status;
	}
}
