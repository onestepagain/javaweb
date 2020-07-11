package com.atguigu.dao;

import com.atguigu.bean.User;

public interface UserDao {

	/**
	 * 登录
	 * 	sql:select * from users where username=? and password=?
	 */
	User getUser(User user);
	
}
