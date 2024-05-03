<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 관리 메인</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>
<%
String employee_id = (String) session.getAttribute("employee_id");
%>
<div class="page-main">
	<h1>사원관리 메인</h1>
	<div class="align-right">
	<a href="list.jsp">사원이야기</a>
	<%
	if (employee_id == null) { //로그인이 되지 않은 경우
	%>
		<a href="registerForm.jsp">사원 등록</a>
		<a href="loginForm.jsp">로그인</a>
	
	<%
	} else { //로그인이 된 경우
	%>
		<a href="myPage.jsp">MyPage</a>
		[<b><%= employee_id %></b>님 로그인 중]
		<a href="logout.jsp">로그아웃</a>
	<%
	}
	%>
	</div>
</div>
</body>
</html>