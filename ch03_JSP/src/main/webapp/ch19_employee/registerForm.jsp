<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 등록</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css" type="text/css">
<script src="<%=request.getContextPath() %>/js/jquery-3.7.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	//아이디 중복 체크 결과 -> 0: 중복 체크 미실시(아이디 중복), 1: 아이디 미중복
	let count = 0;
	
    $('#register_form').submit(function() {
    	const inputFields = document.querySelectorAll('.input-check');
    	
    	for (let i=0; i < inputFields.length; i++) {
    		if (inputFields[i].value.trim() == '') {
    			const label = document.querySelector("label[for='" + inputFields[i].id + "']");
    			alert(label.textContent + " 항목은 필수 입력");
    			inputFields[i].value = "";
    			inputFields[i].focus();
    			return false;
    		}
    		
        	if (count==0 && inputFields[i].id == 'id') {
        		alert("아이디 중복 체크 필수");
        		inputFields[i].focus();
        		return false;
        	}
    	}
    });
    
    $('#confirm_id').click(function() {
		//서버와 통신
		$.ajax({
			url: 'confirmId.jsp',
			type: 'post',
			data: {id:$('#id').val()},
			dataType: 'json',
			success: function(param) {
				if(param.result == 'idDuplicated') {
					count = 0;
					$('#id_signed').text('아이디 중복').css('color','red');
					$('#id').val('').focus();
				} else if(param.result =='idNotFound') {
					count = 1;
					$('#id_signed').text('사용 가능 아이디').css('color', 'black');
				} else {
					count = 0;
					alert('id 중복체크 오류');
				}
			},
			error: function() {
				count=0;
				alert('네트워크 오류 발생');
			}
		});
    });
    
    //아이디 중복체크 이후 다시 입력하면 알림 사라지게
    $("#id").keydown(function() {
    	count = 0;
    	$("#id_signed").text("");
    })
    
});
</script>
</head>
<body>
	<div class="page-main">
		<h1>사원 등록</h1>
		<form action="register.jsp" method="post" id="register_form">
			<ul>
				<li>
					<label for="id">아이디</label>
					<input type="text" name="id" id="id" size="7" maxlength="12" autocomplete="off" class="input-check">
					<input type="button" id="confirm_id" value="ID 중복확인">
					<span id="id_signed"></span>
				</li>
				<li>
					<label for="name">이름</label>
					<input type="text" name="name" id="name" class="input-check" maxlength="10">
				</li>
				<li>
					<label for="passwd">비밀번호</label>
					<input type="password" name="passwd" id="passwd" class="input-check" maxlength="12">
				</li>
				<li>
					<label for="salary">급여</label>
					<input type="number" name="salary" id="salary" class="input-check" maxlength="50">
				</li>
				<li>
					<label for="job">직무</label>
					<input type="text" name="job" id="job"  class="input-check" maxlength="15">
				</li>
			</ul>
			<div class="align-center">
				<input type="submit" value="등록">
				<input type="button" value="홈으로" onclick="location.href='main.jsp'">
			</div>
		</form>
	</div>
</body>
</html>