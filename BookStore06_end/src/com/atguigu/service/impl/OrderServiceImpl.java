package com.atguigu.service.impl;

import java.util.Date;
import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.service.OrderService;
import com.atguigu.util.JDBCUtils;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	/**
	 * * 去结账createOrder
	 * 		1. 生成订单
	 * 		2. 生成订单详情
	 * 		3. 更改相应book的库存和销量
	 * 		4. 清空购物车
	 * 
	 * * 批处理优化结账
	 * 		 * 1. BaseDao:添加batchUpdate()
	 * 			* queryRunner.batch(connection, sql, params);
	 * 			* params:Object[][]
	 * 			* 一维：次数
	 * 			* 二维：参数
			 * 2. OrderItemDao添加批处理接口
			 * 3. BookDao添加批处理接口
			 * 4. OrderServiceImpl调用dao批处理接口
			 * 		* Object[][] orderItemParams = new Object[cartItems.size()][];
					  Object[][] bookParams = new Object[cartItems.size()][];
					* orderItemParams[i] = new Object[]{参数的顺序};
	    * 使用事务优化结账
		 	* 开启事务：connection.setAutoCommit(false);|commit() rollback()
		 		1. 共用同一个connetion
		 			* ThreadLocal管理Connection
		 			* 删除BaseDao中的JDBCUtils.releaseConnection(connection);
		 		2. 统一处理异常（Filter）
		 			* 抛出BaseDao和BaseServlet中的异常，统一在Filter中处理
		 			* 统一开启事务，提交|回滚事务。
		
	 */
	@Override
	public String createOrder(Cart cart, User user) {
		//1. 生成订单
		//orderId=时间戳+userid
		String orderId = System.currentTimeMillis()+""+user.getId();		//null.
		orderDao.insertOrder(new Order(orderId, new Date(), cart.getTotalCount(),
				cart.getTotalAmount(), 0, user.getId()));
		
		//获取所有购物项
		List<CartItem> cartItems = cart.getCartItems();
		//OrderItem的二维参数
		Object[][] orderItemParams = new Object[cartItems.size()][];
		Object[][] bookParams = new Object[cartItems.size()][];
		
		//遍历购物项，添加到订单详情
		for (int i=0;i<cartItems.size();i++) {
			//2. 生成订单详情
			CartItem cartItem = cartItems.get(i);
			Book book = cartItem.getBook();
			int count = cartItem.getCount();
//			orderItemDao.insertOrderItem(new OrderItem(null, count,
//					cartItem.getAmount(), book.getTitle(), book.getAuthor(),
//					book.getPrice(), book.getImgPath(), orderId));
			//orderItemParams第二维赋值
			//`count`,amount,title,author,price,img_path,order_id
			orderItemParams[i] = new Object[] {count,
					cartItem.getAmount(), book.getTitle(), book.getAuthor(),
					book.getPrice(), book.getImgPath(), orderId};
			//3. 更改相应book的库存和销量
			int stock = book.getStock()-count;	//计算最终的库存
			int sales = book.getSales()+count;  //计算最终的销量
			//sales=?,stock=? where id=?
			bookParams[i] = new Object[] {sales,stock,book.getId()};
//			bookDao.updateBook(stock, sales, book.getId());
		}
		
		orderItemDao.insertOrderItem(orderItemParams);
		bookDao.updateBook(bookParams);
		
		//4. 清空购物车
		cart.emptyCart();
		return orderId;
	}

}
