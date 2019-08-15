package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.model.Book;

public class BookUtil {
	public static boolean bookSelect(Book book) {
		Connection con = new DbUtil().getCon();
		String sql = "select * from book where book_id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getId());
			if (pstmt.executeQuery().next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
