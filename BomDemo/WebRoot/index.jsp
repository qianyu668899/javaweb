<%@ page language="java" import="java.util.*" pageEncoding="GBK" isELIgnored="false"%>
<%@ page import="org.qianyu.dtree.factory.DAOFactory" %>
<%@ page import="org.qianyu.dtree.pojo.Item"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
       <title>����������ԴBOMͼ</title>
       <script type="text/javascript" src="jquery.min.js"></script>
       <script type="text/javascript" src="jquery.treetable.js"></script>
       <link href="styles.css" rel="stylesheet" type="text/css"/>
       <script language="javascript">
              $(document).ready(function(){
                     $.treetable.defaults={
							id_col:0,//ID td�� {��0��ʼ}
							parent_col:1,//��ID td��
							handle_col:2,//���ϲ���չ�������� td��
							open_img:"images/minus.gif",
							close_img:"images/plus.gif"
				     }
	                //$("#tb").treetable({id_col:0,parent_col:1,handle_col:2,open_img:"images/minus.gif",close_img:"images/plus.gif"});
	                //ֻ��Ӧ����tbody
					$("#tb").treetable();
	                //Ӧ����ʽ
					$("#tb tr:even td").addClass("alt");
					$("#tb tr").find("td:eq(2)").addClass("spec");
					$("#tb tr:even").find("td:eq(2)").removeClass().addClass("specalt");
	               //����������
					$("#tb tr").find("td:eq(0)").hide();
					$("#tb tr").find("td:eq(1)").hide();
					$("#mytable tr:eq(0)").find("th:eq(0)").hide();
					$("#mytable tr:eq(0)").find("th:eq(1)").hide();
				});
       </script>
  </head>
  
  <body>
    <div style="float:middle;">
         
  	 	<table   width="970" border="0" align="center" cellspacing="0" cellpadding="0" >
			<caption  align="top">
			         ����������ԴBOM
			</caption>
			<tr>
				 <th><center>����</center></th> 
				 <th>����</th> 
				 <th>����</th> 
				 <th>�⹺</th> 
				 <th>��Э</th>
				 <th colspan="3"><center>����</center></th>
			</tr>
			<tbody id="tb">
			<% 
					List<?> list=DAOFactory.getItemDAOInstance().queryAll();
				    Iterator<?> iter=list.iterator();
				    while(iter.hasNext()){
					  Item dtr=(Item)iter.next();
					  int idc=dtr.getClevel();
					  request.setAttribute("idc",idc);
					  int idp=dtr.getPlevel();
					  String name=dtr.getName();
					  String property=dtr.getProperty();
					  int produce=dtr.getProduce();
					  int outsource=dtr.getOutsource();
					  int outadd=dtr.getOutadd();
			  %>
			  <tr>
			        <td><%=idc%></td>
					<%
				  	    if(idp==100){
				    %>
							   <td></td>
					<%
			            }
						else{
			        %>
			                <td><%=idp%></td>
					<%
					    }	
					%>
			                <td><%=name%></td>
			                <td><%=property%></td>
			        <% 
			           if(produce==1){
			        %>
			           <td><img src="images/plus.gif"/></td>
			           <td></td>
			           <td></td>
			        <% 
			           }
			        %>
			         <% 
			            if(outsource==1){
			        %>
			           <td></td>
			           <td><img src="images/plus.gif"/></td>
			           <td></td>
			        <% 
			           }
			        %>	       
			         <% 
			           if(outadd==1){
			        %>
			           <td></td>
			           <td></td>
			           <td><img src="images/plus.gif"/></td>
			        <% 
			           }
			        %>	        
			          <td><a href="insert.do?clevel=<%=idc%>&status=delete">ɾ��</a></td>
			          <td><a href="insert.do?clevel=<%=idc%>&status=selectid">�޸�</a></td>	
			          <td><a href="insert.do?clevel=<%=idc%>&status=queryid">����</a></td>	                 	       
			   </tr>
			    <%
				   }
			    %>
			</tbody>
		</table>
     </div>
  </body>
</html>
