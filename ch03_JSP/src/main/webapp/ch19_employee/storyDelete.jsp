<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO"%>
<%@ page import="kr.story.vo.StoryVO"%>

<%
request.setCharacterEncoding("utf-8");
Integer num = (Integer) session.getAttribute("employee_num");
int snum = Integer.parseInt(request.getParameter("snum"));
StoryDAO dao = StoryDAO.getInstance();
StoryVO db_vo = dao.getStory(snum);

if (num == null) {
%>
<script>
	alert("로그인 후 이용해주세요.");
	location.replace("loginForm.jsp");
</script>
<%
} else if (!num.equals(db_vo.getNum())) {
%>
<script>
	alert("다른 사용자의 글은 삭제할 수 없습니다.");
	history.go(-1);
</script>
<%
} else {
	dao.delete(snum);
%>
<script>
	alert("게시글 삭제 완료");
	location.replace("list.jsp");
</script>
<%
}
%>
