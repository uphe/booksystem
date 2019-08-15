package com.menu0.function;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.book.dao.BookDaoImpl;
import com.model.Book;
import com.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookIdSelect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable idtable;

	/**
	 * Create the frame.
	 */
	public BookIdSelect() {
		setResizable(false);
		setBounds(100, 100, 819, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 26));
		textField.setColumns(15);

		JLabel lblNewLabel = new JLabel("书号");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 26));

		JButton btnNewButton = new JButton("确认查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				Book book = new Book();
				if (StringUtil.isNotEmpty(id)) {
					book.setId(id);
				}
				ResultSet rs = new BookDaoImpl().select(book);
				DefaultTableModel dtm = (DefaultTableModel) idtable.getModel();
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

		JLabel lblNewLabel_1 = new JLabel("按书号查询功能");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 40));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap(25, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addGap(18)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(49))
								.addGroup(
										gl_contentPane.createSequentialGroup().addComponent(btnNewButton).addGap(79))))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_1).addGap(256)))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(35).addComponent(lblNewLabel_1).addGap(68)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
								.addGap(18).addComponent(btnNewButton))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(27, Short.MAX_VALUE)));

		idtable = new JTable();
		idtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66\u540D", "\u4F5C\u8005", "\u7C7B\u522B", "\u51FA\u7248\u793E", "\u662F\u5426\u501F\u51FA"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(idtable);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
