package com.atguigu.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.atguigu.bean.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Demo {

	/**
	 * 	Ajax
	 		* 简介
	 			* Asynchronous JavaScript And XML，直译为，异步的JS和XML。
	 			* AJAX也可以简单的理解为通过JS向服务器发送异步请求。
	 				* 不发生页面跳转、异步载入内容并改写页面内容的技术。 
	 		* 异步请求&同步请求
	 			* 同步处理问题；
						1. 请求：发送二次请求时，只能等上次请求响应后，才能执行
						2. 效率：就算我们需要刷新局部，也必须刷新整个页面
				*	异步解决问题
						1. 请求：aJax请求不会影响其他请求
						2. 效率：局部刷新
	 		* 使用
	 			js->ajax
	 			jQuery->ajax(常用)
	 				* 语法
	 					$.ajax({
						   type: "请求方式：get|post",
						   url: "请求路径",
						   data: "参数",
						   dataType:预期服务器返回的数据类型，如：xml|json|text
						   success:fn(回调函数：请求成功时回调),
						   error:fn(回调函数：请求失败时回调)
						});
	 		* Ajax简写
	 			* $.post(url, [data], [callback], [dataType]) 
	 			* $.get(url, [data], [callback], [dataType]) 
	 			* $.getJSON(url,[data],[callback]);
	 		* JSON
	 			* 简介：JavaScript Object Notation 的缩写，是JS提供的一种数据交换格式。
	 			* JSON对象本质上就是一个JS对象，但是这个对象比较特殊，它可以直接转换为字符串，
	 			 		在不同语言中进行传递，通过工具又可以转换为其他语言中的对象。
	 			* 使用
	 				* Gson gson = new Gson()
	 				* 常用方法
	 					* String toJson(Object o)
	 					* fromJson(String jsonStr,Class) 
	 					* fromJson(String jsonStr,Type) 
	 				* Type获取方式
	 					*  new TypeToken<List<Student>>() {}.getType()
	 */
	
	@Test
	public void testJsonStrObject() {
		Gson gson = new Gson();
		Student stu = new Student("zs", 18);
		//student->jsonString 
		String jsonStr = gson.toJson(stu);//{"name":"zs","age":18}
		System.out.println(jsonStr);
		//jsonString->student
		Student student = gson.fromJson(jsonStr, Student.class);
		System.out.println(student);
	}
	
	@Test
	public void testJsonStrList() {
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student("zs", 18));
		stuList.add(new Student("lisi", 19));
		//stuList->jsonString
		Gson gson = new Gson();
		String jsonStr = gson.toJson(stuList);//[{"name":"zs","age":18},{"name":"zs","age":18}]
		System.out.println(jsonStr);
		//jsonString->List<Student>
//		List<Student> list = gson.fromJson(jsonStr, List.class);
//		System.out.println(list.get(0));
		//使用typeToken
		List<Student> list = gson.fromJson(jsonStr, new TypeToken<List<Student>>() {}.getType());
		System.out.println(list.get(0).getName());
	}
	
	@Test
	public void testJsonStrMap() {
		Map<String,Student> map = new HashMap<>();
		map.put("zs", new Student("zs", 18));
		map.put("ls", new Student("ls", 20));
		//map -> jsonString
		Gson gson = new Gson();
		String jsonString = gson.toJson(map);//{{"zs":{"name":"zs"},"age":18},{"ls":{"name":"ls"}}
		System.out.println(jsonString);
		//jsonString-> map
		Map<String,Student> mapStu = gson.fromJson(jsonString, new TypeToken<Map<String,Student>>(){}.getType());
		
		System.out.println(mapStu.get("zs").getAge());
		
	}
	
}
