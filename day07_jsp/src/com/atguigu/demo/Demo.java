package com.atguigu.demo;

public class Demo {

	/**
	  Jsp
	  		* 简介：Java Server Pages（java服务器端页面）
	  			* Servlet = java + html
	  			* Jsp = html + java
	  			* Jsp只能运行服务器（Web容器）中。
	  			* Jsp本质是Servlet
	  		* Jsp运行原理
	  			* 第一次访问jsp文件时，会经过一下步骤
	  				* 服务器将.jsp文件翻译为.java文件（Servlet）
	  				* 将.java文件编译为.class文件 
	  				* 运行
	  			* 如文件未改变时，以后再访问，不会翻译和编译。
	  		* Jsp基本语法（6）
	  			* 指令
	  				* 语法：<%@ %>
	  			* 脚本片段
	  				* 语法：<%%>
	  				* 作用：书写java代码。（_jspService()中）
	  			* 表达式
	  				* 语法：<%= %> 
	  				* 作用：输出数据到页面
	  			* 模板元素（html）
	  			* 声明
	  				* 语法：<%!%> 
	  				* 书写java代码。（类中）
	  			* 注释
	  				* html:<!---->
	  				* java://  /**\/ 
					* jsp:<%-- --%>
	  		* Jsp指令
	  			* 语法：<%@ 指令名   属性=属性值    属性2=属性值2%>
	  			* 常用指令 
	  				* page指令
	  					* language：支持语言，默认java，只有java。
	  					* contentType：与response.setContentType()作用一致。
	  					* pageEncoding：jsp页面编码。
	  					* import：导包
	  					* errorPage：错误页面（当前页面报错时，显示的页面）
	  					* isErrorPage：设置当前页面是否为错误页面
	  				* include指令
	  					* 作用：将目标页面包含到当前页面中。
	  					* 特点：静态包含，被包含的文件不会被翻译和编译。
	  				* taglib(jstl时讲到) 
	  		* Jsp动作标签
	  			* 语法：<jsp: 标签名  属性=属性值></jsp:>
	  			* 常用的动作标签
	  				* 转发：
	  					* 带参数
	  						* <jsp:forward page="NewFile.jsp">
								<jsp:param value="18" name="age"/>
							 </jsp:forward>
	  					* 不带参数
	  						* 注意开始标签与结束标签之间不能有任何内容。
	  				* 动态包含	
	  					* 语法：<jsp:include page="被包含文件的路径"></jsp:include>
	  					* 特点：被包含文件会先被翻译和编译
	  		* Jsp九大隐含对象
	  			* 定义：可以在jsp中直接使用的对象。（不需要我们new的对象，服务器实例化的九大隐含对象，并存放在_jspService（）方法中）
	  			* 对象详情
	  				1. application
	  					* 类型：ServletContext
	  				 	* 作用：域对象
	  				 	* Servlet中的获取方式：this.getServletContext()
	  				2. session
	  				 	* 类型：HttpSession
	  				 	* 作用：域对象
	  				 	* Servlet中的获取方式：request.getSession();
	  				3. request
	  					* 类型：HttpServletRequest
	  					* 作用：域对象（4个）
	  					* Servlet中的获取方式：直接使用
	  				4. pageContext
	  					* 类型：PageContext
	  					* 作用
	  						* 域对象
	  						* jsp老大（可以通过老大直接获取其他八个隐含对象） 
	  					* Servlet中的获取方式：无
	  				5. response
	  					* 类型：HttpServletResponse
	  					* 作用：域Servlet中的response对象一致
	  					* Servlet中的获取方式：直接使用
	  				6. page
	  					* 类型：Object
	  					* 作用：page = this,当前类的对象。
	  				7. out
	  					* 类型：JspWriter
	  					* 作用：与Servlet中的PrintWriter的作用类似。(都继承了java.io.Writer)
	  				8. config
	  					* 类型：ServletConfig
	  					* 作用：与Servlet中的ServletConfig的作用一致
	  					* Servlet中的获取方式:this.getServletConfig()
	  				9. exception
	  					* 类型：Throwable
	  					* 作用：接受处理异常信息
	  		* Jsp四大域对象
	  			* 域：区域，在web应用的不同资源中，相互传递数据。
	  				* 生活区域（快递）
	  					* 昌平区域
	  					* 北京同城
	  					* 全国快递
	  					* 全球快递
	  				* 程序区域
	  			* 域对象共有的方法
	  				* getAttribute()
	  				* setAttribute()
	  				* removeAttribute() 
	  			* 详情
	  				* application
	  					* 范围： 当前项目中有效
	  				* session
	  				 	* 范围： 当前会话中有效（与浏览器，只有浏览器不关闭|不换，就一直有效）
	  				* request
	  					* 范围： 当前请求中有效
	  				* pageContext 
	  					* 范围： 当前页面中有效
	  			* 能用小域，就不用大域。
	 */
	
}
