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
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Library extends JFrame {
	static Library frame;
	private JPanel contentPane;

	/**
	 * 执行
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new Library();
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
	public Library() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLibraryManagement = new JLabel("图书管理系统");
		lblLibraryManagement.setFont(new Font("宋体", Font.BOLD, 18));
		lblLibraryManagement.setForeground(Color.black);
		
		JButton btnReaderLogin = new JButton("读者登录");
		btnReaderLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ReaderLogin.main(new String[]{});
			frame.dispose();
			}
		});
		btnReaderLogin.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnLibrarianLogin = new JButton("管理员登录");
		btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLogin.main(new String[]{});
			}
		});
		btnLibrarianLogin.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnLibrarianLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnReaderLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(151)
							.addComponent(lblLibraryManagement)))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblLibraryManagement)
					.addGap(18)
					.addComponent(btnReaderLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLibrarianLogin, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}