<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
	<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
    <div class="container">
		
		<h3 class="text-center">Admin Page</h3>
	
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Email</th>
					<th>Name</th>
					<th>Password</th>
					<th>Enabled</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
				<tr>
					<th>${user.userId}</th>
					<th>${user.email}</th>
					<th>${user.name}</th>
					<th>${user.password}</th>
					<th>${user.enabled }</th>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center"><a href="/"><h4>Back</h4></a></div>
	</div>
</body>

</html>