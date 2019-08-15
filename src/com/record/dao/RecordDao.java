package com.record.dao;

import java.sql.ResultSet;

import com.model.Record;

public interface RecordDao {
	public boolean insert(Record record);

	public boolean delete(Record record);

	public ResultSet select(Record record);
}
