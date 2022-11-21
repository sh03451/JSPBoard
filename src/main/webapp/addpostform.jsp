<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Add New Book</h1>
<form action="addpost.jsp" method="post">
<table>
<tr><td>Title:</td><td><input type="text" name="title"/></td></tr>
<tr><td>Author:</td><td><input type="text" name="author"/></td></tr>
<tr><td>Category:</td><td><textarea cols="50" rows="5" name="category"></textarea></td></tr>
    <tr><td>Publisher:</td><td><input type="text" name="publisher"/></td></tr>
    <tr><td>Price:</td><td><input type="text" name="price"/></td></tr>
<tr><td><a href="posts.jsp">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>

</body>
</html>