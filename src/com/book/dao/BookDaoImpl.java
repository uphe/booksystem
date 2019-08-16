package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.xml.bind.SchemaOutputResolver;

import com.model.Book;
import com.util.DbUtil;
import com.util.StringUtil;
import com.util.BookUtil;

public class BookDaoImpl implements BookDao {

	@Override
	public boolean insert(Book book) {
		if (!BookUtil.bookSelect(book)) {
			Connection con = new DbUtil().getCon();
			String sql = "insert into book values(?,?,?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, book.getId());
				pstmt.setString(2, book.getName());
				pstmt.setString(3, book.getAuthor());
				pstmt.setString(4, book.getPress());
				pstmt.setString(5, book.getType());
				pstmt.setInt(6, book.getLend());
				if (pstmt.executeUpdate() > 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "该书号已存在");
		}
		return false;
	}

	@Override
	public boolean delete(Book book) {
		if (BookUtil.bookSelect(book)) {
			Connection con = new DbUtil().getCon();
			String sql = "delete from book where book_id = ?";
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, book.getId());
				if (pstmt.executeUpdate() > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean update(Book book) {

		if (BookUtil.bookSelect(book)) {
			String sql = "update book set book_id = book_id";
			StringBuffer sb = new StringBuffer(sql);
			if (StringUtil.isNotEmpty(book.getName())) {
				sb.append(",book_name=" + "'"+book.getName()+"'");
			}
			if (StringUtil.isNotEmpty(book.getAuthor())) {
				sb.append(",book_author=" + "'"+book.getAuthor()+"'");
			}
			if (StringUtil.isNotEmpty(book.getType())) {
				sb.append(",book_type=" + "'"+book.getType()+"'");
			}
			if (StringUtil.isNotEmpty(book.getPress())) {
				sb.append(",book_press=" + "'"+book.getPress()+"'");
			}
			if(book.getLend() == 0) {
				sb.append(",book_lend=0");
			}else if(book.getLend() == 1) {
				sb.append(",book_lend=1");
			}
			sb.append(" where book_id=" + book.getId());
			Connection con = new DbUtil().getCon();
			PreparedStatement pstmt;
			try {
				pstmt = (PreparedStatement) con.prepareStatement(sb.toString());
				if (pstmt.executeUpdate() > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return false;
		}
		return false;
	}

	@Override
	public ResultSet select(Book book) {
		String sql = "select * from book where book_id=book_id";
		StringBuffer sb = new StringBuffer(sql);
		if (StringUtil.isNotEmpty(book.getId())) {
			sb.append(" and book_id like '%" + book.getId() + "%'");
		} else if (StringUtil.isNotEmpty(book.getName())) {
			sb.append(" and book_name like '%" + book.getName() + "%'");
		} else if (StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and book_author like '%" + book.getAuthor() + "%'");
		} else if (StringUtil.isNotEmpty(book.getType())) {
			sb.append(" and book_type like '%" + book.getType() + "%'");
		} else if (StringUtil.isNotEmpty(book.getPress())) {
			sb.append(" and book_press like '%" + book.getPress() + "%'");
		}
		Connection con = new DbUtil().getCon();
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sb.toString());
			ResultSet rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
