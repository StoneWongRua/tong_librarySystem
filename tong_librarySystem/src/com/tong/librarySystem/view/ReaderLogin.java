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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.tong.librarySystem.dao.AdminDao;
import com.tong.librarySystem.dao.ReaderDao;

@SuppressWarnings("serial")
public class ReaderLogin extends JFrame {
	static ReaderLogin frame;
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
					
					frame = new ReaderLogin();
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
	public ReaderLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblReaderLogin = new JLabel("读者登录界面");
		lblReaderLogin.setForeground(Color.BLACK);
		lblReaderLogin.setFont(new Font("宋体", Font.BOLD, 18));
		
		JLabel lblEnterName = new JLabel("用户名：");
		
		JLabel lblEnterPassword = new JLabel("密码：");
		
		textNo = new JTextField();
		textNo.setColumns(10);
		
		JButton btnLogin = new JButton("登录");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int reader_no = Integer.parseInt(textNo.getText());
				int reader_psw = Integer.parseInt(textPsw.getText());
				
				if(ReaderDao.checkId(reader_no)) {
					boolean i = ReaderDao.validate(reader_no, reader_psw);
				
				if(i){
					
					ReaderSuccess.main(new String[]{});
					frame.dispose();
					
				}
				else{
					
					JOptionPane.showMessageDialog(ReaderLogin.this, "密码输入错误！","登录失败！", JOptionPane.ERROR_MESSAGE);
					//textNo.setText("");
					//textPsw.setText("");
				}
				}else {
					//frame.dispose();
					int result = JOptionPane.showConfirmDialog(null, "该用户不存在，是否注册？", "标题",JOptionPane.YES_NO_OPTION);
					if(result == 1) {
						int sign = ReaderDao.sign(reader_no, reader_psw);
						if(sign > 0) {
							JOptionPane.showMessageDialog(ReaderLogin.this,"成功注册！");
						}
						
					}
					int done = JOptionPane.showConfirmDialog(null, "注册成功，是否立即登录？", "标题",JOptionPane.YES_NO_OPTION);
					if(done == 1) {
						ReaderLogin.main(new String[]{});
						boolean i = ReaderDao.validate(reader_no, reader_psw);
						
						if(i){
							
							ReaderSuccess.main(new String[]{});
							frame.dispose();
							
						}
						
					}
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
							.addComponent(lblReaderLogin))
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
					.addComponent(lblReaderLogin)
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
