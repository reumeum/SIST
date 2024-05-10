<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
	<div class="page-main">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="content-main">
			<h2>회원가입</h2>
			<form id="register_form" action="registerUserForm.do" method="post">
				<ul>
					<li>
						<label for="id">아이디</label>
						<input type="text" name="id" id="id" maxlength="12" autocomplete="off" class="input-check">
						<input type="button" value="ID 중복 체크" id="id_check">
						<span id="message_id"></span>
						<div class="form-notice">*영문 또는 숫자(4자~12자)</div>
					</li>
					<li>
						<label for="name">이름</label>
						<input type="text" name="name" id="name" maxlength="10" class="input-check">
					</li>
					<li>
						<label for="passwd">비밀번호</label>
						<input type="password" name="passwd" id="passwd" maxlength="12" class="input-check">
					</li>
					<li>
						<label for="phone">전화번호</label>
						<input type="text" name="phone" id="phone" maxlength="15" class="input-check">
					</li>
					<li>
						<label for="email">이메일</label>
						<input type="email" name="email" id="email" maxlength="50" class="input-check">
					</li>
					<li>
						<label for="zipcode">우편번호</label>
						<input type="number" name="zipcode" id="zipcode" maxlength="5" autocomplete="off" class="input-check">
						<input type="button" value="우편번호 찾기" onclick="execDaumPostCode()">
					</li>
					<li>
						<label for="address1">주소</label>
						<input type="text" name="address1" id="address1" maxlength="15" class="input-check">
					</li>
					<li>
						<label for="address2">상세주소</label>
						<input type="text" name="address2" id="address2" maxlength="15" class="input-check">
					</li>
				</ul>
			</form>
		</div>

	</div>
</body>
</html>