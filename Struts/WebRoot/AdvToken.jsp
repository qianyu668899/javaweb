<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <title>AdvToken.jsp</title>
  </head>
  <body>
  	<html:form action="note.do" method="post">
  	            ���⣺<html:text property="title" /> <br>
    	 ���ߣ�<html:text property="author" /> <br>
  	            ���ݣ�<br>
  	    <html:textarea property="content"></html:textarea><br>
  	    <html:submit value="�ύ"></html:submit>
  	    <html:reset value="����"></html:reset>
  	</html:form>
  </body>
</html:html>
