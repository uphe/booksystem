package com.book.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.menu0.function.BookAuthorSelect;
import com.menu0.function.BookIdSelect;
import com.menu0.function.BookNameSelect;
import com.menu0.function.BookPressSelect;
import com.menu0.function.BookTypeSelect;
import com.menu0.function.LendJFrame;
import com.menu0.function.NotReceiveSelect;
import com.menu0.function.ReceiveJFrame;
import com.model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu0 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Menu0(User user) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("图书查询功能");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));

		JButton btnNewButton = new JButton("按书名查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookNameSelect();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_1 = new JButton("按作者查询");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookAuthorSelect();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_2 = new JButton("出版社查询");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookPressSelect();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_3 = new JButton("按书号查询");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookIdSelect();
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 26));

		JLabel lblNewLabel_1 = new JLabel("借还书功能");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 40));

		JButton btnNewButton_4 = new JButton("借书功能");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LendJFrame(user);
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_5 = new JButton("还书功能");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReceiveJFrame(user);
			}
		});
		btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton_6 = new JButton("未还图书");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NotReceiveSelect(user);
			}
		});
		btnNewButton_6.setFont(new Font("宋体", Font.PLAIN, 26));
		
		JButton btnNewButton_7 = new JButton("按类别查询");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BookTypeSelect();
			}
		});
		btnNewButton_7.setFont(new Font("宋体", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(111)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_3)
								.addComponent(btnNewButton)
								.addComponent(btnNewButton_7)
								.addComponent(btnNewButton_2)
								.addComponent(btnNewButton_1))))
					.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_4)
								.addComponent(btnNewButton_5)
								.addComponent(btnNewButton_6))
							.addGap(32)))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(btnNewButton_5)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnNewButton_7)
							.addGap(18)
							.addComponent(btnNewButton_2)
							.addGap(83))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addComponent(btnNewButton_6)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

}
