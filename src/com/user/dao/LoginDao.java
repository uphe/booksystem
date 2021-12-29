package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.book.view.Menu0;
import com.book.view.Menu;
import com.model.User;
import com.util.DbUtil;

public class LoginDao{
	/**
	 * 
	 */

	public boolean login(User user) {
		String sql = "select * from user where user_id = ? and user_password = ?";
		DbUtil du = new DbUtil();
		Connection con = du.getCon();
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				du.closeCon(con);
				if (user.getType() == 0) {
					new Menu0(user);
				} else {
					new Menu(user);
				}
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "账号或密码错误");
				return false;
			}
		} catch (SQLException e) {
			du.closeCon(con);
		}
		return false;
	}
}
