<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Know Your Neighbourhood | Password Generate</title>
</head>
<body>

		<h2>Password Generate by Password Encoder</h2>
    <c:if test="${encodePwd != null}">
        <p>
            <span> ${encodePwd} </span>
        </p>
    </c:if>
    
      

</body>
</html>