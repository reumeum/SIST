<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<ul>
		<li>이름: <%=request.getParameter("name")%></li>
		<li>아이디: <%=request.getParameter("id")%></li>
		<li>비밀번호: <%=request.getParameter("password")%></li>
		<li>전화번호: <%=request.getParameter("phone")%></li>

		<%
		String[] hobbies = request.getParameterValues("hobby");
		if (hobbies != null) {
		%>
		<li>취미 : <%
		for (int i = 0; i < hobbies.length; i++) {
			if (i > 0)
				out.print(", ");
		%><%=hobbies[i]%><%
 }
 out.println("</li>");
 }
 %>
		<li>자기소개: <%=request.getParameter("content")%></li>
	</ul>
</body>
</html>