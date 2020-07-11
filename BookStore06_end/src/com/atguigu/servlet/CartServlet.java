package com.atguigu.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private BookService bookService = new BookServiceImpl();
	
	/**
	 * 添加Book到Cart
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unlikely-arg-type")
	protected void addBookToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//取bookId值
		String bookId = request.getParameter("bookId");
		//通过bookId获取Book(BookService)
		Book book = bookService.getBookById(bookId);
		//调用Cart中的addBookToCart()
		//Cart存放Session域中
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			//存放到Session域中
			session.setAttribute("cart", cart);
		}
		cart.addBookToCart(book);
		//验证库存问题
		Integer stock = book.getStock();//获取库存
		int count = cart.getMap().get(book.getId()+"").getCount();
		if(count > stock) {
			//库存不足
			session.setAttribute("msg", "库存不足，只剩"+stock+"件商品!");
			//将购买商品的数量，设置为最大库存。
			cart.getMap().get(book.getId()+"").setCount(stock);
		}else {
			//将titile存放到session域中
			session.setAttribute("title", book.getTitle());
		}
		//获取Referer:跳转 
		String url = request.getHeader("Referer");
		//跳转
		response.sendRedirect(url);
	}

	/**
	 * 删除购物项
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//取bookid值
		String bookId = request.getParameter("bookId");
		//调用Cart
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null) {
			cart.delCartItem(bookId);
		}
		//跳转
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}
	
	/**
	 * 清空购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void emptyCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null) {
			cart.emptyCart();
		}
		//跳转（1.首页，2.购物车）
//		response.sendRedirect(request.getContextPath()+"/index.jsp");
		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
	}
	
	/**
	 * 清空购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateCartItemCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//取bookId,count值
		String bookId = request.getParameter("bookId");
		String count = request.getParameter("count");
		//调用Cart
		Cart cart = (Cart)session.getAttribute("cart");
		if(cart != null) {
			cart.updateCartItemCount(bookId, count);
		}
		//跳转
//		response.sendRedirect(request.getContextPath()+"/pages/cart/cart.jsp");
		//携带数据响应（回调函数）
		//获取3个数据
		int totalCount = cart.getTotalCount();
		double totalAmount = cart.getTotalAmount();
		double amount = cart.getMap().get(bookId).getAmount();
		Map<String,Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("totalAmount", totalAmount);
		map.put("amount", amount);
		//将数据封装为jsonString（Gson）
		Gson gson = new Gson();
		String jsonStr = gson.toJson(map);
		//响应
		response.getWriter().write(jsonStr);
	}
	
}
