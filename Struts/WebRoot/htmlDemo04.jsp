<%@ page language="java" pageEncoding="GBK"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>   
        <title>htmlDemo01.jsp</title>
  </head>
  
  <body>
  <% 
    Collection col=new ArrayList();
    col.add(new org.apache.struts.util.LabelValueBean("����","bj"));
    col.add(new org.apache.struts.util.LabelValueBean("����","wh"));
    col.add(new org.apache.struts.util.LabelValueBean("����","fz"));
    pageContext.setAttribute("ht",col);
  %>
			<html:form action="demo.do" method="post">
			   ˮ��
			      <html:checkbox property="fruit"  value="orange"/>����
				  <html:checkbox property="fruit" value="apple"/>ƻ��
				  <html:checkbox property="fruit" value="banana"/>�㽶
				  <html:submit value="�ύ"/>
				  <html:reset value="����"/>
			</html:form>
  </body>
</html:html>
