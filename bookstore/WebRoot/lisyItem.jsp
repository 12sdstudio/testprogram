<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="servlet.*,bean.*,java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <jsp:useBean id="dao" class="servlet.itemDaoImpl" scope="request"></jsp:useBean>
  </head>
  
  <body>
    <table bgcolor=lightgrey>
    <tr><td>Id</td><td>书名</td><td>版本</td><td>发布时间</td><td>价格</td>
    </tr>
    <% List list =dao.getItem();
       item items=null;
       for(int i=0;i<list.size();i++){
         items=(item)list.get(i);
    %>
    	<tr bgcolor=cyan><td><%=items.getItem_id()%></td>
    	<td><%=items.getItem_name() %></td>
    	<td><%=items.getItem_level() %></td>
    	<td><%=items.getItem_number() %></td>
    	<td><%=items.getItem_price() %></td></tr>
    <% } %>
    </table>
  </body>
</html>
