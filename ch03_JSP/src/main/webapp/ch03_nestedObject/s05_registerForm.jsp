<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[실습]회원가입</title>
<script type="text/javascript">
	window.onload = function() {
		const myForm = document.getElementById("myForm");
		myForm.onsubmit = function() {
			const inputFields = document.querySelectorAll(".input-check");
			for (let i = 0; i < inputFields.length; i++) {
				if (inputFields[i].value.trim() == '') {
					const label = document.querySelector('label[for="'
							+ inputFields[i].id + '"]');
					alert(label.textContent + ' 항목은 필수 입력');
					inputFields[i].value = '';
					inputFields[i].focus();
					return false;
				}

				if (inputFields[i].id == 'id'
						&& !/^[A-Za-z0-9]{4,12}$/.test(inputFields[i].value)) {
					alert('아이디는 영문 또는 숫자 사용, 최소 4자 최대 12자 사용');
					inputFields[i].value = '';
					inputFields[i].focus();
					return false;
				}
			}
		}
	}
</script>
</head>
<body>
	<%--
이름(name),아이디(id),비밀번호(password),전화번호(phone),
취미(hobby) - 영화보기,음악감상,등산,낚시,춤
자기소개(content)

s06_register.jsp로 전송, 전송 방식 post

출력예시
이름: 홍길동
아이디: dragon
비밀번호: 12345
전화번호: 010-1234-5678
취미: 영화보기, 등산
자기소개: 서울에서 태어나서 서울에서 거주

유효성체크
이름, 아이디, 비밀번호는 필수입력
아이디는 영문과 숫자 조합. 4~12자리
비밀번호는 4자리 이상
전화번호는 11자리 숫자로 입력
--%>

	<form action="s06_register.jsp" method="post" id="myForm">
		<label for="name">이름</label> <input type="text" name="name" id="name"
			class="input-check"><br> <label for="id">아이디</label> <input
			type="text" name="id" id="id" class="input-check"><br> <label
			for="password">비밀번호</label> <input type="password" name="password"
			id="password" class="input-check"><br> <label
			for="phone">전화번호</label> <input type="text" name="phone" id="phone"><br>
		취미: <input type="checkbox" name="hobby" value="영화보기" id="cb0">
		<label for="cb0">영화보기</label> <input type="checkbox" name="hobby"
			value="음악감상" id="cb1"> <label for="cb1">음악감상</label> <input
			type="checkbox" name="hobby" value="등산" id="cb2"> <label
			for="cb2">등산</label> <input type="checkbox" name="hobby" value="낚시"
			id="cb3"> <label for="cb3">낚시</label> <input type="checkbox"
			name="hobby" value="춤" id="cb4"> <label for="cb4">춤</label> <br>
		<br> <label for="content">자기소개</label><br>
		<textarea rows="20" cols="60" name="content" id="content"></textarea>
		<br> <input type="submit" value="전송">
	</form>

</body>
</html>