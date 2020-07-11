package com.atguigu.demo;

public class Demo {

	/**
	 * Servlet
	 * 		* 为什么学Servlet
	 * 			html	servlet 	dao-jdbc(sql:select * from users where username=? and pwd=?)
	 * 		* Servlet简介
	 * 			* Servlet = java + html(url)
	 * 			* Server Applet
	 * 			* 狭义：javax.servlet.Servlet接口及其子接口
   				      广义：指实现了Servlet接口的实现类
			* Servlet工作原理（执行流程）
				* 请求
				* web.xml中url
				* servlet-name -> servlet-class -> 找到指定Servlet
				* 默认执行service()，处理请求，做出响应。
			* Servlet生命周期：从创建到消亡的过程
				* 构造器
					* 执行次数：在整个生命周期中执行一次。
					* 执行时机：第一次接收请求时执行
				* init()：初始化
					* 执行次数：在整个生命周期中执行一次。
					* 执行时机：第一次接收请求时执行
				* service()
					* 执行次数：在整个生命周期中执行多次。
					* 执行时机：每次接收请求时执行
				* destroy()
					* 执行次数：在整个生命周期中执行一次。
					* 执行时机：关闭服务器时执行
			* ServeltConfig与ServletContext区别
				*  ServeltConfig代表了当前Servlet的配置信息，它有以下三个作用：
					* 获取当前Servlet的名称
					* 获取当前Servlet的初始化参数（只能是当前的Servlet才能获取，		其他Servlet不能得到）
					* 获取ServletContext对象
				* ServletContext
					* 获取当前Web应用的初始化参数（web.xml中注册的所有的Servlet		都可以获取）
					* 获取服务器端资源的真实路径（文件的上传下载时需要用到）
					* 它是一个域对象（后面讲解）dssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssddsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssddddddddddddddddddddddddsdssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssddssssssssdsddsdddddddddddddddddddddddddddddssddsdssdsssssssssssssssssddddsdsddsdsdsdssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssddf
			* 最终创建Servlet方式
				* 继承HttpServlet类,也称之为Servlet
					* EndServlet : HttpServlet : GenericServlet : Servlet
					* HttpServlet
						1. override service()
							HttpServletRequest request = (HttpServletRequest)req;
							HttpServletResponse response = (HttpServletResponse)res;
						2. overload service()
							String method = request.getMethod();
							if(method.eq("GET")){
								doGet();
							}else if(method.eq("POST")){
								doPost();
							}
					* GenericServlet
						1. getServletConfig()	getServletContext()
						2. abstract service()
			* 请求和响应
			* 转发与重定向区别
	 */
	
}
