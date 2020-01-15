<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加图书页面</title>
</head>
<body>
	<h1>添加图书</h1>
	<form method="post" action="doAdd"><table>
	<tr><td>Isbn号</td><td><input type="text" name="isbn"/></td></tr>
	<tr><td>书名</td><td><input type="text" name="title"/></td></tr>
	<tr><td>封面图像</td><td><input type="text" name="imageFile"/></td></tr>
	<tr><td>版本号</td><td><input type="text" name="editionNumber"/></td></tr>
	<tr><td>出版商ID</td><td><input type="text" name="publisherId"/></td></tr>
	<tr><td>价格</td><td><input type="text" name="price"/></td></tr>
	<tr><td>版权</td><td><input type="text" name="copyright"/></td></tr>
	<tr><td><input type="submit" value="添加"/></td></tr>
	</table>
	</form>
</body>
</html>