<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="story" class="kr.story.vo.StoryVO" />
<jsp:setProperty name="story" property="*" />
<%
Integer num = (Integer) session.getAttribute("employee_num");

if (num == null) {
%>
<script>
	alert("로그인 후 이용해주세요.");
	location.replace("longinForm.jsp");
</script>
<%
}
story.setIp(request.getRemoteAddr());
StoryDAO dao = StoryDAO.getInstance();
System.out.println(story.getSnum());
dao.insert(story);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css">
</head>
<body>
	<div class="page-main">
		<h1>게시글 등록 완료</h1>
		<div class="result-display">
			<div class="align-center">
				게시글 등록 성공!
				<p></p>
				<button onclick="location.replace('list.jsp')">글목록</button>
			</div>
		</div>
	</div>
</body>
</html>