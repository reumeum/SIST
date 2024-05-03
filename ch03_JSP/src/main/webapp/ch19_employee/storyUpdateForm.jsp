<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO"%>
<%@ page import="kr.story.vo.StoryVO"%>
<%
request.setCharacterEncoding("utf-8");
Integer num = (Integer) session.getAttribute("employee_num");
if (num == null) {
%>
<script type="text/javascript">
	alert("로그인 후 이용해주세요.");
	location.replace("loginForm.jsp");
</script>
<%
}

int snum = Integer.parseInt(request.getParameter("snum"));

StoryDAO dao = StoryDAO.getInstance();
StoryVO db_vo = dao.getStory(snum);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<script type="text/javascript">
	window.onload = function() {
		const myForm = document.getElementById("update_form");

		myForm.onsubmit = function() {
			const inputFields = document.querySelectorAll(".input-check");

			for (let i = 0; i < inputFields.length; i++) {
				if (inputFields[i].value.trim() == "") {
					const label = document.querySelector("label[for='"
							+ inputFields[i].id + "']");
					alert(label.textContent + ' 항목을 입력해주세요.');
					inputFields[i].value = "";
					inputFields[i].focus();
					return false;
				}
			}
		}
	}
</script>
</head>
<body>
	<div class="story-main">
		<h1>게시글 수정</h1>
		<form action="storyUpdate.jsp" method="post" id="update_form">
			<input type="hidden" name="num" value="<%=num%>"> <input
				type="hidden" name="snum" value="<%=db_vo.getSnum()%>">
			<ul>
				<li><label for="title">제목</label> <input type="text"
					name="title" id="title" class="input-check"
					value="<%=db_vo.getTitle()%>" maxlength="150"></li>
				<li><label for="content">내용</label> <textarea name="content"
						id="content" class="input-check" rows="30"><%=db_vo.getContent()%></textarea></li>
			</ul>
			<div class="align-center">
				<input type="submit" value="수정"> <input type="button"
					value="취소" onclick="location.href='list.jsp'">
			</div>
		</form>
	</div>
</body>
</html>