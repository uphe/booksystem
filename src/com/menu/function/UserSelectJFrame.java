package com.menu.function;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.User;
import com.user.dao.UserDaoImpl;
import com.util.StringUtil;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class UserSelectJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable usertable;

	/**
	 * Create the frame.
	 */
	public UserSelectJFrame() {
		setResizable(false);
		setBounds(100, 100, 891, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("用户查询功能");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));

		JLabel lblNewLabel_1 = new JLabel("账号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 26));
		textField.setColumns(15);

		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 26));

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_1.setColumns(15);

		JLabel lblNewLabel_3 = new JLabel("权限");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 26));

		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_2.setColumns(15);

		JButton btnNewButton = new JButton("确认查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String name = textField_1.getText();
				String type = textField_2.getText();
				int flag = -1;

				if (StringUtil.isNotEmpty(type)) {
					if (type.equals("0")) {
						flag = 0;
					} else if (type.equals("1")) {
						flag = 1;
					} else if (type.equals("2")) {
						flag = 2;
					} else {
						JOptionPane.showMessageDialog(null, "权限只能为0、1或2");
					}
				}
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setType(flag);
				ResultSet rs = new UserDaoImpl().select(user);
				DefaultTableModel dtm = (DefaultTableModel) usertable.getModel();
				dtm.setRowCount(0);
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<String>();
						v.add(rs.getString("user_id"));
						v.add(rs.getString("user_name"));
						if (rs.getInt("user_type") == 0) {
							v.add("普通用户");
						} else if(rs.getInt("user_type") == 1){
							v.add("管理员");
						}else if(rs.getInt("user_type") == 2){
							v.add("超级管理员");
						}
						dtm.addRow(v);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 26));

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));

		JLabel lblNewLabel_5 = new JLabel("说明：权限只能为0普通用户，1管理员，2超级管理员");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false).addGroup(gl_contentPane
						.createSequentialGroup().addGap(65)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2).addComponent(lblNewLabel_1))
						.addGap(33)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(49))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnNewButton).addGap(86))))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(294).addComponent(lblNewLabel)
						.addContainerGap(350, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(221, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4).addGap(193))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(213, Short.MAX_VALUE).addComponent(lblNewLabel_5).addGap(180)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(71)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_3)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(36).addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)))
				.addGap(327)));

		usertable = new JTable();
		usertable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u8D26\u53F7", "\u59D3\u540D", "\u7C7B\u522B" }) {
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(usertable);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
