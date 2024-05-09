<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${check}">
	<script type="text/javascript">
		alert("기사가 삭제되었습니다.");
		location.href="list.do";
	</script>
</c:if>
<c:if test="${!check}">
	<script type="text/javascript">
		alert("비밀번호가 일치하지 않습니다.");
		history.go(-1);
	</script>
</c:if>