<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO"%>
<%@ page import="kr.employee.vo.EmployeeVO"%>
<%
request.setCharacterEncoding("utf-8");

String input_id = request.getParameter("id");
String input_passwd = request.getParameter("passwd");

EmployeeDAO dao = EmployeeDAO.getInstance();
EmployeeVO vo = dao.checkEmployee(input_id);

boolean check = false;
if (vo != null) { //유저 아이디 존재
	check = vo.isCheckedPassword(input_passwd);
}

if (check) {
	session.setAttribute("employee_id", input_id);
	session.setAttribute("employee_num", vo.getNum());
	%>
		<script>
		location.href="main.jsp";
		</script>
	<%
	
} else {
%>
<script type="text/javascript">
	alert("입력 정보를 확인해주세요");
	history.go(-1);
</script>
<%
}
%>
