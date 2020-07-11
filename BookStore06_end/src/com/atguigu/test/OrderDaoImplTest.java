package com.atguigu.test;

import java.util.Date;

import org.junit.jupiter.api.Test;

import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;

class OrderDaoImplTest {

	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao oid = new OrderItemDaoImpl();
	@Test
	void testInsertOrder() {
		orderDao.insertOrder(new Order("test001", new Date(), 2, 300, 0, 1));
		
	}
	
	@Test
	void testInsertOrderItem() {
		oid.insertOrderItem(new OrderItem(null, 1, 150, "testt", "testa", 150, "testt", "test001"));
	}

}
