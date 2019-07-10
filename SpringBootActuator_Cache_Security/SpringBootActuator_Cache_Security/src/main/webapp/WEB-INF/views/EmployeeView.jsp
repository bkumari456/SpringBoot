<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Employee View Page!!</h1>
<table border="1">
<tr>
	<td>ID</td>
	<td>${emp.empId}</td>
</tr>
<tr>
	<td>NAME</td>
	<td>${emp.empName}</td>
</tr>
<tr>
	<td>EMAIL</td>
	<td>${emp.empMail}</td>
</tr>
<tr>
	<td>GENDER</td>
	<td>${emp.empGen}</td>
</tr>
<tr>
	<td>ADDRESS</td>
	<td>${emp.empAddr}</td>
</tr>
<tr>
	<td>LANGUAGE</td>
	<td>${emp.empLangs}</td>
</tr>
<tr>
	<td>ID TYPE</td>
	<td>${emp.empIdType}</td>
</tr>
<tr>
	<td>ID NUM</td>
	<td>${emp.empIdNum}</td>
</tr>
</table>
</body>
</html>