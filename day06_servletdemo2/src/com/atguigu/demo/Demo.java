package com.atguigu.demo;

public class Demo {

	/**
	 	1. 请求和响应
	 		* 请求：客户端向服务器
	 			* 类型：HttpServletRequest request
	 			* 定义：代表了客户端向服务器发送的请求报文，该对象由服务器（web容器|Servlet容器）创建，
	 					同时发送给Service(),Service()发送给doGet()或doPost()。
	 			* 作用 	
  					1. 获取请求参数
  						* request.getParameter("username");
  						* request.getParameterValues(name)
  					2. 获取项目的虚拟路径
  						* request.getContextPath();
  					3. 转发（路径跳转）
  						* request.getRequestDispatcher("").forward(request, response);
  					4. 域对象（哥四个）
	 		* 响应：服务器向客户端
	 			* 类型： HttpServletResponse response
	 			* 定义：代表了服务器向客户端发送的响应报文，该对象由服务器（web容器|Servlet容器）创建，
	 					同时发送给Service(),Service()发送给doGet()或doPost()。
	 			* 作用
	 			 	1. 服务器向客户端做出响应（文本|html）
	 			 		* response.getWriter();
	 			 		* write();|print();
	 			 	2. 重定向（路径跳转）
	 			 		* response.sendRedirect();
	 	2. 转发与重定向区别
	 		* 转发地址栏不变，重定向地址栏改变。
	 		* 转发客户端发送一次请求，重定向客户端发送两次请求。
	 		* 转发可以访问WEB-INF下资源，重定向不能。
	 			* 因为WEB-INF目录属于Web应用的私有目录（客户端无法直接访问） 
	 		* 转发可以携带request对象，重定向不能。
	 	3. Servlet练习（伪登录|伪注册）User:admin2,admin2
	 	4. Web应用中路径问题
	 		* 在web应用中，由于使用转发跳转路径时，地址栏不变。此时使用相对路径（../）存在404现象。
	 			固使用绝对路径，解决web应用中的路径问题
	 		* 什么是绝对路径，以“/”开头的路径，称之为绝对路径。
	 			* “/”代表意思
	 				* 由服务器解析，代表着当前项目路径：http://localhost:8080/day06_servletdemo2
	 					* 以下两种情况由服务器解析
	 						1. web.xml中的url
	 						2. 转发
	 				* 由浏览器解析，代表着当前服务器路径：http://localhost:8080
	 					* 以下两种情况由浏览器解析
	 						1. html中的路径,eg:src:script|img  href:link|a  action:form
	 						2. 重定向
	 	5. Web应用中乱码问题
	 		* 乱码：编码与解码不一致时，出现乱码现在
	 		 	* 请求乱码：客户端编码与服务器解码不一致
	 			* 响应乱码：服务器编码与客户端解码不一致
	 		* 编码：将字符转换为二进制的过程称之为编码
	 		* 解码：将二进制转换为字符的过程称之为解码
	 		* 默认客户端与服务器端编码与解码请情况
	 			* 服务器的编码与解码默认一致为：ISO-8859-1
	 			* 客户端（浏览器）编码默认为：<meta charset="UTF-8">
	 			 			解码默认为：GBK
	 		* 解决web中乱码问题
	 			* 请求乱码
	 				* POST请求：request.setCharacterEncoding("UTF-8");
	 				* GET请求：server.xml中修改，URIEncoding="UTF-8"
	 					* eg:<Connector port="8080"  URIEncoding="UTF-8"/>
	 			* 响应乱码
	 				* 直接将服务器编码设置为GBK
	 					* response.setCharacterEncoding("GBK"); 
	 				* 将服务器编码与浏览器解码设置为UTF-8
	 					* response.setContentType("text/html;charset=UTF-8");
	 		* Tomcat8.0之前默认编码为：ISO-8859-1
	 		  Tomcat8.0之后（含8.0）默认编码为：UTF-8
	 	6. 项目第二阶段
	 
	 */
	
	
}
