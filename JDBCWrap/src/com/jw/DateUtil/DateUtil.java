package com.jw.DateUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DateUtil {
	private static String driver;
	private static String url;
	private static String usename;
	private static String password;

	static{
		//创建properties对象,读取properties文件的键值对
		Properties pt = new Properties();
		//在本类加载的时候建立指定的输入流
		InputStream is = DateUtil.class.getClassLoader().getResourceAsStream("com/jw/DateUtil/db.properties");
		try {
			pt.load(is);
			driver=pt.getProperty("driver");
			url=pt.getProperty("url");
			usename=pt.getProperty("usename");
			password=pt.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection conn() throws SQLException{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(url,usename,password);
	}
	
}
