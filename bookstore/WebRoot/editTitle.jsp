<%@ page language="java" import="bean.*,database.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改图书页面</title>
<% Title titles=(Title)request.getAttribute("titles"); %>
</head>
<body>
	<h1>修改图书</h1>
	<form method="post" action="doEditTitle">
	<table>
		<tr><td>Isbn号</td><td><input type="text" name="isbn" readOnly="true"
		value="<%=titles.getIsbn()%>"/></td></tr>
		<tr><td>书名</td><td><input type="text" name="title" 
		value="<%=titles.getTitle()%>"/></td></tr>
		<tr><td>封面图像文件名称</td><td><input type="text" name="imageFile" 
		value="<%=titles.getImageFile()%>"/></td></tr>
		<tr><td>版本号</td><td><input type="text" name="editionNumber" 
		value="<%=titles.getEditionNumber()%>"/></td></tr>
		<tr><td>出版商</td><td><input type="text" name="publisherId" 
		value="<%=titles.getPublisherId()%>"/></td></tr>
		<tr><td>价格</td><td><input type="text" name="price" 
		value="<%=titles.getPrice()%>"/></td></tr>
		<tr><td>版权</td><td><input type="text" name="copyright" 
		value="<%=titles.getCopyright()%>"/></td></tr>
		<tr><td>书名</td><td><input type="submit" value="修改"/></td></tr>
	</table>
	</form>
</body>
</html>