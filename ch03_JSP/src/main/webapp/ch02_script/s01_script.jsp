<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 연습</title>
</head>
<body>
	<h2>배열의 내용 출력 - 선언부, 스크립트릿</h2>
	<%!//선언부 : 변수 선언, 메서드 선언
	String[] str = { "JSP가", "정말", "재미", "있다" };%>

	<table border="">
		<tr>
			<th>배열의 인덱스</th>
			<th>배열의 내용</th>
		</tr>
		<%
		//스크립트릿 : 변수 선언, 연산, 제어문, 출력
		for (int i = 0; i < str.length; i++) {
			out.println("<tr>");
			out.println("<td>" + i + "</td>");
			out.println("<td>" + str[i] + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
	<br>

	<h2>배열의 내용 출력 - 선언부, 스크립트릿, 표현식</h2>
	<table border="1">
		<tr>
			<th>배열의 인덱스</th>
			<th>배열의 내용</th>
		</tr>

		<%
		for (int i = 0; i < str.length; i++) {
		%>
		<tr>
			<!-- 표현식 : 변수의 값 출력, 메서드의 반환값 출력, 연산의 결과 출력 -->
			<%--JSP 주석 : 소스 보기 할 때 보여지지 않음 --%>
			<td><%=i /*여러줄 주석 사용, 한줄 주석은 오류*/ %></td>
			<td><%=str[i]%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>

	<h2>배열의 내용 출력 - 확장 for문 이용</h2>
	<table border="1">
		<tr>
			<th>배열의 내용</th>
		</tr>

		<%
		for (String s : str) {
		%>
		<tr>
			<td><%=s%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>