package com.atguigu.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rp = request.getParameter("rp");
		if(rp != null) {
			//将数据存放Cookie中
			Cookie cookieName = new Cookie("username", username);
			Cookie cookiePwd = new Cookie("cookiePwd", password);
			//将Cookie持久化
			cookieName.setMaxAge(60);	//7天=60*60*24*7
			cookiePwd.setMaxAge(60);
			//将Cookie响应给浏览器
			response.addCookie(cookieName);
			response.addCookie(cookiePwd);
		}
		//跳转
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
