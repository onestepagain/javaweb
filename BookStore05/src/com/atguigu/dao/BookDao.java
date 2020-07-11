package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

public interface BookDao {

	/**
	 * 查询所有book信息
	 * sql:select * from books
	 */
	public List<Book> getAllBooks();
	
	/**
	 * 添加book信息
	 * sql:insert into books(title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)
	 */
	public void addBook(Book book); 
	
	/**
	 * 删除book通过id
	 * @param id
	 */
	public void delBookById(String id); 
	
	/**
	 * 通过id获取book
	 * 		1. 通过id获取Book信息
	 * 		2. updateBook
	 */
	public Book getBookById(String id);
	
	/**
	 * 修改book
	 * 	sql:update books set title=?,author=?,price=?,sales=?,stock=? where id=?
	 */
	public void updateBook(Book book);
	
	
	/**
	 * 实现分页查询Book
	 */
	public Page<Book> getBooksByPage(Page<Book> page);
	
	/**
	 * 带价格区间的分页查询
	 * @param page
	 * @param min
	 * @param max
	 * @return
	 */
	public Page<Book> getBooksByPageAndPrice(Page<Book> page,double min,double max);
	
}
