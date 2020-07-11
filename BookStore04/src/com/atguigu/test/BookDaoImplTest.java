package com.atguigu.test;

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
	
}
