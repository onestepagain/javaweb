package com.atguigu.demo;

import java.util.UUID;

public class Demo {

	/**
	 	* 文件上传&下载
	 		* 文件上传
	 			* 准备： 
	 				1. 导入commons-fileupload-1.3.1.jar和commons-io-2.5.jar两个jar文件
					2. form属性 method="post"
					3. enctype="multipart/form-data"
					4. <input type="file" name="fileupload">
	 			* 步骤如下
			  		1. 创建工厂类：DiskFileItemFactory
			  		2. 创建解析器ServletFileUpload
			  		3. 使用解析器中parseRequest(request)方法，将request对象解析为List<FileItem>
			  		4. 迭代集合，找到文件类型为File的FileItem
			  		5. 使用FileItem中的write()方法，写到服务器。 
			  	* 优化文件上传
			  		* 使用UUID优化同名无法上传问题
			  			* String uuid = UUID.randomUUID().toString().replace("-", ""); 
			  		* 设置上传文件的大小
			  			* 设置单个文件的上传大小：upload.setFileSizeMax(2*1024);
			  			* 设置总文件的上传大小：upload.setSizeMax(2*1024); 
	 		* 文件下载
	 			* 准备：
	 				* 超链接<a href="资源路径">资源</a>
	 				* 下载Servlet
	 					1. 获取下载资源 
	 						* 获取下载资源的名字
	 						* 通过名字获取资源真实路径
	 					2. 文件下载设置项
	 						* 设置浏览器响应体文件类型
	 						* 解决文件名中文乱码问题
	 						* 设置浏览器响应体内容格式，为附件格式。(告诉浏览器别播放，下载)
	 					3. 读取目标资源，同时写到客户端（下载）
	 
	 */
	
}
