package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

/**
 * BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private BookService bookService = new BookServiceImpl();
	
	/**
	 * 客户端分页查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBooksByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值
		String pageNo = request.getParameter("pageNo");
		//调用
		Page<Book> page = bookService.getBookByPage(pageNo);
		//将page存放到域中
		request.setAttribute("page", page);
		//跳转book_client.jsp
		request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request, response);
	}
	
	/**
	 * 客户端带价格区间分页查询
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBooksByPageAndPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取pageNo,min,max值
		String pageNo = request.getParameter("pageNo");
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		//调用Service
		Page<Book> page = bookService.getBookByPageAndPrice(pageNo, min, max);
		//将数据存放到域中
		request.setAttribute("page", page);
		//跳转
		request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request, response);
	}
	

}
