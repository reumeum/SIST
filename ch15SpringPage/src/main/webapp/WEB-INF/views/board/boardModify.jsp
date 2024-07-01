<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- 게시판 글수정 시작 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<div class="page-main">
	<h2>글쓰기</h2>
	<form:form action="update" id="board_modify" enctype="multipart/form-data" modelAttribute="boardVO">
		<form:hidden path="board_num"/>
		<ul>
			<li>
				<form:label path="category">분류</form:label>
				<form:select path="category">
					<option disabled="disabled" selected>선택하세요</option>
					<form:option value="1">자바</form:option>
					<form:option value="2">데이터베이스</form:option>
					<form:option value="3">자바스크립트</form:option>
					<form:option value="3">기타</form:option>
				</form:select>
				<form:errors path="category" cssClass="error-color" />
			</li>
			<li>
				<form:label path="title">제목</form:label>
				<form:input path="title"/>
				<form:errors path="title" cssClass="error-color" />
			</li>
			<li>
				<form:label path="content">내용</form:label>
				<form:textarea path="content"/>
				<form:errors path="content" cssClass="error-color" />
			</li>
			<li>
				<form:label path="upload">파일업로드</form:label>
				<input type="file" name="upload" id="upload">
				<c:if test="${!empty boardVO.filename}">
				<div id="file_detail">
					(${boardVO.filename})파일이 등록되어 있습니다.
					<input type="button" value="파일 삭제" id="file_del">
				</div>
				<script type="text/javascript">
					$(function() {
						$('#file_del').click(function() {
							const choice = confirm('삭제하시겠습니까?');
							if (choice) {
								$.ajax({
									url: 'deleteFile',
									data: {board_num:${boardVO.board_num}},
									type: 'post',
									dataType: 'json',
									success: function(param) {
										if (param.result == 'logout') {
											alert('로그인 후 사용하세요');
										} else if (param.result == 'wrongAccess') {
											alert('잘못된 접속입니다.');
										} else if (param.result == 'success') {
											$('#file_detail').hide();
										} else {
											alert('파일 삭제 오류 발생');
										}
									},
									error: function() {
										alert('네트워크 오류 발생');
									}
								});
							}
						});
					});
				</script>
				</c:if>
			</li>
		</ul>
		<div class="align-center">
			<form:button class="default-btn">전송</form:button>
			<input type="button" value="목록" class="default-btn" onclick="location.href='list'">
		</div>
	</form:form>
</div>
<!-- 게시판 글수정 끝 -->