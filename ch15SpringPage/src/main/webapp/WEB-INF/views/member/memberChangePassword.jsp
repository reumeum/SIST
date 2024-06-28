<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- 비밀번호 변경 시작 -->
<div class="page-main">
	<h2>비밀번호 변경</h2>
	<form:form action="changePassword" id="member_change" modelAttribute="memberVO">
		<!-- 아이디 또는 비밀번호가 불일치 할 때 : 필드가 없는 에러메세지 -->
		<form:errors element="div" cssClass="error-color" />
		<ul>
			<li>
				<form:label path="now_passwd">현재 비밀번호</form:label>
				<form:password path="now_passwd"/>
				<form:errors path="now_passwd" cssClass="error-color" />
			</li>
			<li>
				<form:label path="passwd">새 비밀번호</form:label>
				<form:password path="passwd" />
				<form:errors path="passwd" cssClass="error-color" />
			</li>
			<li>
				<label for="confirm_passwd">새 비밀번호 확인</label>
				<input type="password" id="confirm_passwd">
				<span id="message_password"></span>
			</li>
			<li>
				<div id="captcha_div">
					<img src="getCaptcha" id="captcha_img" width="200" height="90">
				</div>
				<input type="button" value="새로고침" id="reload_btn">
				<script>
					$(function() {
						$('#reload_btn').click(function() {
							$.ajax({
								url: '${pageContext.request.contextPath}/member/getCaptcha',
								type: 'get',
								success: function() {
									$('#captcha_div').load(location.href+' #captcha_div');
								},
								error: function() {
									alert('네트워크 오류 발생');
								}
							});
						});
					});
				</script>
			</li>
			<li>
				<form:label path="captcha_chars">캡챠 문자 확인</form:label>
				<form:input path="captcha_chars" />
				<form:errors path="captcha_chars" cssClass="error-color" />
			</li>
		</ul>
		<div class="align-center">
			<form:button>전송</form:button>
			<input type="button" value="MY페이지" onclick="location.href='myPage'">
		</div>
	</form:form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/member.password.js"></script>
	<p class="align-center">
		<input type="button" value="홈으로" class="default-btn" onclick="location.href='${pageContext.request.contextPath}/main/main'">
		<input type="button" value="비밀번호찾기" class="default-btn" onclick="location.href='sendPassword'">
	</p>
</div>
<!-- 비밀번호 변경 끝 -->