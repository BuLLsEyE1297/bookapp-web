<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search</title>
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
				<td>${book.author.name } <a href="read.html">READ</a></td>
			</tr>
		</c:forEach>
		<a href="search.html">BACK</a>
	</table>
</body>
</html>