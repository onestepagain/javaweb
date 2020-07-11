package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//登录   ||  注册
		String method = request.getParameter("method");
		try {
			//使用反射通过方法名动态获取方法对象，
			Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			//从而执行该方法
			method2.invoke(this, request,response);
			
		} catch (Exception e) {
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
//		if("login".equals(method)) {
//			//登录
//			login(request, response);
//		}else if("regist".equals(method)) {
//			//注册
//			regist(request, response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
