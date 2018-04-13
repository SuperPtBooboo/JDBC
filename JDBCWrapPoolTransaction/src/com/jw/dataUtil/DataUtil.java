package com.jw.dataUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


public class DataUtil {
	//建立数据库连接池
	private static BasicDataSource ds;
	private static String driver;
	private static String url;
	private static String usename;
	private static String password;
	private static String initialSize;
	private static String maxIdle;
	private static String minIdle;
	private static String maxActive;
	private static String maxWait;
	
	static{
		Properties pt = new Properties();
		InputStream in = DataUtil.class.getClassLoader().getResourceAsStream("com/jw/dataUtil/db.properties");
		ds = new BasicDataSource();
		try {
			pt.load(in);
			driver=pt.getProperty("driver");
			url=pt.getProperty("url");
			usename=pt.getProperty("usename");
			password=pt.getProperty("password");
			initialSize=pt.getProperty("initialSize");
			maxIdle=pt.getProperty("maxIdle");
			minIdle=pt.getProperty("minIdle");
			maxActive=pt.getProperty("maxActive");
			maxWait=pt.getProperty("maxWait");
			
			//配置连接池参数
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(usename);
			ds.setPassword(password);
			ds.setInitialSize(Integer.parseInt(initialSize));
			ds.setMaxIdle(Integer.parseInt(maxIdle));
			ds.setMinIdle(Integer.parseInt(minIdle));
			ds.setMaxActive(Integer.parseInt(maxActive));
			ds.setMaxWait(Long.parseLong(maxWait));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeCon(Connection con,PreparedStatement ps,ResultSet rs){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
