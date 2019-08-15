package com.menu0.function;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Record;
import com.model.User;
import com.record.dao.RecordDaoImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NotReceiveSelect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable recordtable;

	/**
	 * Create the frame.
	 */
	public NotReceiveSelect(User user) {
		setResizable(false);
		setBounds(100, 100, 880, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(139)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(190, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(23)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(34, Short.MAX_VALUE)));

		recordtable = new JTable();
		recordtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8D26\u53F7", "\u4E66\u53F7", "\u4E66\u540D", "\u501F\u4E66\u65F6\u95F4"
			}
		));
		scrollPane.setViewportView(recordtable);
		contentPane.setLayout(gl_contentPane);

		Record record = new Record();
		record.setUserId(user.getId());

		ResultSet rs = new RecordDaoImpl().select(record);

		DefaultTableModel dtm = (DefaultTableModel) recordtable.getModel();
		dtm.setRowCount(0);
		try {
			while (rs.next()) {
				Vector<Object> v = new Vector<Object>();
				v.add(rs.getString("user_id"));
				v.add(rs.getString("book_id"));
				v.add(rs.getString("book_name"));
				v.add(rs.getDate("lend_date"));
				v.add(rs.getDate("receive_date"));
				dtm.addRow(v);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		setVisible(true);
	}
}
