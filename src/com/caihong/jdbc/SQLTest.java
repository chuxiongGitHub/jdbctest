package com.caihong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTest {
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "admin123");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void insert(){
		Connection conn = getConnection();
		try {
			String sql = "insert into tbl_user(name,password,email)"+
						 "values('Tome','123456','dsdfs@.com')";
			Statement stmt = conn.createStatement();
			int count = stmt.executeUpdate(sql);
			System.out.println("���û����в�����"+count+"������");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void update(){
		Connection conn=getConnection();
		try {
			String sql="update  tbl_user set email = 'test' where name = 'Tome'";
			Statement stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			System.out.println("������"+count+"����¼");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//ɾ��ɾ�����е�����
	public static void delete(){
		Connection conn=getConnection();
		try {
			String sql="delete from tbl_user where name = 'Tome'";
			Statement stmt=conn.createStatement();
			int count=stmt.executeUpdate(sql);
			System.out.println("ɾ����"+count+"����¼");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public static void main(String[] args) {
	//insert();
	//update();
	delete();
}
}
