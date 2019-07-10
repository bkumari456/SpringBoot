<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#empName").change(function(){
    	$.ajax({
    		url:'getData',
    		data:{"empName":$("#empName").val()},
    		success:function(resTxt){
    			$("#resultBox").text(resTxt);
    		}
    	});
    });
});
</script>
</head>
<body>
<h1>welcome to JSP Page!!</h1>
<input type="text" id="empName"/>
<span id="resultBox"></span>
</body>
</html>