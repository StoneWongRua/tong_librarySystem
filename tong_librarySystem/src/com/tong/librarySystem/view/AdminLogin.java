package com.tong.librarySystem.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tong.librarySystem.dao.AdminDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class AdminLogin extends JFrame {
	static AdminLogin frame;
	private JPanel contentPane;
	private JTextField textNo;
	private JPasswordField textPsw;

	/**
	 * 执行
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *创建窗体
	 */
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel JlblLibrarianLoginForm = new JLabel("管理员登录页面");
		JlblLibrarianLoginForm.setForeground(Color.black);
		JlblLibrarianLoginForm.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblEnterName = new JLabel("用户名：");
		
		JLabel lblEnterPassword = new JLabel("密码：");
		
		textNo = new JTextField();
		textNo.setColumns(10);
		
		JButton btnLogin = new JButton("登录");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int admin_no = Integer.parseInt(textNo.getText());
				int admin_psw = Integer.parseInt(textPsw.getText());
				
				if(AdminDao.validate(admin_no, admin_psw)){
					
					AdminSuccess.main(new String[]{});
					frame.dispose();
					
				}
				else{
					
					JOptionPane.showMessageDialog(AdminLogin.this, "用户名或密码输入有误","登录失败！", JOptionPane.ERROR_MESSAGE);
					textNo.setText("");
					textPsw.setText("");
				}
				}
		});
		
		textPsw = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(JlblLibrarianLoginForm))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterName)
								.addComponent(lblEnterPassword))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textPsw)
								.addComponent(textNo, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(JlblLibrarianLoginForm)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterName)
						.addComponent(textNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(textPsw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}