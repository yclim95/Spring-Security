<%@ page language="java" contentType="text/html;
charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<title>Know Your Neighbourhood | View Store </title>
</head>
<body>
	<div align="center">
		<h2>Store Manager</h2>
		<form method="get" action="search">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
		</form>
		<h3>
			<a href="registerStore">New Store</a>
		</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Phone Number</th>
				<th>Localities</th>
			</tr>
			<c:forEach items="${listStore}" var="store">
				<tr>
					<td>${store.storeID}</td>
					<td>${store.name}</td>
					<td>${store.phoneNumber}</td>
					<td>${store.localities}</td>
					<td><a href="edit?id=${store.storeID}">Edit</a> &nbsp;&nbsp;&nbsp;
						<a href="delete?id=${store.storeID}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>