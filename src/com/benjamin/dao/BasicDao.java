package com.benjamin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.benjamin.db.DBManager;

public class BasicDao {
	protected static Connection connection = DBManager.getConnection();
	protected PreparedStatement prepareStatement = null;
	protected Statement statement = null;
	protected ResultSet resultSet = null;

	protected void closeAll() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (prepareStatement != null)
				prepareStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
