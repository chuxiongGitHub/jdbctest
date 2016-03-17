package com.caihong.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
public static void main(String[] args) {
	String sql="SELECT * FROM tbl_user";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "admin123");
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		System.out.println(sql);
		while(rs.next()){
			System.out.print(rs.getInt("id")+" ");
			System.out.print(rs.getString("name")+" ");
			System.out.print(rs.getString("password")+" ");
			System.out.print(rs.getString("email")+" ");
			System.out.println();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		try {
			rs.close();
		} catch (Exception e2) {
		}
		try {
			stmt.close();
		} catch (Exception e2) {
		}
		try {
			rs.close();
		} catch (Exception e2) {
		
		}
	}
}
}
