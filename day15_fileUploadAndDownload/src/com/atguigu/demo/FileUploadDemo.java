package com.atguigu.demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadDemo
 */
public class FileUploadDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		/*
		  	* 准备： 导入两个jar文件&页面3处
		  		1. 创建工厂类
		  		2. 创建解析器ServletFileUpload//ServletFileUpload 
		  		3. 使用ServletFileUpload中的List<FileItem> parseRequest(request)
		  		4. 使用FileItem中的write()方法，写到服务器。
		 */
		//1. 创建工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//2. 创建解析器ServletFileUpload//ServletFileUpload 
		ServletFileUpload upload = new ServletFileUpload(factory);
		//获取upload的真实路径
		String realPath = this.getServletContext().getRealPath("/upload");
//		System.out.println("realPath:"+realPath);
		//设置单个文件的上传大小
		upload.setFileSizeMax(2*1024);
		//3. 使用ServletFileUpload中的List<FileItem> parseRequest(request)
		try {
			List<FileItem> list = upload.parseRequest(request);
			//迭代集合，找到指定的文件
			for (FileItem fileItem : list) {
				if(fileItem.isFormField() == false) {
					String uuid = UUID.randomUUID().toString().replace("-", "");
					String filePath = realPath+"/"+uuid+fileItem.getName();
					File file = new File(filePath);
					//4. 使用FileItem中的write()方法，写到服务器。
					fileItem.write(file);
				}
			}
			
		} catch (FileSizeLimitExceededException e) {
			writer.write("单个文件大小不能超过2k");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		response.getWriter().write("upload success!");
		//获取参数
//		String username = request.getParameter("uname");
//		String fileupload = request.getParameter("fileupload");
//		System.out.println(username);
//		System.out.println(fileupload);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
