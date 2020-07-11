package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUser(User user) {
		String sql = "SELECT id,username,`password`,email FROM users WHERE username = ? AND `password` = ?";
		return this.getBean(sql, user.getUsername(),user.getPassword());
	}

}
