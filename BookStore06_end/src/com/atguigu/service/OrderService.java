package com.atguigu.service;

import com.atguigu.bean.Cart;
import com.atguigu.bean.User;

public interface OrderService {

	/**
	 * 去结账createOrder
	 * 		1. 生成订单
	 * 		2. 生成订单详情
	 * 		3. 更改相应book的库存和销量
	 * 		4. 清空购物车
	 */
	public String createOrder(Cart cart,User user);
	
	
	
}
