package com.tong.librarySystem.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	
	public Statement stmt = null;
	public ResultSet rs = null;
	private static final String URL="jdbc:mysql://localhost:3306/db_tlibrary?useSSL=false";
	private static final String NAME="root";
	private static final String PASSWORD="root";
	private static Connection conn=null;//将加载驱动、连接数据库放入静态块中
	static{
		try {
				//加载驱动程序
				Class.forName("com.mysql.jdbc.Driver");
				
				//获得数据库的连接
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
	
	//获取数据库连接
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
			System.out.println("数据库连接成功XD");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败.");
			e.printStackTrace();
			return null;
		}
	}
	
	//断开数据库连接
	/*
	 * 功能:关闭数据库的连接
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	/*
	 * 功能：执行查询语句
	 */
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			conn = getConnection();
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs  = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return rs;
	}

	/*
	 * 功能:执行更新操作
	 */
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			conn = getConnection();					//调用getConnection()方法构造Connection对象的一个实例conn
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);		//执行更新操作
		} catch (SQLException ex) {
			result = 0;
		}
		return result;
	}

}

