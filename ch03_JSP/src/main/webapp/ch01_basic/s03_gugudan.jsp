<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 - 5단</title>
</head>
<body>
<p>5단</p>
<p>----------------------<p>

	<% 
	for (int i=1;i<=9;i++) {
		out.println("5 * " + i + " = " + 5*i + "<br>");
	}
	%>
</body>
</html>