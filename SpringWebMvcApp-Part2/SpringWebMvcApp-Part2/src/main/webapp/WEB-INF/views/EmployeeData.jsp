<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Data</title>
</head>
<body>
	<h1>Welcome to Employee Data Page!!</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>GENDER</th>
			<th>ADDRESS</th>
			<th>LANGUAGES</th>
			<th>ID</th>
			<th>NUMBER</th>

		</tr>
		<c:forEach items="${page.getContent()}" var="e">
			<tr>
				<td><c:out value="${e.empId}" /></td>
				<td><c:out value="${e.empName}" /></td>
				<td><c:out value="${e.empMail}" /></td>
				<td><c:out value="${e.empGen}" /></td>
				<td><c:out value="${e.empAddr}" /></td>
				<td><c:out value="${e.empLangs}" /></td>
				<td><c:out value="${e.empIdType}" /></td>
				<td><c:out value="${e.empIdNum}" /></td>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${!page.isFirst()}">
		<a href="?page=0">First</a>&nbsp;&nbsp;
	</c:if>
	
	<c:if test="${page.hasPrevious()}">
		<a href="?page=${page.getNumber()-1}">Previous</a>&nbsp;&nbsp;
	</c:if>

	<c:forEach begin="0" end="${page.getTotalPages()-1}" var="i">
		<c:choose>
		<c:when test="${page.getNumber() == i }">
			${i+1}&nbsp;&nbsp;
		</c:when>
		<c:otherwise>
			<a href="?page=${i}">${i+1}</a>&nbsp;&nbsp;
		</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${page.hasNext()}">
		<a href="?page=${page.getNumber()+1}">Next</a>&nbsp;&nbsp;
	</c:if>
	
	
	<c:if test="${!page.isLast()}">
		<a href="?page=${page.getTotalPages()-1}">Last</a>&nbsp;&nbsp;
	</c:if>


</body>
</html>

