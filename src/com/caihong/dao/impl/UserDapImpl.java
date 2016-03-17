package com.caihong.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.caihong.dao.UserDao;
import com.caihong.entity.User;

public class UserDapImpl implements UserDao{
	/**
	 * 保存用户信息
	 */
	@Override
	public void save(Connection conn, User user) throws SQLException {
		String sql = "insert into tbl_user(name,password,email) values(?,?,?)";
		PreparedStatement preStmt = conn
				.prepareCall(sql);
		
		preStmt.setString(1, user.getName());
		preStmt.setString(2, user.getPassword());
		preStmt.setString(3, user.getEmial());
		preStmt.execute();
		System.out.println(sql);
	}
	/**
	 * 根据用户指定的ID更新用户信息
	 */
	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		String sql = "udate tbl_user set name = ? , password = ? , email = ? where id = ?";
		PreparedStatement preStmt = conn.prepareStatement(sql);
		preStmt.setString(1, user.getName());
		preStmt.setString(2, user.getPassword());
		preStmt.setString(3, user.getEmial());
		preStmt.setLong(4, user.getId());
		preStmt.execute();
		System.out.println(sql);
	}
	/**
	 *删除指定的用户信息
	 */
	@Override
	public void delete(Connection conn, User user) throws SQLException {
		PreparedStatement preStmt = conn.prepareStatement("delete from ubl_user where id = ?");
		preStmt.setLong(1, user.getId());
		preStmt.execute();
		
	}

}
