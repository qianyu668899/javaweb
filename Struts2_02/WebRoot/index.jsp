<?xml version="1.0" encoding="GB18030" ?>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
<base href="<%=basePath %>"/>
<title>Insert title here</title>
</head>
<body> 
Use Domain Model to accept parameters<br>
<a href="user/user!add?user.name=a&user.age=8">Add User</a>
<a href="user/user!add?name=a&age=8">Add User(ModelDriven)</a><br>

<form name="f" action="" method="post">
�û�����<input type="text" name="name"/>
���룺<input type="text" name="password"/>
<br />
<input type="button" value="submit1" onclick="javascript:document.f.action='login/login1';document.f.submit();" />
<input type="button" value="submit2" onclick="javascript:document.f.action='login/login2';document.f.submit();" />
<input type="button" value="submit3" onclick="javascript:document.f.action='login/login3';document.f.submit();" />
<input type="button" value="submit4" onclick="javascript:document.f.action='login/login4';document.f.submit();" />
</form>
	
</body>
</html>