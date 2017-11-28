package com.benjamin.db;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBManager {
	private static final String URL = "jdbc:mysql://localhost:3306/db_store?useUnicode=true&characterEncoding=UTF-8";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "root";

	private static Connection connection = null;

	static {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void close() {
		try {
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
