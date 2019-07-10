<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Register Page!!</title>
</head>
<body>
<h1>Welcome to Employee</h1>
<form:form action="insert" method="post" modelAttribute="employee">
<pre>
Name  : <form:input path="empName"/>
<form:errors path="empName"/>
Email : <form:input path="empMail"/>
<form:errors path="empMail"/>
Gender: <form:radiobutton path="empGen" value="Male"/>Male <form:radiobutton path="empGen" value="Female"/>Female
<form:errors path="empGen"/>
Address: <form:textarea path="empAddr"/>
<form:errors path="empAddr"/>
Langs : <form:checkbox path="empLangs" value="ENG"/>ENG
	    <form:checkbox path="empLangs" value="HIN"/>HIN
	    <form:checkbox path="empLangs" value="TEL"/>TEL
<form:errors path="empLangs"/>
ID    : <form:select path="empIdType">
			<form:option value="">--select--</form:option>
			<form:option value="AADHAR">AADHAR</form:option>
			<form:option value="VOTER ID">VOTER ID</form:option>
			<form:option value="PAN CARD">PAN CARD</form:option>
			<form:option value="OTHER">OTHER</form:option>
		</form:select>
<form:errors path="empIdType"/>
ID NUM: <form:input path="empIdNum"/>
<form:errors path="empIdNum"/>
<input type="submit" value="Register"/>			    
</pre>
</form:form>
${message}
</body>
</html>


