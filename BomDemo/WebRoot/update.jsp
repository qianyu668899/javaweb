<%@ page language="java" import="java.util.*" pageEncoding="GBK" isELIgnored="false"%>
<%@ page import="org.qianyu.dtree.factory.DAOFactory" %>
<%@ page import="org.qianyu.dtree.pojo.Item"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
       <title>javascript jQuery TreeTable</title>
        <link href="styles.css" rel="stylesheet" type="text/css"/>
  </head>
  
  <body>
   <html:form action="insert.do" method="post">
   <table cellspacing="0" cellpadding="0">
          <tr><td>�������</td><td><html:text property="clevel" value="${item.clevel}"></html:text></td></tr>
          <tr><td>���ڵ�</td><td><html:text property="plevel" value="${item.plevel}"></html:text></td></tr> 
          <tr><td>�ڵ�����</td><td><html:text property="name" value="${item.name}"></html:text></td></tr>
          <tr><td>�ڵ�����</td><td><html:text property="property" value="${item.property}"></html:text></td></tr>
          <tr><td>��ѡ</td><td><input type="radio" name="produce" value="����">
          <input type="radio" name="outsource" value="�⹺">
          <input type="radio" name="outadd" value="��Я"></td></tr>
          <tr><td><html:submit value="�޸�"></html:submit></td><td>  
          <input type="hidden" name="status" value="update">     
          <html:reset value="����"></html:reset></td></tr>
          
   </table>
   </html:form>
  </body>
</html>
