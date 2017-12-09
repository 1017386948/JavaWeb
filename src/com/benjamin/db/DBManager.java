package com.benjamin.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public final class DBManager {
	private static Properties prop = new Properties();
	static {
		InputStream config = null;
		try {
			config = DBManager.class.getClassLoader()
					.getResourceAsStream("config.properties");
			prop.load(config);
			String driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			if (config != null)
				try {
					config.close();
				} catch (Exception e2) {
					e.printStackTrace();
				}
			e.printStackTrace();
		}
	}
	private final static String user = prop.getProperty("username");
	private final static String password = prop.getProperty("password");
	private final static String URL = prop.getProperty("url");
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		// º”‘ÿ≈‰÷√Œƒº˛

		@Override
		protected Connection initialValue() {
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(URL, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}
	};

	public static Connection getConnection() {
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
