package com.book.dao;

import java.sql.ResultSet;

import com.model.Book;

public interface BookDao {

	public boolean insert(Book student);

	public boolean delete(Book student);

	public boolean update(Book student);

	public ResultSet select(Book student);
}
