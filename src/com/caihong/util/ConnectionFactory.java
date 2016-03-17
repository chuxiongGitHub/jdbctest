package com.caihong.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
//成员变量
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private static final  ConnectionFactory factory = new ConnectionFactory();
	
	private Connection conn;
	//读取数据库的配置信息
	static{
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (Exception e) {
			System.out.println("=====配置文件读取错误=====");
		}
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	private ConnectionFactory(){
		
	}
	public static ConnectionFactory getInstance(){
		return factory;
	}
	public Connection getConnection(){
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
