<%@page import="kr.util.PagingUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO"%>
<%@ page import="kr.story.vo.StoryVO"%>
<%@ page import="java.util.List"%>

<%
String employee_id = (String) session.getAttribute("employee_id");

//선택한 페이지 번호
String pageNum = request.getParameter("pageNum");

if (pageNum == null) {
	pageNum = "1";
}

//한 화면에 몇 개의 글을 보여줄지 지정
int rowCount = 10;
//한 화면에 몇 개의 페이지를 보여줄지 지정
int pageCount = 10;
//현재 선택한 페이지 (String -> int)
int currentPage = Integer.parseInt(pageNum);

StoryDAO dao = StoryDAO.getInstance();
int count = dao.getCount();

PagingUtil util = new PagingUtil(currentPage, count, rowCount, pageCount, "list.jsp");

List<StoryVO> list = null;
if (count > 0) {
	list = dao.getList(util.getStartRow(), util.getEndRow());
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css" type="text/css">
</head>
<body>
	<%
	if (count > 0) {
	%>
	<div class="page-main">
		<div class="align-right">
			<%
			if (employee_id == null) { //로그인이 되지 않은 경우
			%>
			<a href="registerForm.jsp">사원 등록</a> <a href="loginForm.jsp">로그인</a>

			<%
			} else { //로그인이 된 경우
			%>
			<a href="myPage.jsp">MyPage</a> [<b><%=employee_id%></b>님 로그인 중] <a
				href="logout.jsp">로그아웃</a>
			<%
			}
			%>
		</div>
		<h1>게시글 목록</h1>
		<!-- 목록 출력 시작 -->
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<%
			for (StoryVO story : list) {
			%>
			<tr>
				<td><%=story.getSnum()%></td>
				<td><a href="storyDetail.jsp?snum=<%=story.getSnum()%>"><%=story.getTitle()%></a></td>
				<td><%=story.getId()%></td>
				<td><%=story.getReg_date()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<!-- 목록 출력 끝 -->
		<!-- 페이지 표시 시작 -->
		<p>
			<div class="align-center">
			<%=util.getPage()%>
		</div>
		<!--  페이지 표시 끝 -->
		<div class="align-right">
			<p>
				<%
				if (employee_id != null) {
				%>
				<input type="button" value="글 작성"
					onclick="location.href='insertForm.jsp'">
				<%
				}
				%>
				<input type="button" value="홈으로" onclick="location.href='main.jsp'">
		
		</div>
	</div>
<%
} else {
	%>
	<div class="page-main">
	<h1>게시글 목록</h1>
	작성된 글이 없습니다. <p></p>
		<div class="align-right">
			<input type="button" value="글쓰기" onclick="location.href='insertForm.jsp'">
			<input type="button" value="홈으로" onclick="location.href='main.jsp'">
		</div>
	</div>
	<%
}
%>
</body>
</html>