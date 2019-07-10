<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>
<form name="f" action="../login" method="post">
<pre>
User Id  : <input type="text" id="username" name="username"/>        
Password : <input type="password" id="password" name="password"/>    
<input type="submit" value="Login"/>
</pre>               
</form>
<c:if test="${param.error}">Invalid username and password.</c:if>
<c:if test="${param.logout}">You have been logged out.</c:if>
<a href="reg">Register New User</a>
</body>
</html>