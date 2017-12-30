<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

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
			document.forms[0].submit();
		}
	</script>
  </head>
  
  <body>
  <a href="${pageContext.request.contextPath}/mid?a=zh_CN">中文</a> 
  <a href="${pageContext.request.contextPath}/mid?a=en_GB">English</a>
    <form action="<%=path %>/myreg" method="post">&nbsp; 
    	<s:message code="userName"></s:message>    :<input type="text" name="userName"/>
    			<font color="red"><form:errors path="user.userName"></form:errors></font><br/><br/>
    	<s:message code="pass"></s:message>       :<input type="text" name="pass"/><font color="red">
    		<form:errors path="user.pass"></form:errors></font><br/><br/>
    	<s:message code="repass"></s:message>:<input type="text" name="repass"/><font color="red">
    		<form:errors path="user.repass"></form:errors></font><br/><br/>
    	<s:message code="email"></s:message>       :<input type="text" name="email"/><font color="red">
    		<form:errors path="user.email"></form:errors></font><br/><br/>
    	<s:message code="age"></s:message>       :<input type="text" name="age"/><font color="red">
    		<form:errors path="user.age"></form:errors></font><br/><br/>
    	<s:message code="tle"></s:message>:<input type="text" name="tle"/><font color="red">
    		<form:errors path="user.tle"></form:errors></font><br/><br/>
    	<s:message code="time"></s:message>       :<input type="text" name="time"/><font color="red">
    		<form:errors path="user.time"></form:errors></font><br/><br/>
    	<s:message code="adds"></s:message>:<input type="text" name="adds"/><font color="red">
    		<form:errors path="user.adds"></form:errors></font><br/><br/>
    		<input type="button" onclick="checkSubmit()" value="<s:message code='button'></s:message>"/>
    </form>
  </body>
</html>
