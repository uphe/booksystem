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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class BookSelectJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable booktable;

	/**
	 * Create the frame.
	 */
	public BookSelectJFrame() {
		setResizable(false);
		setBounds(100, 100, 902, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("图书查询功能");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 40));

		JLabel lblNewLabel_1 = new JLabel("书号");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 26));

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 26));
		textField.setColumns(15);

		JLabel lblNewLabel_2 = new JLabel("书名");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 26));

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_1.setColumns(15);

		JLabel lblNewLabel_3 = new JLabel("作者");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 26));

		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_2.setColumns(15);

		JLabel lblNewLabel_4 = new JLabel("出版社");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 26));

		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_3.setColumns(15);

		JLabel lblNewLabel_5 = new JLabel("类别");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 26));

		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 26));
		textField_4.setColumns(15);

		JButton btnNewButton = new JButton("确认查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String name = textField_1.getText();
				String author = textField_2.getText();
				String type = textField_3.getText();
				String press = textField_4.getText();
				Book book = new Book();
				if (StringUtil.isNotEmpty(id)) {
					book.setId(id);
				}
				if (StringUtil.isNotEmpty(name)) {
					book.setName(name);
				} 
				if (StringUtil.isNotEmpty(author)) {
					book.setAuthor(author);
				} 
				if (StringUtil.isNotEmpty(type)) {
					book.setType(type);
				} 
				if (StringUtil.isNotEmpty(press)) {
					book.setPress(press);
				}
				ResultSet rs = new BookDaoImpl().select(book);
				DefaultTableModel dtm = (DefaultTableModel) booktable.getModel();
				dtm.setRowCount(0);
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<String>();
						v.add(rs.getString("book_id"));
						v.add(rs.getString("book_name"));
						v.add(rs.getString("book_author"));
						v.add(rs.getString("book_type"));
						v.add(rs.getString("book_press"));
						if (rs.getInt("book_lend") == 0) {
							v.add("否");
						} else {
							v.add("是");
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(74))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 510, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_5)
										.addComponent(lblNewLabel_1))
									.addGap(44))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addGap(30)))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(btnNewButton)))
					.addGap(79))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)))
					.addGap(40))
		);

		booktable = new JTable();
		booktable.setFont(new Font("宋体", Font.PLAIN, 15));
		booktable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u4E66\u53F7", "\u4E66\u540D",
				"\u4F5C\u8005", "\u7C7B\u522B", "\u51FA\u7248\u793E", "\u662F\u5426\u501F\u51FA" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { true, true, true, true, true, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(booktable);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
