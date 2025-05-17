<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f5f5f5;
	padding: 40px;
}

h1 {
	text-align: center;
	color: #333;
}

form {
	width: 350px;
	margin: 0 auto;
	padding: 20px;
	background: #fff;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	margin-top: 10px;
	font-weight: bold;
	color: #555;
}

input[type="text"], input[type="file"] {
	width: 100%;
	padding: 8px;
	margin-top: 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="checkbox"] {
	margin-top: 8px;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background: #007bff;
	color: #fff;
	border: none;
	margin-top: 20px;
	border-radius: 5px;
	cursor: pointer;
	transition: background 0.3s ease;
}

input[type="submit"]:hover {
	background: #0056b3;
}

img {
	display: block;
	margin-top: 10px;
	border-radius: 6px;
}
</style>
</head>
<body>

	<h1>Update User</h1>

	<form action="/update" method="post" enctype="multipart/form-data">

		<!-- Hidden Fields -->
		<input type="hidden" name="id" value="${user.id}" /> <input
			type="hidden" name="existingPublicId"
			value="${user.publicUserImageId}" /> <input type="hidden"
			name="existingSecureUrl" value="${user.userImageId}" />

		<!-- Name -->
		<label for="name">Name:</label> <input type="text" name="name"
			id="name" value="${user.name}" required />

		<!-- Existing Image Preview -->
		<c:if test="${not empty user.publicUserImageId}">
			<label>Current Image:</label>
			<img src="${user.publicUserImageId}" alt="User Image" width="200px"
				height="200px" />
		</c:if>

		<!-- New Image Upload -->
		<label for="image">Select New Image (leave empty to keep
			current):</label> <input type="file" name="photo" id="image" accept="image/*" />

		<!-- Checkbox -->
		<label for="ishuman">Are you human?</label> <input type="checkbox"
			name="ishuman" id="ishuman" value="true"
			<c:if test="${user.ishuman}">checked</c:if> />

		<!-- Submit -->
		<input type="submit" value="Update" />

	</form>

	<br />
	<a href="/all">← Back to List</a>

</body>
</html>
