package com.caihong.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.caihong.util.ConnectionFactory;

public class ConnectionFactoryTest {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = ConnectionFactory.getInstance();
		
		Connection conn = cf.getConnection();
		
		System.out.println(conn.getAutoCommit());
	}
}
