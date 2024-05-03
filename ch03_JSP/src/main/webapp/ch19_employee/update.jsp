<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.employee.dao.EmployeeDAO"%>
<%@ page import="kr.employee.vo.EmployeeVO"%>
<%
request.setCharacterEncoding("utf-8");
Integer num = (Integer) session.getAttribute("employee_num");
if (num != null) {
	EmployeeDAO dao = EmployeeDAO.getInstance();
	EmployeeVO db_vo = dao.getEmployee(num);
	%>
		<jsp:useBean id="employee" class="kr.employee.vo.EmployeeVO" />
		<jsp:setProperty name="employee" property="*" />
	<%
	if (db_vo.getPasswd().equals(employee.getPasswd())) {
		dao.updateEmployee(employee);
		%>
		<script>
			alert('수정이 완료되었습니다.');
			location.href="myPage.jsp";
		</script>
		<%
	} else {
		%>
		<script>
			alert('비밀번호가 올바르지 않습니다.');
			history.go(-1);
		</script>
		<%
	}
} else {
	%>
	<script>
		alert('로그인 후 이용해주세요.');
		location.href="loginForm.jsp";
	</script>
	<%
}
%>

