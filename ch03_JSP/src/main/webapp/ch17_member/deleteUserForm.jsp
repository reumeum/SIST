<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Integer user_num = (Integer) session.getAttribute("user_num");
if (user_num == null) { //로그인이 되지 않은 경우
	response.sendRedirect("loginForm.jsp");
} else { //로그인 된 경우
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css">
<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<%
String user_id = (String)session.getAttribute("user_id");
%>
<script type="text/javascript">
$(function() {
	//이벤트 연결
	$('#delete_form').submit(function() {
		if ($('#id').val().trim() == '') {
			alert('아이디를 입력하세요');
			$('#id').val('').focus();
			return false;
		}
		
    		if ($('#id').val() != "<%=user_id%>") {
			alert("입력한 아이디가 유저 아이디와 일치하지 않습니다.");
			$('#id').val('').focus();
			return false;
		} 
		
		if ($('#passwd').val().trim() == '') {
			alert('비밀번호를 입력하세요');
			$('#passwd').val('').focus();
			return false;
		}

		if ($('#cpasswd').val().trim() == '') {
			alert('비밀번호 확인란을 입력하세요');
			$('#cpasswd').val('').focus();
			return false;
		}
		
		//비밀번호와 비밀번호확인 일치 여부 체크
		if ($('#passwd').val() != $('#cpasswd').val()) {
			alert("비밀번호와 비밀번호 확인이 불일치 합니다.");
			$('#cpasswd').val('').focus();
			return false;
		}
		
	}); //end of submit
});
</script>
<title>회원탈퇴</title>
</head>
<body>
<div class="page-main">
	<h1>회원탈퇴</h1>
	<form id="delete_form" action="deleteUser.jsp" method="post">
		<ul>
			<li>
				<label for="id">아이디</label>
				<input type="text" name="id" id="id" maxlength="12">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" maxlength="12">
			</li>
			<li>
				<label for="cpasswd">비밀번호 확인</label>
				<input type="password" id="cpasswd" maxlength="12">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="회원탈퇴">
			<input type="button" value="홈으로" onclick="location.href='main.jsp'">
		</div>
	</form>
</div>
</body>
</html>
<%
}
%>
