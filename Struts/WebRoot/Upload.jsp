<%@ page language="java" pageEncoding="GBK"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<html:html lang="true">
  <head>
    <title>Upload.jsp</title>
  </head>
  <body>
	<html:form action="upload.do" method="post" enctype="multipart/form-data">
		�ļ�������<html:text property="name"></html:text><br>
		ѡ���ϴ����ļ���<html:file property="pic"></html:file>
		<html:submit value="�ϴ�"></html:submit>
	    <html:reset value="����"></html:reset>
	</html:form>	
  </body>
</html:html>
