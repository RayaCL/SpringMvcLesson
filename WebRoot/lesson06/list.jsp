<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'list.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
		/*
		封装的发送ajax的函数
		url 发送请求的地址
		方法类型 get或者post
		参数 通过 键=值&键=值 方式
		回调函数 当结果返回 自动调用的函数 第一个参数就是返回的结果
		*/
		function sendAjax(url,methodType,param,retnFunction){
			//无刷新调用http://localhost:8080/SpringMvcLesson/queryFood 获取到数据数据通过dom方式添加到table
			//ajax(异步的ajax)+json
			var xmlhttp=null;
			//兼容所有的浏览器创建这个对象XHR对象
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			//回调函数
			/*
			存有 XMLHttpRequest 的状态。从 0 到 4 发生变化。
			0: 请求未初始化(没有调用send方法)
			1: 服务器连接已建立(socket已连接)
			2: 请求已接收(获取到了参数 没有执行action方法)
			3: 请求处理中(已经在执行action方法 未执行完)
			4: 请求已完成，且响应已就绪(已经响应并且能获取到最终的数据)
			status	
			200: "OK"
			404: 未找到页面
			*/
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					retnFunction(xmlhttp.responseText);
				}
			}
			if(methodType=="get" || methodType=="GET"){
				xmlhttp.open("GET", url+"?"+param, true);
				xmlhttp.send();
			}else{
				xmlhttp.open("POST", url, true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
				xmlhttp.send(param);
			}
		}
		/*
		使用ajax
		尽量使用true异步模式(防假死)
		尽量将获取数据之后的逻辑处理(页面渲染)放在回调函数中


		//open方法表示 产生一个请求的关联(get 提交)
			
		一个ajax线程是否执行完成 可以通过回调函数xmlhttp.onreadystatechange  是否执行完成来判断
		 * 异步 多个线程同时执行 无法判断 谁先执行
		 * 同步 一次只能一个线程执行
			
		*/

		function query() {
					var foodname=document.getElementsByName("foodName")[0].value;
					sendAjax("${pageContext.request.contextPath}/queryFoodReturn","GET","foodname"+foodname,function(responseText){
					//返回的是字符串的json
					var resutlJson = responseText;
					//转换为js对象
					var resultObj=JSON.parse(resutlJson);
					//获取表格对象
					var table=document.getElementById("mytable")
					//将所有名字为datatr的tr删除
					var allDataTr=document.getElementsByName("datatr");
					var length=allDataTr.length;
					for(var i=0;i<length;i++){
						table.removeChild(allDataTr[0]);
					}
					
					for(var i=0;i<resultObj.length;i++){
						var obj=resultObj[i];
						var td=document.createElement("td");
						td.innerText=obj.foodname;
						var td1=document.createElement("td");
						td1.innerText=obj.price;
						var td2=document.createElement("td");
						var ib=document.createElement("button");
						ib.innerText="删除";
						td2.appendChild(ib);
						var ib1=document.createElement("button");
						ib1.innerText="修改";
						td2.appendChild(ib1);
			
						var tr=document.createElement("tr");
						//将当前行的json对象绑定到当前按钮上
						ib.foodObj=obj;
						//将当前行的tr绑定到当前按钮上
						ib.myLineTr=tr;
						//删除按钮时间
						ib.addEventListener("click",function(){
							//获取当前按钮
							var eventSrc=event.srcElement;
							//删除当前行 + 发送ajax请求到后台删除数据库
							table.removeChild(eventSrc.myLineTr);
							sendAjax("${pageContext.request.contextPath}/food/"+ib.foodObj.foodid,"POST","_method=delete",function(responseText){
								if(responseText==1){
								
									alert("删除成功");
								}else{
									alert("删除失败");
								}
								
							});
						});
						//将当前行的json对象绑定到当前按钮上
						ib1.foodObj=obj;
						ib1.addEventListener("click",function(){
							var eventSrc=event.srcElement;
							document.getElementById('updateDiv').style.display='block';
							document.getElementsByName("umyFoodName")[0].value=eventSrc.foodObj.foodname;
							document.getElementsByName("umyFoodPrice")[0].value=eventSrc.foodObj.price;
							document.getElementsByName("umyFoodId")[0].value=eventSrc.foodObj.foodid;
							
							
						});
						tr.setAttribute("name","datatr");
						tr.appendChild(td);
						tr.appendChild(td1);
						tr.appendChild(td2);
						table.appendChild(tr)
						}
					})
					
				
			/*xmlhttp.open("GET", "${pageContext.request.contextPath}/queryFood?foodname="+foodname, true);
			xmlhttp.send();
			//post的请求 
			xmlhttp.open("POST", "${pageContext.request.contextPath}/queryFood", true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
			xmlhttp.send("foodname="+foodname);
			*/
			
			
		}
		function saveFood(){
			var myFoodName=document.getElementsByName("myFoodName")[0].value;
			var myFoodPrice=document.getElementsByName("myFoodPrice")[0].value;
			
			
			sendAjax("${pageContext.request.contextPath}/food","POST","foodName="+myFoodName+"&price="+myFoodPrice,function(responseText){
								if(responseText==1){
									document.getElementById('addDiv').style.display='none';
									query();
									alert("新增成功");
								}else{
									alert("新增失败");
								}
								
							});
		}
		function updateFood(){
			var myFoodName=document.getElementsByName("umyFoodName")[0].value;
			var myFoodPrice=document.getElementsByName("umyFoodPrice")[0].value;
			var myFoodId=document.getElementsByName("umyFoodId")[0].value;
			
			sendAjax("${pageContext.request.contextPath}/food/"+myFoodId,"POST","_method=PUT&foodName="+myFoodName+"&price="+myFoodPrice,function(responseText){
								if(responseText==1){
									document.getElementById('updateDiv').style.display='none';
									query();
									alert("修改成功");
								}else{
									alert("修改失败");
								}
								
							});
		}
	</script>
	</head>

	<body>
		<input type="text" name="foodName" />
		<input type="button" value="查询" onclick="query()"/>
		<input type="button" value="添加" onclick="document.getElementById('addDiv').style.display='block';"/>
		<table id="mytable">
			<tr>
				<th>菜品名</th>
				<th>菜价</th>
				<th>操作</th>
			</tr>
		</table>
	</body>
	<div id="addDiv" style="display:none;position: absolute;left:40%;top:40%;z-index: 100;border:1px solid black; width:250px;height:100px ">
	 
	 菜品名：<input type="text" name="myFoodName"><br/>
	 价&nbsp;&nbsp;&nbsp;格：<input type="text" name="myFoodPrice"><br/>
	 <input type="button" value="保存" onclick="saveFood()">&nbsp;&nbsp;&nbsp;<input type="button" value="关闭" onclick="document.getElementById('addDiv').style.display='none';" ><br/>
	</div>
	
	
	<div id="updateDiv" style="display:none;position: absolute;left:40%;top:40%;z-index: 100;border:1px solid black; width:250px;height:100px ">
	 <input type="hidden" name="umyFoodId" >
	 菜品名：<input type="text" name="umyFoodName"><br/>
	 价&nbsp;&nbsp;&nbsp;格：<input type="text" name="umyFoodPrice"><br/>
	 <input type="button" value="修改" onclick="updateFood()">&nbsp;&nbsp;&nbsp;<input type="button" value="关闭" onclick="document.getElementById('updateDiv').style.display='none';" ><br/>
	</div>
</html>
