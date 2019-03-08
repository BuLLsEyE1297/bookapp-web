<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Price</td>
			<td>Author</td>
		</tr>
		<c:forEach var="book" items="${BOOKS }">
			<tr>
				<td>${book.id }</td>
				<td>${book.name }</td>
				<td>${book.price }</td>
				<td>${book.author.name } <a href="read1.html">READ</a></td>
			</tr>
		</c:forEach>
		<a href="search.html">BACK</a>
	</table>
</body>
</html>