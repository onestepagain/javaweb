package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 实现伪注册
	 * 		1. 获取用户名&密码
	 * 		1_2.
	 * 		         校验用户名是否存在(admin2)
	 * 		2. 调用dao接口，将用户名&密码保存到数据库
	 * 		3. 跳转
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 获取用户名
		String username = request.getParameter("username");
		//校验用户名是否存在(admin2)
		if("admin2".equals(username)) {
			//用户名已存在，请重新输入，注册失败，重定向regist.html
			response.sendRedirect(request.getContextPath()+"/pages/regist.html");
		}else {
			//用户名可用，注册成功，转发regist_success.html
			request.getRequestDispatcher("/pages/regist_success.html").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
