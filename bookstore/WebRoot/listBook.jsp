<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="bean.*,database.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书列表</title>

<jsp:useBean id="dao" class="database.TitleDaoImpl" scope="request"/>

</head>
<body>
<table bgcolor=lightgrey>
<tr><td>ISBN</td><td>书名</td><td>版本</td><td>发布时间</td><td>价格</td><td>删除</td>
</tr>
<% List list=dao.getTitles(); 
   Title titles=null;
   for(int i=0;i<list.size();i++){
   	titles=(Title)list.get(i);
%>
<tr bgcolor=cyan><td><a href="/bookstore/toEditTitles?isbn=<%=titles.getIsbn() %>"></a>
<td><%=titles.getTitle() %></td>
<td><%=titles.getEditionNumber() %></td>
<td><%=titles.getCopyright() %></td>
<td><%=titles.getPrice() %></td>
<td><a href="/javaEE/doDeleteTitle?isbn=<%=titles.getIsbn()%>">删除</a></td>
</tr>
<% } %>
</table>
<table align="center" bgcolor=lightgrey><tr><td><a href="addTitle.jsp">添加</a></td></tr></table>
</body>
</html>