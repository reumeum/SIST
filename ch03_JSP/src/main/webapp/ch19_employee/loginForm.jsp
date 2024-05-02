<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
<script type="text/javascript">
window.onload = function () {
	//필수 입력 체크
	const myForm = document.getElementById("login_form");
	myForm.onsubmit = function() {
		//아이디 입력 체크
		const id = document.getElementById("id");
		if (id.value.trim() == "") {
			alert("아이디를 입력해주세요.");
			id.value="";
			id.focus();
			return false;
		}
		
		//비밀번호 입력 체크
		const passwd = document.getElementById("passwd");
		if (passwd.value.trim() == "") {
			alert("비밀번호를 입력해주세요.");
			passwd.value="";
			passwd.focus();
			return false;
		}
	}
}
</script>
</head>
<body>
	<div class="page-main">
		<h1>로그인</h1>
		<form action="login.jsp" method="post" id="login_form">	
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" id="id" name="id" class="input-check" size="15" maxlength="15">
				</li>
				<li>	
					<label for="passwd">비밀번호</label>
					<input type="password" id="passwd" name="passwd" class="input-check" size="15" maxlength="15">
				</li>
			</ul>
			<div class="align-right">
				<input type="submit" value="로그인">
				<input type="button" value="홈으로" onclick="location.href='main.jsp'">
			</div>
		</form>
	</div>
</body>
</html>