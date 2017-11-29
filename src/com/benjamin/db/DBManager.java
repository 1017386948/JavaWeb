package com.benjamin.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBManager {
	private static final String URL = "jdbc:mysql://localhost:3306/db_store?useUnicode=true&characterEncoding=UTF-8";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "root";

	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		@Override
		protected Connection initialValue() {
			try {
				return DriverManager.getConnection(URL, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		};
	};

	public static Connection getConnection() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connectionHolder.get();
	}

	public static void close() {
		try {
			if (connectionHolder != null)
				connectionHolder.get().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
