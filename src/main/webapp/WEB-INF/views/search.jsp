<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Know Your Neighbourhood | Search Result</title>
</head>
<body>
	<div align="center">
		<h2>Search Result</h2>
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Phone Number</th>
				<th>Localities</th>
			</tr>
			<c:forEach items="${result}" var="store">
				<tr>
					<td>${store.storeID}</td>
					<td>${store.name}</td>
					<td>${store.phoneNumber}</td>
					<td>${store.localities}</td>
				</tr>
			</c:forEach>
		</table>
		<button onclick="goBack()">Go Back</button>

		<script>
			function goBack() {
				window.history.back();
			}
		</script>
	</div>
</body>
</html>