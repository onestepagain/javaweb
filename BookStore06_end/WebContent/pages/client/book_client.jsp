<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		//实现确定按钮分页查询
		$("#sub_page").click(function(){
			//取pageNo值
			var pageNo = $("#pn_input").val();
			//请求BookServlet
			var min = $("input[name='min']").val();
			var max = $("input[name='max']").val();
			//请求BookClientServlet
			location = "BookClientServlet?method=getBooksByPageAndPrice&pageNo="+pageNo
					+"&min="+min+"&max="+max;});
		
		//带价格区间的分页查询
		$(".book_cond :button").click(function(){
			//取pageNo,min,max值
			var pageNo = $("#pn_input").val();
			var min = $("input[name='min']").val();
			var max = $("input[name='max']").val();
			//请求BookClientServlet
			location = "BookClientServlet?method=getBooksByPageAndPrice&pageNo="+pageNo
					+"&min="+min+"&max="+max;
		});
		
		//添加book到cart
		$(".book_add button").click(function(){
			//取bookid值
			var bookId = $(this).attr("id");
			//调用CartServlet
			location = "CartServlet?method=addBookToCart&bookId="+bookId;
		});
		
	});

</script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@ include file="/WEB-INF/include/welcome.jsp" %>
	</div>
	
	<div id="main">
		<div id="book">
			<div class="book_cond">
				价格：<input type="text" name="min" value="${param.min }"> 元 - 
				<input type="text" name="max" value="${param.max }"> 元
				<button>查询</button>
			</div>
			<div style="text-align: center">
				<c:if test="${not empty sessionScope.cart.totalCount && sessionScope.cart.totalCount != 0 }">
					<span>您的购物车中有${sessionScope.cart.totalCount }件商品</span>
				</c:if>
				<div>
					<c:if test="${not empty sessionScope.title}">
						您刚刚将<span style="color: red">${sessionScope.title }</span>加入到了购物车中
					</c:if>
					<c:remove var="title" scope="session"/>
					<c:if test="${not empty sessionScope.msg}">
						<span style="color: red">${sessionScope.msg }</span>
					</c:if>
					<c:remove var="msg" scope="session"/>
				</div>
			</div>
			<c:forEach items="${requestScope.page.list }" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="static/img/default.jpg" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.title }</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author }</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${book.price }</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales }</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock }</span>
						</div>
						<div class="book_add">
							<button id="${book.id }">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
<!-- 		[1]23
			[1]2345 
 			1[2]345 
 			12[3]45 
			23[4]56
			34[5]67
			45[6]78
			456[7]8
			4567[8]
			
			totalPageNo<5
				begin=1
				end=totalPageNo
			totalPageNo>=5
				pageNo<=3
					begin=1
					end=5
				pageNo>3 && pageNo<=totalPageNo-2
					begin=pageNo-2
					end=pageNo+2
				pageNo > totalPageNo-2
					begin=totalPageNo-4
					end=totalPageNo
 -->
		<div id="page_nav">
		<c:choose>
			<c:when test="${page.totalPageNo<5 }">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="${page.totalPageNo }"></c:set>
			</c:when>
			<c:when test="${page.pageNo<=3 }">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="5"></c:set>
			</c:when>
			<c:when test="${page.pageNo>3 and page.pageNo <= page.totalPageNo-2}">
				<c:set var="begin" value="${page.pageNo-2 }"></c:set>
				<c:set var="end" value="${page.pageNo+2 }"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${page.totalPageNo-4 }"></c:set>
				<c:set var="end" value="${page.totalPageNo }"></c:set>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${begin }" end="${end }" step="1">
			<c:if test="${page.pageNo == i }">
				【${i }】
			</c:if>
			<c:if test="${page.pageNo != i }">
				<a href="BookClientServlet?method=getBooksByPageAndPrice&pageNo=${i}&min=${param.min}&max=${param.max}">${i }</a>
			</c:if>
		</c:forEach>
		共${requestScope.page.pageNo }/${requestScope.page.totalPageNo }页，${requestScope.page.totalRecord}条记录
			 到第<input value="${requestScope.page.pageNo }" name="pn" id="pn_input"/>页
			<input id="sub_page" type="button" value="确定">
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>