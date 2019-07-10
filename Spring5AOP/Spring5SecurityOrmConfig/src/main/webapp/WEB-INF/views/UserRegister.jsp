<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Register Page</h1>
<form:form action="save" method="post" modelAttribute="user">
<pre>
Name 	: <form:input path="userName" required="required"/>
Email	: <form:input path="userEmail" required="required"/>
Password: <form:password path="userPwd" required="required"/> 
Roles   : <form:checkbox path="roles" value="ADMIN"/>ADMIN
          <form:checkbox path="roles" value="EMP"/>EMPLOYEE
<input type="submit" value="Create User"/>
</pre>
</form:form>
${message}
</body>
</html>