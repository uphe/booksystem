package com.user.dao;

import java.sql.ResultSet;

import com.model.User;

public interface UserDao {
	public boolean delete(User user);

	public boolean update(User user);

	public ResultSet select(User user);
}
