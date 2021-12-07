<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Know Your Neighbourhood | Login</title>
</head>
<body>
	<div align="center">
		<h2>Login</h2>
    <c:if test="${error_string != null}">
        <p>
            <span> ${error_string} </span>
        </p>
    </c:if>

    <c:url var="post_url" value="/login"/>
	    <form action="${post_url}" method="post">
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <p>
	      <label for="username">User:</label>
	      <input type="text" name="username" id="username" value=""></input>
	    </p>
	    <p>
	      <label for="password">Password:</label>
	      <input type="text" name="password" id="password" value=""></input>
	    </p>
	      <input type="submit" name="Login" value="Login"></input>
	    </form>
	</div>
</body>
</html>