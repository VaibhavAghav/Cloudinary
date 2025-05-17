<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Users</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	padding: 20px;
}

h1 {
	text-align: center;
	color: #333;
}

a {
	display: inline-block;
	margin-bottom: 20px;
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	text-decoration: none;
	border-radius: 4px;
}

a:hover {
	background-color: #45a049;
}

table {
	width: 80%;
	margin: 0 auto;
	border-collapse: collapse;
	background-color: white;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:hover {
	background-color: #f1f1f1;
}

td a {
	color: #2196F3;
	text-decoration: none;
}

td a:hover {
	text-decoration: underline;
}
</style>

</head>
<body>

	<a href="/register">Back To Register</a>

	<h1>All Users</h1>

	<table>
		<tr>
			<th>Name</th>
			<th>Is Human</th>
			<th>Image Link</th>
		</tr>

		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.name}</td>
				<td>${user.ishuman}</td>
				<td><a href="${user.publicUserImageId}" target="_blank">View
						Image</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
