package com.record.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Record;
import com.util.DbUtil;

public class RecordDaoImpl implements RecordDao {

	@Override
	public boolean insert(Record record) {
		String sql = "insert into record values(null,?,?,?,?,null)";
		Connection con = new DbUtil().getCon();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, record.getUserId());
			pstmt.setString(2, record.getBookId());
			pstmt.setString(3, record.getBookName());
			pstmt.setDate(4, record.getLendDate());
			if (pstmt.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Record record) {
		Connection con = new DbUtil().getCon();
		String sql = "delete from record where user_id=? and book_id=?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, record.getUserId());
			pstmt.setString(2, record.getBookId());
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet select(Record record) {
		String sql = "select * from record where user_id=?";
		Connection con = new DbUtil().getCon();
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, record.getUserId());
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
