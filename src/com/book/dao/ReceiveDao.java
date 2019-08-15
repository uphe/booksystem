package com.book.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Book;
import com.model.Record;
import com.model.User;
import com.record.dao.RecordDaoImpl;
import com.util.DbUtil;
/**
 * 该类有一个构造方法，为实现用户的还书操作
 * @author 11852
 *
 */
public class ReceiveDao {
	public boolean receiveDao(User user, Book book) {
		Record record = new Record();
		record.setUserId(user.getId());
		record.setBookId(book.getId());
		new RecordDaoImpl().delete(record);
		book.setLend(0);
		String sql = "select now()";
		Connection con = new DbUtil().getCon();

		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			Date t = null;
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				t = result.getDate(1);
			}
			record.setLendDate(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(new BookDaoImpl().update(book)) {
			return true;
		}
		return false;
	}
}
