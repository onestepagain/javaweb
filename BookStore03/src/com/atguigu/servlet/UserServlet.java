package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
     
	UserService userService = new UserServiceImpl();
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 取用户名&密码值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2. 调用dao登录接口
		User user = userService.getUser(new User(null, username, password, null));
		if(user == null) {
			//登录失败，转发
			//标记，在域中存放数据
			request.setAttribute("msg", "用户名或密码输入有误，请重新输入！");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else {
			//登录成功，重定向
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}
	}
	
	/**
	 * 注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取用户名值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//调用service中的方法
		boolean yOn = userService.checkUserName(username);
		if(yOn) {
			//用户名存在，转发
			request.setAttribute("msg", "用户名已存在，请重新输入！");
//			request.setAttribute("uname", username);
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}else {
			//用户名不存在,saveUser();
			userService.saveUser(new User(null, username, password, email));
			//重定向到注册成功页面
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}
	}
	
}
