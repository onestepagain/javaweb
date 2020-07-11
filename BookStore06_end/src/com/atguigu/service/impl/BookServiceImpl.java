package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void delBookById(String id) {
		bookDao.delBookById(id);
	}

	@Override
	public Book getBookById(String id) {
		return bookDao.getBookById(id);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public Page<Book> getBookByPage(String pageNo) {
		Page<Book> page = new Page<Book>();
		int pNo = 1;
		try {
			pNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
//			e.printStackTrace();
		}
		page.setPageNo(pNo);
		return bookDao.getBooksByPage(page);
	}

	@Override
	public Page<Book> getBookByPageAndPrice(String pageNo, String min, String max) {
		Page<Book> page = new Page<Book>();
		int pNo = 1;
		try {
			pNo = Integer.parseInt(pageNo);
		} catch (NumberFormatException e) {
//			e.printStackTrace();
		}
		page.setPageNo(pNo);
		//处理min，max
		double minEnd = 0;
		double maxEnd = Double.MAX_VALUE;
		try {
			minEnd = Double.parseDouble(min);
			maxEnd = Double.parseDouble(max);
			//交换值
			double temp=0;
			if(minEnd > maxEnd) {
				temp = minEnd;
				minEnd = maxEnd;
				maxEnd = temp;
			}
		} catch (NumberFormatException e) {
//			e.printStackTrace();
		}
		return bookDao.getBooksByPageAndPrice(page, minEnd, maxEnd);
	}

}
