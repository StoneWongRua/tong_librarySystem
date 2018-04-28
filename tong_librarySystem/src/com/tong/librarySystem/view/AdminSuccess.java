package com.tong.librarySystem.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tong.librarySystem.dao.ViewIssued;

import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class AdminSuccess extends JFrame {
	static AdminSuccess frame;
	private JPanel contentPane;

	/**
	 * 执行
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new AdminSuccess();
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
	public AdminSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setForeground(Color.black);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLibrarianSection = new JLabel("图书管理系统");
		lblLibrarianSection.setFont(new Font("宋体", Font.BOLD, 22));
		
		JButton btnNewButton = new JButton("添加书籍");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			AddBook.main(new String[]{});
			frame.dispose();
			
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 13));
		
		JButton btnSearch = new JButton("查询书籍");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SearchBook.main(new String[]{});
			}
		});
		btnSearch.setFont(new Font("宋体", Font.PLAIN, 13));
		
		JButton btnBorrow = new JButton("查看借出图书");
		btnBorrow.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {			
				ViewIssued.main(new String[]{});
				frame.dispose();
			}
		});
		
		JButton btnReturnBook = new JButton("图书修改");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ModifyBook.main(new String[]{});
				frame.dispose();
				
			}
		});
		btnReturnBook.setFont(new Font("宋体", Font.PLAIN, 13));
		
		JButton btnLogout = new JButton("退出");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Library.main(new String[]{});
				frame.dispose();
				
			}
		});
		btnLogout.setFont(new Font("宋体", Font.PLAIN, 13));
		
		JButton btnDelBook = new JButton("删除图书");
		btnDelBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelBook.main(new String[]{});
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(Window e) {
				System.exit(0);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(159, Short.MAX_VALUE)
					.addComponent(lblLibrarianSection)
					.addGap(123))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnDelBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReturnBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(btnDelBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(btnBorrow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(btnSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(btnLogout, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
						.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLibrarianSection)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBorrow, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDelBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelBook, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}