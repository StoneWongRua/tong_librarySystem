package com.tong.librarySystem.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.tong.librarySystem.dao.BookDao;

@SuppressWarnings("serial")
public class ModifyBook extends JFrame {
	static ModifyBook frame;
	private JPanel contentPane;
	private JTextField textISBN;
	private JTextField textBookName;
	private JTextField textAuthor;
	private JTextField textQuantity;
	private JTextField textIssued;
	
	/**
	 * 执行
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ModifyBook();
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
	public ModifyBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddBooks = new JLabel("修改书籍");
		lblAddBooks.setForeground(Color.black);
		lblAddBooks.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblISBN = new JLabel("编号:");
		textISBN = new JTextField();
		textISBN.setColumns(10);
		
		JLabel lblBookName = new JLabel("书名:");
		textBookName = new JTextField();
		textBookName.setColumns(10);
		
		JLabel lblBookAuthor = new JLabel("作者:");
		textAuthor = new JTextField();
		textAuthor.setColumns(10);
		
		JLabel lblBookQuantity = new JLabel("剩余:");
		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		
		JLabel lblBookIssued = new JLabel("借出:");	
		textIssued = new JTextField();
		textIssued.setColumns(10);
				
		JButton btnAddBooks = new JButton("修改书籍");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			int ISBN = Integer.parseInt(textISBN.getText());		
			String name = textBookName.getText();
			String author = textAuthor.getText();
			int quantity = Integer.parseInt(textQuantity.getText());		
			int issued = Integer.parseInt(textIssued.getText());
			
			int i = BookDao.modify(ISBN, name, author, quantity, issued);
			
			if(i > 0){
				
					JOptionPane.showMessageDialog(ModifyBook.this,"书籍修改成功！");
					AdminSuccess.main(new String[]{});
					frame.dispose();
				
			}
			else
			{
				
				JOptionPane.showMessageDialog(ModifyBook.this,"抱歉，保存出错。");
				
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(lblAddBooks))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblBookName, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblISBN)
								.addComponent(lblBookAuthor, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBookQuantity, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblBookIssued, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textIssued, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addComponent(textQuantity, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addComponent(textAuthor, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addComponent(textBookName, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addComponent(textISBN, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))))
					.addContainerGap(128, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(96)
					.addComponent(btnBack)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddBooks)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblISBN)
						.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookName)
						.addComponent(textBookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookAuthor)
						.addComponent(textAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookQuantity)
						.addComponent(textQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookIssued)
						.addComponent(textIssued, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}