package com.menu.function;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.User;
import com.user.dao.UserDaoImpl;
import com.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserUpdateJFrame2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public UserUpdateJFrame2() {
		setResizable(false);
		setBounds(100, 100, 901, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("用户修改功能");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));

		JLabel lblNewLabel_1 = new JLabel("说明：修改权限时0是普通用户，1为管理员。2是超级管理员不能别修改");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel label = new JLabel("账号");
		label.setFont(new Font("宋体", Font.PLAIN, 26));

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 26));
		textField.setColumns(15);

		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 26));

		passwordField = new JPasswordField();
		passwordField.setColumns(15);
		passwordField.setFont(new Font("宋体", Font.PLAIN, 26));

		JLabel lblNewLabel_3 = new JLabel("姓名");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 26));

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_1.setColumns(15);

		JLabel lblNewLabel_4 = new JLabel("权限");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 26));

		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_2.setColumns(15);

		JButton btnNewButton = new JButton("确认修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String password = new String(passwordField.getPassword());
				String name = textField_1.getText();
				String type = textField_2.getText();
				int flag = -1;
				if (StringUtil.isEmpty(id)) {
					JOptionPane.showMessageDialog(null, "账号不能为空");
				} else if (StringUtil.isNotEmpty(type)) {
					if (type.equals("0")) {
						flag = 0;
					} else if (type.equals("1")) {
						flag = 1;
					} else {
						JOptionPane.showMessageDialog(null, "权限只能为0或1");
					}
				}
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setPassword(password);
				user.setType(flag);
				if (new UserDaoImpl().update(user)) {
					JOptionPane.showMessageDialog(null, "修改成功");
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "该用户不存在");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(304).addComponent(lblNewLabel))
								.addGroup(
										gl_contentPane.createSequentialGroup().addGap(133).addComponent(lblNewLabel_1))
								.addGroup(
										gl_contentPane.createSequentialGroup().addGap(313)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
														.addComponent(label).addComponent(lblNewLabel_2)
														.addComponent(lblNewLabel_3).addComponent(lblNewLabel_4))
												.addGap(41)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(textField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(110, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(455, Short.MAX_VALUE).addComponent(btnNewButton).addGap(305)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(43).addComponent(lblNewLabel).addGap(18).addComponent(lblNewLabel_1)
				.addGap(52)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2).addComponent(passwordField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
				.addGap(18).addComponent(btnNewButton).addContainerGap(26, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
