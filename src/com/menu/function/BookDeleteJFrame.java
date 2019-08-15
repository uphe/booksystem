package com.menu.function;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.book.dao.BookDaoImpl;
import com.model.Book;
import com.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookDeleteJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public BookDeleteJFrame() {
		setResizable(false);
		setBounds(100, 100, 902, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = new JLabel("图书删除功能");
		label.setFont(new Font("宋体", Font.PLAIN, 40));

		JLabel lblNewLabel = new JLabel("书号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 26));

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 26));
		textField.setColumns(15);

		JButton btnNewButton = new JButton("确认删除");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();
				String id = textField.getText();
				if (StringUtil.isEmpty(id)) {
					JOptionPane.showMessageDialog(null, "请输入书号");
				} else {
					book.setId(id);
					if (new BookDaoImpl().delete(book)) {
						JOptionPane.showMessageDialog(null, "删除成功");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "该书号不存在");
					}
				}

			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 26));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(309)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(label)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(306, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(392, Short.MAX_VALUE)
						.addComponent(btnNewButton).addGap(345)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(55).addComponent(label).addGap(31)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(35).addComponent(btnNewButton).addContainerGap(223, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

}
