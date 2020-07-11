package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
	private BookService bookService = new BookServiceImpl();
	/**
	 * 查询所有book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值（不用）
		//调用service中的相应方法
		List<Book> books = bookService.getAllBooks();
		//将books存放到域中
		request.setAttribute("books",books);
		//跳转,book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	
	/**
	 * 添加book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值
		String bookId = request.getParameter("bookId");
		//调用service
		bookService.delBookById(bookId);
		//跳转
		response.sendRedirect(request.getContextPath()+"/BookServlet?method=getAllBooks");
	}
	
	
	/**
	 * 通过id获取book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取bookid值
		String id = request.getParameter("bookId");
		//调用Service
		Book book = bookService.getBookById(id);
		//将book存放域中
		request.setAttribute("book", book);
		//跳转,book_update.jsp
		request.getRequestDispatcher("/pages/manager/book_update.jsp").forward(request, response);
	}
	
	/**
	 * 添加book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
//	protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//取值
//		String title = request.getParameter("title");
//		String author = request.getParameter("author");
//		String price = request.getParameter("price");
//		String sales = request.getParameter("sales");
//		String stock = request.getParameter("stock");
//		//调用service
//		bookService.addBook(new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
//		//跳转,重新查询,book_manager.jsp
////		getAllBooks(request, response);
//		response.sendRedirect(request.getContextPath()+"/BookServlet?method=getAllBooks");
//	}
	/**
	 * 通过id获取book信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值
		String id = request.getParameter("bookId");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		//通过判断id值是否为空，执行相应方法
		//调用service
		if(id == null || "".equals(id)) {
			//调用addBook()
			bookService.addBook(new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
		}else {
			//调用updateBook()
			bookService.updateBook(new Book(Integer.parseInt(id), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
		}
		//跳转
		response.sendRedirect(request.getContextPath()+"/BookServlet?method=getAllBooks");
	}
	
	
}
