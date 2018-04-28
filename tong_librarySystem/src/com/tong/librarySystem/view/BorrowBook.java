package com.tong.librarySystem.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.tong.librarySystem.dao.BookDao;


@SuppressWarnings("serial")
public class BorrowBook extends JFrame {
	static BorrowBook frame;
	private JPanel contentPane;
	private JTextField textISBN;
	private JTextField textBookName;
	private JTextField textReaderNo;
	private JTextField testReaderTel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new BorrowBook();
					frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * 创建窗体
	 */
	public BorrowBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBookBorrow = new JLabel("借阅书籍 ");
		lblBookBorrow.setFont(new Font("宋体", Font.BOLD, 18));
		lblBookBorrow.setForeground(Color.BLACK);
		
		JLabel lblISBN = new JLabel("书籍编号:");		
		textISBN = new JTextField();
		textISBN.setColumns(10);
		
		JLabel lblBookName = new JLabel("图书书名:");		
		textBookName = new JTextField();
		textBookName.setColumns(10);
		
		JLabel lblReaderNo = new JLabel("学生学号:");		
		textReaderNo = new JTextField();
		textReaderNo.setColumns(10);
		
		JLabel lblReaderTel = new JLabel("联系方式:");		
		testReaderTel = new JTextField();
		testReaderTel.setColumns(10);
		
		
		JButton btnIssueBook = new JButton("借阅书籍");
		btnIssueBook.addActionListener(new ActionListener() {//添加事件
			public void actionPerformed(ActionEvent e) {
				
			int ISBN = Integer.parseInt(textISBN.getText());//从文本框获取整型
			
			String bookName = textBookName.getText();
			
			int readerNo = Integer.parseInt(textReaderNo.getText());
			
			int readerTel = Integer.parseInt(testReaderTel.getText());
			
	        Date dateU=new Date();
	        java.sql.Date date=new java.sql.Date(dateU.getTime());
			
			if(BookDao.checkBook(ISBN)){
				
				int i = BookDao.borrow(ISBN, bookName, readerNo, readerTel, date);
				
				if(i > 0){
						JOptionPane.showMessageDialog(BorrowBook.this,"成功借出该书！");
						AdminSuccess.main(new String[]{});
						frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(BorrowBook.this,"检查用户是否存在!");
					System.exit(0);
				}
			}
			else{
				JOptionPane.showMessageDialog(BorrowBook.this,"抱歉，该书不存在!");
				System.exit(0);
			}
			
			}
		});
		
		JButton btnBack = new JButton("返回");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(Window e) {
				System.exit(0);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("注意：核实自己的学号！");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblISBN)
								.addComponent(lblBookName)
								.addComponent(lblReaderNo, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblReaderTel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textBookName, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textReaderNo, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(testReaderTel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addGap(48))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(47)
									.addComponent(btnBack)))
							.addGap(100))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(146)
					.addComponent(lblBookBorrow)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblBookBorrow)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblISBN)
						.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookName)
						.addComponent(textBookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReaderNo)
						.addComponent(textReaderNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReaderTel)
						.addComponent(testReaderTel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}
}