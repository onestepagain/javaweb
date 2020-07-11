package com.atguigu.demo;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.atguigu.bean.Student;

public class Demo {

	/**
	 * XML解析
	 * 		* XML简介：eXtensible Markup Language(可扩展标记语言)
	 * 		* XML与HTML区别
	 * 			* XML没有预定义标签，均为自定义标签，HTML相反
				* XML用来传输和存储数据，HTML用来显示数据
	 * 
	 */
	public static void main(String[] args) {
	     try {
	    	//创建解析器
	    	SAXReader reader = new SAXReader();
	    	//将xml解析成Document对象
			Document document = reader.read("students.xml");
			//通过Document对象获取根元素
			Element rootElement = document.getRootElement();
			//通过根元素，获取所有的子元素
			List<Element> elements = rootElement.elements();
			for (Element element : elements) {
				//通过attributeValue()获取属性值
				String id = element.attributeValue("id");
				//通过elementText()获取元素的文本值
				String name = element.elementText("name");
				String age = element.elementText("age");
				Student stu = new Student(id, name, age);
				System.out.println(stu);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
}
