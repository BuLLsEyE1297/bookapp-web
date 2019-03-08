<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="SaveServlet">
		Book Details<br> Id <input type="number" name="id" required><br>
		Name <input type="text" name="name" required><br> Price <input
			type="number" name="price" min='0' required><br> Author : <select
			name="authorId">
			<c:forEach var="author" items="${AUTHOR}">
				<option value="${author.id}">${author.id}${author.name}</option>
			</c:forEach>
		</select>
		<button type="submit">add</button>
		<br> <a href="home.html">BACK</a><br>
	</form>
</body>
</html>