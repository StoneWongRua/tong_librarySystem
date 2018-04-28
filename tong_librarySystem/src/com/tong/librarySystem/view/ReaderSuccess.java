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
import javax.swing.border.EmptyBorder;

import com.tong.librarySystem.view.BorrowBook;
import com.tong.librarySystem.view.ReturnBook;

import javax.swing.LayoutStyle.ComponentPlacement;
@SuppressWarnings("serial")
public class ReaderSuccess extends JFrame {
	static ReaderSuccess frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ReaderSuccess();
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
	public ReaderSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdminSection = new JLabel("读者操作");
		lblAdminSection.setFont(new Font("宋体", Font.BOLD, 22));
		lblAdminSection.setForeground(Color.BLACK);
		
		JButton btnNewButton = new JButton("检索书籍");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			SearchBook.main(new String[]{});
			frame.dispose();
			
			}
		});
		

		
		JButton btnLogout = new JButton("退出");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnBorrow = new JButton("借阅书籍");
		btnBorrow.setFont(new Font("宋体", Font.PLAIN, 16));
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowBook.main(new String[]{});
				frame.dispose();
			}
		});
		
		JButton btnReturn = new JButton("归还书籍");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.main(new String[]{});
				frame.dispose();
			}
		});
		btnReturn.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(164)
							.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(btnLogout, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
								.addComponent(btnBorrow, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnReturn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAdminSection, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBorrow, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReturn, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

