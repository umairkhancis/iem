<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3>Login with Username and Password</h3>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form name='f' action="<c:url value='/j_spring_security_check' />"
		method='POST'>
		
		Username: <input name="j_username" id="username" type="text" required="required" /> <br />
		Password: <input name="j_password" id="password" type="password" />
		<input type="submit" value="login"/>
	</form>
	<a href="signUp.jsp" >Sign Up</a> <br>
	<a href="#" >Forgot your password</a>
</body>
</html>