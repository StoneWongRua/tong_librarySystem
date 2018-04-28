package com.tong.librarySystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tong.librarySystem.dao.BookDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })
public class DelBook extends JFrame {

	static DelBook frame;
	private JPanel contentPane;
	private JTextField textISBN;
	private JTextField textBookName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DelBook();
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
	public DelBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDelBook = new JLabel("删除书籍信息");
		lblDelBook.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblISBN = new JLabel("编号:");
		textISBN = new JTextField();
		textISBN.setColumns(10);
		
		JLabel lblBookName = new JLabel("书名：");
		lblBookName.setFont(new Font("宋体", Font.PLAIN, 16));
		
		textBookName = new JTextField();
		textBookName.setColumns(10);
		
		
		
		JButton button = new JButton("删除书籍");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ISBN = Integer.parseInt(textISBN.getText());
				//String book_name = textBookName.getText();
				BookDao.del(ISBN);
				if(ISBN > 0) {
					JOptionPane.showMessageDialog(DelBook.this,"书籍成功删除！");
					AdminSuccess.main(new String[]{});
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(DelBook.this,"抱歉，删除操作有误。");
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JButton btnBack = new JButton("返回");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		btnBack.setFont(new Font("宋体", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(142)
							.addComponent(lblDelBook))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblISBN, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBookName, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textBookName)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))))))
					.addContainerGap(151, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDelBook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblISBN)
						.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookName)
						.addComponent(textBookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(button)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBack)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}