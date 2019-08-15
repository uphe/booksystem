package com.book.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.menu.function.BookDeleteJFrame;
import com.menu.function.BookInsertJFrame;
import com.menu.function.BookSelectJFrame;
import com.menu.function.BookUpdateJFrame;
import com.menu.function.UserDeleteJFrame;
import com.menu.function.UserSelectJFrame;
import com.menu.function.UserUpdateJFrame1;
import com.menu.function.UserUpdateJFrame2;
import com.model.User;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Menu(User user) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("图书管理");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));

		JButton btnNewButton = new JButton("增加图书");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookInsertJFrame();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_1 = new JButton("删除图书");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookDeleteJFrame();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_2 = new JButton("修改图书");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookUpdateJFrame();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_3 = new JButton("查询图书");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookSelectJFrame();
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 26));

		JLabel lblNewLabel_1 = new JLabel("用户管理");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 40));

		JButton btnNewButton_5 = new JButton("删除用户");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserDeleteJFrame();
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_6 = new JButton("修改用户");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getType() == 1) {
					new UserUpdateJFrame1();
				}else {
					new UserUpdateJFrame2();
				}
				
			}
		});
		btnNewButton_6.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_7 = new JButton("查询用户");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserSelectJFrame();
			}
		});
		btnNewButton_7.setFont(new Font("宋体", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(90).addComponent(lblNewLabel))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(103)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnNewButton).addComponent(btnNewButton_3)
												.addComponent(btnNewButton_2).addComponent(btnNewButton_1))))
						.addPreferredGap(ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING,
										gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1).addGap(258))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnNewButton_6).addComponent(btnNewButton_5)
												.addComponent(btnNewButton_7))
										.addContainerGap()))));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(47)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel).addComponent(lblNewLabel_1))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton).addComponent(btnNewButton_5))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane
										.createParallelGroup(Alignment.BASELINE).addComponent(btnNewButton_1)
										.addComponent(btnNewButton_6))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnNewButton_2)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btnNewButton_3))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(16)
												.addComponent(btnNewButton_7)))
								.addContainerGap(187, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

}
