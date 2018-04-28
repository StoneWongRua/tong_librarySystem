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

import javax.swing.LayoutStyle.ComponentPlacement;


@SuppressWarnings("serial")
public class AddBook extends JFrame {
	static AddBook frame;
	private JPanel contentPane;
	private JTextField textISBN;
	private JTextField textBookName;
	private JTextField textAuthor;
	private JTextField textQuantity;
	private JTextField textIssued;
	private JTextField textPubilsher;
	
	/**
	 * 执行
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddBook();
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
	public AddBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddBooks = new JLabel("添加书籍");
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
				
		JButton btnAddBooks = new JButton("添加书籍");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			int ISBN = Integer.parseInt(textISBN.getText());		
			String name = textBookName.getText();
			String author = textAuthor.getText();
			String book_publisher = textPubilsher.getText();
			int quantity = Integer.parseInt(textQuantity.getText());		
			int issued = Integer.parseInt(textIssued.getText());
			

			int i = BookDao.add(ISBN, name, author,book_publisher,quantity, issued);
			
			if(i > 0){
				
					JOptionPane.showMessageDialog(AddBook.this,"书籍成功添加！");
					AdminSuccess.main(new String[]{});
					frame.dispose();
				
			}else{
				
				JOptionPane.showMessageDialog(AddBook.this,"抱歉，保存出错。");
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
		
		JLabel label = new JLabel("出版社");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		
		textPubilsher = new JTextField();
		textPubilsher.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(151)
							.addComponent(lblAddBooks))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookIssued, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBookAuthor, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(lblBookQuantity, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
								.addComponent(lblBookName, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblISBN))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addGap(61)
									.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textIssued)
										.addComponent(textQuantity, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
									.addGap(239))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(textAuthor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
										.addComponent(textPubilsher)
										.addComponent(textBookName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
										.addComponent(textISBN, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
									.addGap(241)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddBooks)
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblISBN))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textBookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBookName))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBookAuthor))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPubilsher, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBookQuantity))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookIssued)
						.addComponent(textIssued, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBack, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddBooks, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

