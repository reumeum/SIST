<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO"%>
<%@ page import="kr.employee.vo.EmployeeVO"%>
<%
String id = (String) session.getAttribute("employee_id");
Integer num = (Integer) session.getAttribute("employee_num");

if (num != null) {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>
<%
EmployeeDAO dao = EmployeeDAO.getInstance();
EmployeeVO vo = dao.getEmployee(num);
%>
	<div class="page-main">
		<h1>MyPage</h1>
		<ul>
			<li>
				사원번호 : <%= vo.getNum() %>
			</li>
			<li>
				이름 : <%= vo.getName() %>
			</li>
			<li>
				급여 : <%= String.format("%,d원", vo.getSalary()) %>
			</li>
			<li>
				직무 : <%= vo.getJob() %>
			</li>
			<li>
				등록일자 : <%= vo.getReg_date() %>
			</li>
		</ul>
		<hr size="2" width="100%">
		<div class="align-right">
			<input type="button" value="수정" onclick="location.href='updateForm.jsp'">
			<input type="button" value="삭제" onclick="location.href='delete.jsp'">
			<input type="button" value="홈으로" onclick="location.href='main.jsp'">
		</div>
	</div>
</body>
</html>
<%
} else {
%>
<script type="text/javascript">
	alert("로그인 후 이용해주세요.");
	location.href = "loginForm.jsp";
</script>
<%
}
%>