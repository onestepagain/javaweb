package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User getUser(User user) {
		return userDao.getUser(user);
	}

	@Override
	public boolean checkUserName(String username) {
		return userDao.checkUserName(username);
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

}
