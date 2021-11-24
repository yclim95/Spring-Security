<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Know Your Neighbourhood | Edit Store</title>
</head>
<body>
	<div align="center">
		<h2>Edit Store</h2>
		<form:form action="save" method="post" modelAttribute="store">
			<table border="0" cellpadding="5">
				<tr>
					<td>ID: </td>
					<td>${store.storeID}
						<form:hidden path="storeID"/>
					</td>
				</tr>			
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
	</div>
</body>
</html>