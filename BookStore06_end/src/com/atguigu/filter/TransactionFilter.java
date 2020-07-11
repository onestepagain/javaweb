package com.atguigu.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.util.JDBCUtils;

/**
 * Servlet Filter implementation class TransactionFilter
 */
public class TransactionFilter extends HttpFilter {

	/**
	 * 1. 处理异常
	 * 2. 统一处理事务
	 */
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Connection connection = JDBCUtils.getConnection();
		try {
			//开启事务
			connection.setAutoCommit(false);
			//放行
			chain.doFilter(request, response);
			//无异常，提交事务
			connection.commit();
		} catch (Exception e) {
			//有异常，回滚事务
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/pages/error/transaction_error.jsp");
		}finally {
			//释放Connection
			JDBCUtils.releaseConnection();
		}
		
	}
       
   

}
