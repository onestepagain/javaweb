package com.atguigu.service;

import com.atguigu.bean.User;

public interface UserService {

	/**
	 * 登录
	 */
	User getUser(User user);
	
	/**
	 * 检查用户名是否存在
	 * 		true:用户名存在
	 * 		false:用户名不存在
	 */
	boolean checkUserName(String username);
	
	/**
	 * 将user信息保存到数据库
	 * @param user
	 */
	void saveUser(User user);
	
}
