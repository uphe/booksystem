package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;

public class UserUtil {
	public static User userSelect(User user) {
		Connection con = new DbUtil().getCon();
		String sql = "select * from user where user_id = ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User u = new User();
				u.setId(rs.getString("user_id"));
				u.setName(rs.getString("user_name"));
				u.setPassword(rs.getString("user_password"));
				if(rs.getString("user_type").equals("0")) {
					u.setType(0);
				} else if(rs.getString("user_type").equals("1")) {
					u.setType(1);
				}else {
					u.setType(2);
				}
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
