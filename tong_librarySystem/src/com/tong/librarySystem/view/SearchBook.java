package com.tong.librarySystem.view;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.tong.librarySystem.dao.BookDao;
import com.tong.librarySystem.entity.Book;
import com.tong.librarySystem.util.DbUtil;


@SuppressWarnings("serial")
public class SearchBook extends JFrame {

	private JPanel contentPane;
	private JTable bookTable;
	private JTextField textName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SearchBook frame = new SearchBook();
					frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchBook() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String data[][] = null;
		String column[] = null;
		try{
			Connection con = DbUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from book",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			column=new String[cols];
			for(int i = 1; i <= cols; i++){
				column[i-1] = rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();

			data = new String[rows][cols];
			int count = 0;
			while(rs.next()){
				for(int i = 1; i <= cols; i++){
					data[count][i-1] = rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){
			System.out.println(e);
			}
		JScrollPane sp = new JScrollPane();
		
		JLabel label = new JLabel("输入书名：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		textName = new JTextField();
		textName.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(sp, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(label)
							.addGap(18)
							.addComponent(textName, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(sp, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		
		bookTable = new JTable();
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"编号", "书名", "作者", "出版社", "剩余数量", "借出数量"
			}
		));
		sp.setViewportView(bookTable);
		contentPane.setLayout(gl_contentPane);
		this.fillTable(new Book());
	}
	

	private void bookSearchActionPerformed(ActionEvent evt) {
		String name = textName.getText();
		Book book = new Book();
		book.setBook_name(name);
		this.fillTable(book);
	}
	/*
	 * 初始化表格
	 * 
	 * 
	 * */
	private void fillTable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel)bookTable.getModel();
		dtm.setRowCount(0);//查询以后清空表格
		Connection conn = null;
		try {
			conn = DbUtil.getConnection();
			ResultSet rs = BookDao.list(conn, book);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getInt("ISBN"));
				v.add(rs.getString("book_name"));
				v.add(rs.getString("book_author"));
				v.add(rs.getString("book_publisher"));
				v.add(rs.getString("book_quantity"));
				v.add(rs.getString("book_issued"));
				dtm.addRow(v);
			}
		}catch(Exception ee) {
			ee.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
