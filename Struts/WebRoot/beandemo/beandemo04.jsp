<%@ page language="java" pageEncoding="GBK" isELIgnored="false"%>
<%@page import="java.util.*"%>
<%@page import="org.qianyu.tag.SimpleBean"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
        <title>beandemo04.jsp</title>
  </head>
  
  <body>
   		<%
			SimpleBean sb=new SimpleBean();
			sb.setName("Ǯ��");
			sb.setPassword("123456");
			request.setAttribute("sim",sb);
		%>
		     <h1>ʹ��bean:write��ǩ</h1>
		     <h2>�����ǣ�<bean:write name="sim"  property="name" scope="request"></bean:write></h2>
			 <h2>�����ǣ�<bean:write name="sim"  property="password" scope="request"></bean:write></h2>
			 <h1>ʹ��EL</h1>
			 <h2>�����ǣ�${sim.name}</h2>
			 <h2>�����ǣ�${sim.password}</h2>
  </body>
</html:html>
