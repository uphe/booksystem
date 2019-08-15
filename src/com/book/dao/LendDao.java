package com.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.model.Book;
import com.model.Record;
import com.model.User;
import com.record.dao.RecordDaoImpl;
import com.util.DbUtil;

/**
 * 该类有一个构造方法，为实现用户的借书操作
 * 
 * @author 11852
 *
 */
public class LendDao {
	public boolean lendDao(User user, Book book) {
			
	
		ResultSet rs = new BookDaoImpl().select(book);
		try {
			if(rs.next()) {
				if(rs.getInt("book_lend") == 0) {
					book.setId(rs.getString("book_id"));
					book.setName(rs.getString("book_name"));
					book.setLend(1);
					new BookDaoImpl().update(book);
					
					Record record = new Record();
					record.setUserId(user.getId());
					record.setBookId(book.getId());
					record.setBookName(book.getName());

					String sql = "select now()";
					Connection con = new DbUtil().getCon();

					PreparedStatement pstmt = con.prepareStatement(sql);
					Date t = null;
					ResultSet result = pstmt.executeQuery();
					while (result.next()) {
						t = result.getDate(1);
					}
					record.setLendDate(t);
					if (new RecordDaoImpl().insert(record)) {
						new BookDaoImpl().update(book);
						return true;
					}
				}else {
					JOptionPane.showMessageDialog(null, "该书不存在");
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
}