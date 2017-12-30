<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript">
		function checkSubmit(){
			
			//校验不通过不提交
			/*var userName=document.getElementsByName("userName")[0].value;
			if(userName==null || userName==""){
				alert("用户名不能为空");
				return;
			}
			var pass=document.getElementsByName("pass")[0].value;
			var repass=document.getElementsByName("repass")[0].value;
			if(pass!=repass){
				alert("两次输入密码不一致");
				return;
			}*/
			document.forms[0].submit();
		}
	</script>
  </head>
  
  <body>
    <form action="<%=path %>/reg" method="post">&nbsp; 
    	用户名    :<input type="text" name="userName"/>
    			<font color="red"><form:errors path="user.userName"></form:errors></font><br/><br/>
    	密码       :<input type="text" name="pass"/><font color="red">
    		<form:errors path="user.pass"></form:errors></font><br/><br/>
    	确认密码:<input type="text" name="repass"/><font color="red">
    		<form:errors path="user.repass"></form:errors></font><br/><br/>
    	邮件       :<input type="text" name="email"/><font color="red">
    		<form:errors path="user.email"></form:errors></font><br/><br/>
    	年龄       :<input type="text" name="age"/><font color="red">
    		<form:errors path="user.age"></form:errors></font><br/><br/>
    	手机号码:<input type="text" name="tle"/><font color="red">
    		<form:errors path="user.tle"></form:errors></font><br/><br/>
    	日期       :<input type="text" name="time"/><font color="red">
    		<form:errors path="user.time"></form:errors></font><br/><br/>
    	个人网址:<input type="text" name="adds"/><font color="red">
    		<form:errors path="user.adds"></form:errors></font><br/><br/>
    		<input type="button" onclick="checkSubmit()" value="提交"/>
    </form>
  </body>
</html>
