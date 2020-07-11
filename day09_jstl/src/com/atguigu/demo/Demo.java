package com.atguigu.demo;

public class Demo {

	/**
	 	* JSTL
	 		* 简介：JSP Standard Tag Library（JSP标准标签库）
	 		* 作用
	 			* JSTL替代JSP中的脚本中的代码。
	 		* 使用JSTL
	 			* 导包taglibs-standard-impl-1.2.1.jar
						taglibs-standard-spec-1.2.5.jar 	
				* <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	  			* 使用
	  		* JSTL常用标签
	  			* <c:set var="变量名" value="值" scope="域范围">
	  			* <c:set target="对象名" property="属性名" value="属性值">
	  			* <c:out value="值">
	  			* <c:remove var="变量名" scope="域范围">
	  			* <c:if test="判断的结果为布尔值" var="变量" scope="域范围"></if>
	  			* <c:choose>
	  			* 		<c:when test="">
	  			* 		</c:when>
	  			* 		<c:otherwise>
	  			* 		</c:otherwise>
	  			* </c:choose>
	  			* <c:forEach var="变量名" begin="起始下标" end="结束下标" step="步长" item="迭代的集合|数组">
	  			* </c:forEach>
	  	* 项目第三阶段,4
	  	* 项目第四阶段
	  
	 */
	
	public static void main(String[] args) {
		boolean yOn = false;
		if(yOn = 2>1) {
			
		}
		
		
		
	}
	
}
