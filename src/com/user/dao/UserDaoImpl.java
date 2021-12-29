package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.util.DbUtil;
import com.util.StringUtil;
import com.util.UserUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean delete(User user) {
		if (UserUtil.userSelect(user)!=null) {
			Connection con = new DbUtil().getCon();
			String sql = "delete from user where user_id = ?";
			PreparedStatement pstmt;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getId());
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
	public boolean update(User user) {
		if (UserUtil.userSelect(user)!=null) {
			String sql = "update user set user_id = user_id";
			StringBuffer sb = new StringBuffer(sql);
			if (StringUtil.isNotEmpty(user.getName())) {
				sb.append(",user_name=" + "'"+user.getName()+"'");
			} 
			if (StringUtil.isNotEmpty(user.getPassword())) {
				sb.append(",user_password=" + "'"+user.getPassword()+"'");
			} 
			if (user.getType() != -1) {
				sb.append(",user_type="+"'"+user.getType()+"'");
			}

			sb.append(" where user_id=" + "'"+user.getId()+"'");
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
	public ResultSet select(User user) {
		String sql = "select * from user where user_id=user_id";
		StringBuffer sb = new StringBuffer(sql);
		if (StringUtil.isNotEmpty(user.getId())) {
			sb.append(" and user_id like '%" + user.getId() + "%'");
		}
		if (StringUtil.isNotEmpty(user.getName())) {
			sb.append(" and user_name like '%" + user.getName() + "%'");
		} 
		if (user.getType() != -1) {
			sb.append(" and user_type like '%" + user.getType() + "%'");
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
