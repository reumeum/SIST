<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<div class="page-main">
	<h2>${vo.title}</h2>
	<div>번호: ${vo.num}</div>
	<div>작성자: ${vo.writer}</div>
	<div>이메일: ${vo.email}</div>
	<hr width="100%" noshade="noshade" size="1">
	<img alt="기사 이미지" src="${pageContext.request.contextPath}/upload/${vo.filename}" width="100%">
	<p style="white-space:pre-wrap;">${vo.article}</p>
	<hr width="100%" noshade="noshade" size="1">
	<div class="align-right">
		<input type="button" value="수정" onclick="location.href='updateForm.do?num=${vo.num}'">
		<input type="button" value="삭제" onclick="location.href='deleteForm.do?num=${vo.num}'">
		<input type="button" value="기사 목록" onclick="location.href='list.do'">
	</div>
</div>
</body>
</html>