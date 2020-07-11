package com.atguigu.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.atguigu.bean.Book;
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

}
