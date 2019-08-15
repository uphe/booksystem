package com.book.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.User;
import com.user.dao.RegisterDao;
import com.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private String id;
	private String name;
	private String password;
	private String passwordTwo;

	/**
	 * Create the frame.
	 */
	public RegisterJFrame() {
		setBounds(100, 100, 824, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("请输入账号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 26));

		JLabel lblNewLabel_1 = new JLabel("请输入密码");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));

		JLabel lblNewLabel_2 = new JLabel("请确认密码");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 26));

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 26));
		textField.setColumns(15);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("宋体", Font.PLAIN, 26));
		passwordField.setColumns(15);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("宋体", Font.PLAIN, 26));
		passwordField_1.setColumns(15);

		JLabel lblNewLabel_3 = new JLabel("注册界面");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 45));

		JButton btnNewButton = new JButton("确认注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (new RegisterDao().register(getUser())) {
					dispose();
				}

			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 26));

		JLabel label = new JLabel("请输入姓名");
		label.setFont(new Font("宋体", Font.PLAIN, 26));

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_1.setColumns(15);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(220)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2).addComponent(label).addComponent(lblNewLabel_1))
						.addGap(36)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(305).addComponent(lblNewLabel_3))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(319).addComponent(btnNewButton)))
				.addContainerGap(209, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(53).addComponent(lblNewLabel_3)
				.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
						textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(passwordField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
						.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(33).addComponent(btnNewButton).addGap(89)));
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	private User getUser() {
		id = this.textField.getText();
		name = this.textField_1.getText();
		password = new String(this.passwordField.getPassword());
		passwordTwo = new String(this.passwordField_1.getPassword());
		User user = new User();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "账号不能为空");
		} else if (StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
		} else if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
		} else if (StringUtil.isEmpty(passwordTwo)) {
			JOptionPane.showMessageDialog(null, "确认密码不能为空");
		} else if (!password.equals(passwordTwo)) {
			JOptionPane.showMessageDialog(null, "两次密码不一致");
		} else {
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setType(0);
		}
		return user;
	}
}
