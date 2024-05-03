<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO"%>
<%@ page import="kr.story.vo.StoryVO"%>
<%
request.setCharacterEncoding("utf-8");
int snum = Integer.parseInt(request.getParameter("snum"));

StoryDAO dao = StoryDAO.getInstance();
StoryVO story = dao.getStory(snum);

Integer num = (Integer) session.getAttribute("employee_num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 상세</title>
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/style.css" type="text/css">
</head>
<body>
    <div class="page-main">
        <h1><%=story.getTitle()%></h1>
        <ul>
            <li>글번호 : <%=story.getSnum()%></li>
            <li>작성자 : <%=story.getId()%></li>
        </ul>
        <hr size="1" width="100%" noshade="noshade">
        <p>
            <%=story.getContent()%>
        </p>
        <div class="align-right">
            작성일 :
            <%=story.getReg_date()%><p>
                <%
            if (num != null && num.equals(story.getNum())) {
                %>
                <input type="button" value="수정"
                    onclick="location.href='storyUpdateForm.jsp?snum=<%=story.getSnum()%>'">
                <input type="button" value="삭제" onclick="deleteStory()">
                <%
            }
            %>
                <input type="button" value="목록" onclick="location.href='list.jsp?'">
                <input type="button" value="홈으로" onclick="location.href='main.jsp?'">
        </div>
    </div>
    <script>
        function deleteStory() {
            if (confirm("정말로 삭제하시겠습니까?")) {
                location.href='storyDelete.jsp?snum=<%=story.getSnum()%>';
            }
        }
    </script>
</body>
</html>
