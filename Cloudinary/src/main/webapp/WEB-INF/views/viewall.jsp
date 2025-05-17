<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Users</title>

<!-- Bootstrap 5.3 CSS CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap Icons CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
	rel="stylesheet">

<style>
body {
	position: relative;
	padding-top: 56px; /* Height of navbar */
}

.sidebar {
	height: calc(100vh - 56px);
	overflow-y: auto;
	position: fixed;
	width: 250px;
}

.main-content {
	margin-left: 250px;
	padding: 20px;
	width: calc(100% - 250px);
}

@media ( max-width : 768px) {
	.sidebar {
		width: 100%;
		position: relative;
		height: auto;
	}
	.main-content {
		margin-left: 0;
		width: 100%;
	}
}

/* Your table styles */
.table-container {
	margin-top: 30px;
}

.table {
	width: 100%;
	margin: 0 auto;
	border-collapse: collapse;
	background-color: white;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.table th, .table td {
	padding: 12px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

.table th {
	background-color: #4CAF50;
	color: white;
}

.table tr:hover {
	background-color: #f1f1f1;
}
</style>
</head>

<script src="${pageContext.request.contextPath}/js/viewinfo.js"></script>
<body>

	<div class="main-content">
		<div class="table-container">
			<a href="/register" class="btn btn-primary mb-3">Back To Register</a>

			<h2 class="my-4">📋 All Users</h2>

			<table class="table table-striped table-hover">
				<thead class="table-primary">
					<tr>
						<th>Name</th>
						<th>Is Human</th>
						<th>Image Link</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}">
						<tr>
							<td>${user.name}</td>
							<td>${user.ishuman}</td>
							<td><a href="${user.publicUserImageId}" target="_blank">View
									Image</a></td>
							<td><a href="#" onclick="showPage(${user.id})"
								class="btn btn-sm btn-info text-white me-1" title="View"> <i
									class="bi bi-eye"></i>
							</a> <a href="/edit/${user.id}"
								class="btn btn-sm btn-warning text-white me-1" title="Edit">
									<i class="bi bi-pencil"></i>
							</a> <a href="/delete/${user.id}" class="btn btn-sm btn-danger"
								title="Delete"
								onclick="return confirm('Are you sure you want to delete this user?');">
									<i class="bi bi-trash"></i>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- Popup container -->
	<div id="popup"
		style="display: none; position: fixed; top: 20%; left: 30%; width: 40%; background: white; padding: 20px; border: 1px solid #ccc; box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); z-index: 1000;">
		<h2>User Details</h2>
		<p>
			<strong>Id:</strong> <span id="userId"></span>
		</p>
		<p>
			<strong>Name:</strong> <span id="userName"></span>
		</p>
		<p>
			<strong>Is Human:</strong> <span id="isHuman"></span>
		</p>
		<img id="userImage" src="" alt="User Image" width="150" height="150"
			style="margin-top: 10px;"><br>
		<br>
		<button onclick="closePopup()">Close</button>
	</div>

</body>
</html>