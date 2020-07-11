package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 注册
	 * 		1. 取值
	 * 		2. 校验用户名是否存在
	 * 			1. 不存在：调用saveUser()，保存用户信息
	 * 			2. 存在：跳转回注册页面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserService userService = new UserServiceImpl();
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
			System.out.println("saveUser()");
			userService.saveUser(new User(null, username, password, email));
			//重定向到注册成功页面
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
