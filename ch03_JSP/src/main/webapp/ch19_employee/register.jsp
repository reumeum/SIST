<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="employee" class="kr.employee.vo.EmployeeVO" />
<jsp:setProperty name="employee" property="*" />
<%
	EmployeeDAO dao = EmployeeDAO.getInstance();
	dao.insertEmployee(employee);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 등록</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>
	<div class="page-main">
		<h1>사원 등록 완료</h1>
		<div class="result-display">
			<div class="align-center">
				사원 등록 성공!<p></p>
				<button onclick="location.href='main.jsp'">홈으로</button>
			</div>
		</div>
	</div>
</body>
</html>