package com.atguigu.dao;

import com.atguigu.bean.OrderItem;

public interface OrderItemDao {

	/**
	 * 添加orderItem
	 * @param orderItem
	 */
	void insertOrderItem(OrderItem orderItem);
	void insertOrderItem(Object[][] params);
	
}
