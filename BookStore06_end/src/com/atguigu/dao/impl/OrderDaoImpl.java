package com.atguigu.dao.impl;

import com.atguigu.bean.Order;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public void insertOrder(Order order) {
		String sql = "INSERT INTO orders(id,order_time,total_count,total_amount,state,user_id) VALUES(?,?,?,?,?,?)";
		this.update(sql, order.getId(),order.getOrderTime(),order.getTotalCount(),order.getTotalAmount(),order.getState(),order.getUserId());
	}

}
