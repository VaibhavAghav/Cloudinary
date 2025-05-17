<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
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
</style>
</head>
<body>

	<h1>Register Form</h1>

	<form action="/upload" method="post" enctype="multipart/form-data">

		<!-- Name -->
		<label for="name">Name:</label> <input type="text" name="name"
			id="name" required>

		<!-- Image Upload -->
		<label for="image">Select Image:</label> <input type="file"
			name="photo" id="image" accept="image/*" required>

		<!-- Checkbox -->
		<label for="ishuman">Are you human?</label> <input type="checkbox"
			name="ishuman" id="ishuman" value="true">

		<!-- Submit Button -->
		<input type="submit" value="Upload">

	</form>

	<a href="/all" class="btn btn-primary mb-3">Back To Register</a>


</body>
</html>
