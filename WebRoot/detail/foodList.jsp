<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${pageContext.request.contextPath}/detail/style/images/title_arrow.gif"/> 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${pageContext.request.contextPath}/showFood" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="foodname" title="请输入菜品名称" value="${param.foodname}">
			<input type="submit" value="搜索">
		</form>
	</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table >
        <!-- 表头-->
        <thead>
            <tr>
				<td>菜编号</td>
				<td>菜名</td>
				<td>价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
     
		<c:forEach var="v" items="${requestScope.foodlist.data}">
			<tr class="TableDetail1">
				<td>${pageScope.v.foodid}</td>
				<td><a href="${pageContext.request.contextPath}/food/${pageScope.v.foodid}">${pageScope.v.foodname}</a></td>
				<td>${pageScope.v.price}</td>
				<td>
					<a href="${pageContext.request.contextPath}/detail/updateFood.jsp?foodid=${pageScope.v.foodid}&foodname=${pageScope.v.foodname}&price=${pageScope.v.price}&desce=${pageScope.v.desce}&imageurl=${pageScope.v.imageurl}"  class="FunctionButton">更新</a>				
					<a href="${pageContext.request.contextPath}/food?foodId=${pageScope.v.foodid}" class="FunctionButton">删除</a>				
				</td>
		   </tr>
		</c:forEach>
		<tr>
			<td colspan="4">
				<a href="${pageContext.request.contextPath}/showFood?curPage=1">首页</a>
				<a href="${pageContext.request.contextPath}/showFood?curPage=${requestScope.foodlist.prePage}">上一页</a>
				<c:forEach var="i" begin="1" end="${requestScope.foodlist.totalPage}" step="1">
				<a href="${pageContext.request.contextPath}/showFood?curPage=${pageScope.i}">${pageScope.i}</a>
				</c:forEach>
				<a href="${pageContext.request.contextPath}/showFood?curPage=${requestScope.foodlist.nextPage}">下一页</a>
				<a href="${pageContext.request.contextPath}/showFood?curPage=${requestScope.foodlist.totalPage}">尾页</a>
			</td>
		</tr>
        
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail">
		<div class="FunctionButton"><a href="${pageContext.request.contextPath}/detail/saveFood.jsp">添加</a></div>
    </div> 
</div>
</body>
</html>
