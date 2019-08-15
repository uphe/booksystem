package com.menu.function;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.User;
import com.user.dao.UserDaoImpl;
import com.util.StringUtil;
import com.util.UserUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserDeleteJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public UserDeleteJFrame() {
		setResizable(false);
		setBounds(100, 100, 880, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("用户删除功能");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));

		JLabel lblNewLabel_1 = new JLabel("账号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 26));
		textField.setColumns(15);

		JButton btnNewButton = new JButton("确认删除");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				String id = textField.getText();
				if (StringUtil.isEmpty(id)) {
					JOptionPane.showMessageDialog(null, "账号不能为空");
				} else {
					user.setId(id);
					User u = UserUtil.userSelect(user);
					if(u.getType() == 0) {
						if (new UserDaoImpl().delete(user)) {
							JOptionPane.showMessageDialog(null, "删除成功");
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "该账号不存在");
						}
					}else {
						JOptionPane.showMessageDialog(null, "只能删除普通用户");
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(284).addComponent(lblNewLabel_1).addGap(18)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(297, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(305).addComponent(lblNewLabel)
						.addContainerGap(307, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(378, Short.MAX_VALUE).addComponent(btnNewButton).addGap(337)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(46).addComponent(lblNewLabel).addGap(56)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(29).addComponent(btnNewButton).addContainerGap(218, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
