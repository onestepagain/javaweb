package com.atguigu.dao;

import com.atguigu.bean.Order;

public interface OrderDao {

	/**
	 * 添加Order
	 * sql:
	 * @param order
	 */
	void insertOrder(Order order);
	
	
	
}
