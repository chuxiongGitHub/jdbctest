package com.caihong.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jsp_db", "root", "admin123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return conn;
	}

	public static void insertUserDatd(Connection conn) throws SQLException {
		String sql = "insert into tbl_user(id,name,password,email)"
				+ "values(10,'rainbow','123','test@.com')";
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		System.out.println("���û����в�����" + count + "����¼");
	}

	public static void insertAddressData(Connection conn) throws SQLException {
		String sql = "insert into tbl_address(id,city,country,user_id)"
				+ "values(1,'kunming','china',10)";
		Statement stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		System.out.println("���ַ���в�����" + count + "����¼");
		conn.close();
	}

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			insertUserDatd(conn);
			insertAddressData(conn);
			
			conn.commit();
		} catch (SQLException e) {
			System.out.println("=======����SQL�쳣=======");
			
			e.printStackTrace();
			
			try {
				conn.rollback();
				System.out.println("=====����ع��ɹ�=====");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		finally{
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}
}
