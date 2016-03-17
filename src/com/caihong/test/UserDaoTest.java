package com.caihong.test;

import java.sql.Connection;

import com.caihong.dao.UserDao;
import com.caihong.dao.impl.UserDapImpl;
import com.caihong.entity.User;
import com.caihong.util.ConnectionFactory;

public class UserDaoTest {
public static void main(String[] args) {
	Connection conn = null;
	try {
		conn = ConnectionFactory.getInstance().getConnection();
		conn.setAutoCommit(false);
		
		UserDao userDao = new UserDapImpl();
		User user = new User();
		user.setName("³Â²Êºç");
		user.setPassword("333");
		user.setEmial("test@dd.com");
		
		userDao.save(conn, user);
		
		conn.commit();
	} catch (Exception e) {
		System.out.println("===²¶»ñµ½Òì³£===");
		try{
			conn.rollback();
		}
		catch(Exception e2){
			e2.printStackTrace();
		}
	}
}
}
