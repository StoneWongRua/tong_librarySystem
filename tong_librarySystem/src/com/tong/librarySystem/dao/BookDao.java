package com.tong.librarySystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JOptionPane;

import com.tong.librarySystem.entity.Book;
import com.tong.librarySystem.util.DbUtil;
import com.tong.librarySystem.util.StringUtil;
import com.tong.librarySystem.view.BorrowBook;

public class BookDao {
/*
 * 添加书籍
 * 
* */
	public static int add(int ISBN, String book_name, String book_author, String book_publisher, int book_quantity, int book_rest){
		int status = 0;
		
		try{
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into book(ISBN, book_name, book_author,book_publisher, book_quantity, book_issued) values(?,?,?,?,?,?)");
			ps.setInt(1, ISBN);
			ps.setString(2,book_name);
			ps.setString(3,book_author);
			ps.setString(4, book_publisher);
			ps.setInt(5,book_quantity);
			ps.setInt(6, book_rest);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){
			
			System.out.println(e);
			
			}
		return status;
	}
/*
 * 删除书籍
 * 
 */
	public static int del(int ISBN) {
		int status = 0;
		try {
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from book where ISBN = ?");
			ps.setInt(1, ISBN);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			
			System.out.println(e);
		}
		return status;
	}
/*
 * 修改书籍
 * 
 * */

public static int modify(int ISBN, String book_name, String book_author, int book_quantity, int book_issued) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getConnection();
		int status = 0;
		String sql = "";
		sql = "select * from book where ISBN = " + ISBN;
		
		try {
			java.sql.Statement stm = DbUtil.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()) {
				sql = "update book set book_name = '" + book_name +"', book_author = '" + book_author + "', book_quantity = '" + book_quantity + "', book_issued = '"
 +  book_issued + "'where ISBN = "+ ISBN;
				status = stm.executeUpdate(sql);
				con.close();
				}
		else {
			JOptionPane.showMessageDialog(null, "该书籍不存在");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

/*
 * 检查书籍是否存在
 * 
 * */

public static boolean checkBook(int ISBN) {
	boolean status = false;
	try {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from book where ISBN = ?");
		ps.setInt(1, ISBN);
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		con.close();
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, "该书籍不存在");
		System.out.println(e);
	}
	return status;
}


	
/*
 * 借出书籍
 * 
 * */
public static int borrow(int ISBN, String book_name,int reader_no, int reader_tel, java.sql.Date borrow_date) {
	int status = 0;
	try {
		Connection con = DbUtil.getConnection();
		status = updatebook(ISBN);
		if(status > 0) {
			PreparedStatement ps = con.prepareStatement("insert into borrow(ISBN, book_name, reader_no, reader_tel, borrow_date) values(?,?,?,?,?)");
			ps.setInt(1, ISBN);
			ps.setString(2, book_name);
			ps.setInt(3, reader_no);
			ps.setInt(4, reader_tel);
			Date dateU=new Date();
	        ps.setDate(5, borrow_date);
			status = ps.executeUpdate();
			con.close();
		}
		
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null,"检查用户是否存在");
		e.printStackTrace();
		System.exit(0);
	}
	return status;
}
/*
 * 更新书籍数量
 * 
 * */

public static int updatebook(int ISBN){
	int status=0;
	int book_quantity=0,book_issued=0;
	try{
		Connection con=DbUtil.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select book_quantity,book_issued from book where ISBN = ?");
		ps.setInt(1,ISBN);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			book_quantity=rs.getInt("book_quantity");
			book_issued=rs.getInt("book_issued");
		}
		
		if(book_issued > 0){
		PreparedStatement ps2=con.prepareStatement("update book set book_quantity=?,book_issued=? where ISBN=?");
		ps2.setInt(1,book_quantity - 1);
		ps2.setInt(2,book_issued + 1);
		ps2.setInt(3,ISBN);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}


/*
 *归还书籍
 * 
 * */

public static int back(int ISBN, String book_name,int reader_no, int reader_tel, java.sql.Date return_date) {
	int status = 0;
	try {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into return(ISBN, book_name, reader_no, reader_tel, return_date) values(?,?,?,?,?)");
		ps.setInt(1, ISBN);
		ps.setString(2, book_name);
		ps.setInt(3, reader_no);
		ps.setInt(4, reader_tel);
		Date dateU=new Date();
        ps.setDate(5, return_date);
		status = ps.executeUpdate();
		con.close();
		}
		catch(Exception er) {
		JOptionPane.showMessageDialog(null, "该用户没有借阅图书");	
		er.printStackTrace();
	}
	return status;
}
/*
 * 更新库存
 * 
 * */
public static int updatebook1(int ISBN){
	int status=0;
	int book_quantity=0,book_issued=0;
	try{
		Connection con=DbUtil.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select book_quantity,book_issued from book where ISBN = ?");
		ps.setInt(1,ISBN);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			book_quantity=rs.getInt("book_quantity");
			book_issued=rs.getInt("book_issued");
		}
		
		if(book_issued > 0){
		
			PreparedStatement ps2=con.prepareStatement("update book set book_quantity=?,book_issued=? where ISBN=?");
			ps2.setInt(1,book_quantity + 1);
			ps2.setInt(2,book_issued - 1);
			ps2.setInt(3,ISBN);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){
		System.out.println(e);
		}
	return status;
}



/*
 * 书籍模糊查询
 * 
 * */

public static ResultSet list(Connection con,Book book)throws Exception{
	StringBuffer sb=new StringBuffer("select * from book");
	if(StringUtil.isNotEmpty(book.getBook_name())){
		sb.append(" and book_name like '%"+book.getBook_name()+"%'");
	}
	PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
	return pstmt.executeQuery();
}

}
