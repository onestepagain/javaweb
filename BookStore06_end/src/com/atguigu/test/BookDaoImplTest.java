package com.atguigu.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;

class BookDaoImplTest {

	BookDao bookDao = new BookDaoImpl();
	
	@Test
	void testGetAllBooks() {
		List<Book> allBooks = bookDao.getAllBooks();
		for (Book book : allBooks) {
			System.out.println(book);
		}
	}
	
	@Test
	void testAddBook() {
		bookDao.addBook(new Book(null, "testTitle", "testAuthor", 100, 200, 250, null));
	}

	@Test
	void testGetBooksByPage() {
		Page<Book> page = new Page<Book>();
		page.setPageNo(2);
		Page<Book> page2 = bookDao.getBooksByPage(page);
		
		System.out.println(page.getPageNo()+"/"+page.getTotalPageNo());
		System.out.println("总记录数："+page.getTotalRecord());//   5/19
		for (Book book : page2.getList()) {
			System.out.println(book);	
		}
		
	}
	
	@Test
	void testBigDecimal() {
		BigDecimal bd = new BigDecimal("0.33");
		BigDecimal bd2 = new BigDecimal("0.33");
		
		double d = 0.33;
		double d2 = 0.33;
		
		BigDecimal rs = bd.multiply(bd2);
		
		System.out.println(rs.doubleValue());
		
	}
}
