<%@ page language="java" contentType="text/html;
charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=ISO-8859-1">
<title>Know Your Neighbourhood | New Store </title>
</head>
<body>
	<div align="center">
		
		<sec:authorize access="hasRole('ADD_STORE')">
		<h2>New Store</h2>
			<form:form action="save" method="post" modelAttribute="store">
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<table border="0" cellpadding="5">
					<tr>
						<td>Name: </td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td>Phone Number: </td>
						<td><form:input path="phoneNumber" /></td>
					</tr>	
					<tr>
						<td>Localities: </td>
						<td><form:input path="localities" /></td>
					</tr>		
					<tr>
						<td colspan="2"><input type="submit" value="Save"></td>
					</tr>						
				</table>
			</form:form>
		</sec:authorize>
	</div>
</body>
</html>