package com.benjamin.db;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyTest {
	public static void main(String[] args) {
		InputStream in = null;
		FileReader in2 = null;
		Properties prop = new Properties();
		try {
			in = PropertyTest.class.getClassLoader()
					.getResourceAsStream("config.properties");
			in2 = new FileReader("config/config.properties");
			prop.load(in2);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (in2 != null)
					in2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("driver"));
	}
}
