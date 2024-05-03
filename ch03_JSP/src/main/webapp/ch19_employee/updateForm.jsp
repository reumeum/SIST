<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO"%>
<%@ page import="kr.employee.vo.EmployeeVO"%>
<%
Integer num = (Integer) session.getAttribute("employee_num");
String id = (String) session.getAttribute("employee_id");

if (num != null) {
	EmployeeDAO dao = EmployeeDAO.getInstance();
	EmployeeVO vo = dao.getEmployee(num);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 수정</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css">
</head>
<body>
	<div class="page-main">
		<h1>사원정보 수정</h1>
		<form action="update.jsp" method="post" id="update_form">
			<input type="hidden" name="num" value="<%=num%>">
			<input type="hidden" name="id" value="<%=id%>">
			<ul>
				<li><label for="name">이름</label> <input type="text" name="name"
					id="name" class="input-check" maxlength="10" value="<%=vo.getName()%>"></li>
				<li><label for="passwd">비밀번호</label> <input type="password"
					name="passwd" id="passwd" class="input-check" maxlength="12">
				</li>
				<li><label for="salary">급여</label> <input type="number"
					name="salary" id="salary" class="input-check" maxlength="50" value="<%=vo.getSalary()%>">
				</li>
				<li><label for="job">직무</label> <input type="text" name="job"
					id="job" class="input-check" maxlength="15" value="<%=vo.getJob()%>"></li>
			</ul>
			<div class="align-center">
				<input type="submit" value="등록"> <input type="button"
					value="홈으로" onclick="location.href='main.jsp'">
			</div>
		</form>
	</div>
</body>
</html>
<%
} else {
%>
<script type="text/javascript">
	alert("로그인 후 이용해주세요.");
	location.href = "login.jsp";
</script>
<%
}
%>