package com.caihong.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
//��Ա����
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private static final  ConnectionFactory factory = new ConnectionFactory();
	
	private Connection conn;
	//��ȡ���ݿ��������Ϣ
	static{
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (Exception e) {
			System.out.println("=====�����ļ���ȡ����=====");
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
