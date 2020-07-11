package com.atguigu.dao.impl;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	@Override
	public void insertOrderItem(OrderItem orderItem) {
		String sql = "INSERT INTO order_item(`count`,amount,title,author,price,img_path,order_id) VALUES(?,?,?,?,?,?,?)";
		this.update(sql, orderItem.getCount(),orderItem.getAmount(),orderItem.getTitle(),orderItem.getAuthor(),orderItem.getPrice(),orderItem.getImgPath(),orderItem.getOrderId());
	}

	/**
	 * 1. BaseDao:添加batchUpdate()
	 * 		* queryRunner.batch(connection, sql, params);
	 * 		* params:Object[][]
	 * 			* 一维：次数
	 * 			* 二维：参数
	 * 2. OrderItemDao添加批处理接口
	 * 3. BookDao添加批处理接口
	 * 4. OrderServiceImpl调用dao批处理接口
	 * 		* Object[][] orderItemParams = new Object[cartItems.size()][];
			  Object[][] bookParams = new Object[cartItems.size()][];
			* orderItemParams[i] = new Object[]{参数的顺序};
	 * 		
	 */
	@Override
	public void insertOrderItem(Object[][] params) {
		String sql = "INSERT INTO order_item(`count`,amount,title,author,price,img_path,order_id) VALUES(?,?,?,?,?,?,?)";
		this.batchUpdate(sql, params);
	}

}
