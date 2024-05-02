<%@page import="javax.script.ScriptContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO"%>
<%@ page import="kr.employee.vo.EmployeeVO"%>
<%
Integer num = (Integer) session.getAttribute("employee_num");

EmployeeDAO dao = EmployeeDAO.getInstance();
if (num != null) {
	dao.deleteEmployee(num);
	session.invalidate();
%>
<script>
	alert("사원 정보를 삭제합니다.");
	location.replace("main.jsp");
</script>
<%
} else {
%>
<script>
	alert("로그인 후 이용해주세요.");
	location.href = "loginForm.jsp";
</script>
<%
}
%>