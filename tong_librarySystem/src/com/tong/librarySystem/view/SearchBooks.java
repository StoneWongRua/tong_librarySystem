package com.tong.librarySystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;
import com.tong.librarySystem.util.DbUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class SearchBooks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBooks frame = new SearchBooks();
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
	public SearchBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("书籍查询界面");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 22));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label = new JLabel("书名");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JButton btSearch = new JButton("查询");
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "";
				String name = textField.getText();
				if(e.getSource() == btSearch) {
					sql = "select * from books where name = '" + name + "'";
					try {
						java.sql.Statement stm = DbUtil.getConnection().createStatement();
						ResultSet rs = stm.executeQuery(sql);
						if(rs.next()) {
							String author = rs.getString(4);
							textField_1.setText(author);
							
							String publisher = rs.getString(5);
							textField_2.setText(publisher);
							
							String quantity = rs.getString(6);
							textField_3.setText(quantity);
							
							String issued = rs.getString(7);
							textField_4.setText(issued);
							
						}
						else {
							JOptionPane.showMessageDialog(null,"该书籍不存在！");
						}
					}catch(Exception ee){
						ee.printStackTrace();					
					}
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		label_1 = new JLabel("作者：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		label_2 = new JLabel("出版社：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		lblNewLabel_1 = new JLabel("剩余：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		lblNewLabel_2 = new JLabel("出借：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(169, Short.MAX_VALUE)
					.addComponent(btSearch, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(160))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(30))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addComponent(textField_1)
								.addComponent(textField_2)
								.addComponent(textField_3)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btSearch)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
