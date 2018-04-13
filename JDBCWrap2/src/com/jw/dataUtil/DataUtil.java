package com.jw.dataUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataUtil {
	private static String driver;
	private static String url;
	private static String usename;
	private static String password;
	
	static{
		Properties pt = new Properties();
		InputStream in = DataUtil.class.getClassLoader().getResourceAsStream("com/jw/dataUtil/db.properties");
		try {
			pt.load(in);
			driver=pt.getProperty("driver");
			url=pt.getProperty("url");
			usename=pt.getProperty("usename");
			password=pt.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return DriverManager.getConnection(url,usename,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
