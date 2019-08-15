package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.book.view.LoginJFrame;
import com.model.User;
import com.util.DbUtil;

public class RegisterDao {

	public boolean register(User user) {

		String sql = "SELECT * FROM user WHERE user_id = ?";
		DbUtil du = new DbUtil();
		Connection con = du.getCon();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "账号已存在");
				return false;
			}
			String sql1 = "insert into user values(?,?,?,?)";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, user.getId());
			pstmt1.setString(2, user.getName());
			pstmt1.setString(3, user.getPassword());
			pstmt1.setInt(4, user.getType());
			if (pstmt1.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "注册成功");
				du.closeCon(con);
				new LoginJFrame();
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "注册失败");
				return false;
			}
		} catch (SQLException e) {
			du.closeCon(con);
		}
		return false;
	}
}
