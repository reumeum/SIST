<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 기본객체 속성 보기</title>
</head>
<body>
	<%
	Enumeration<String> attrEnum = application.getAttributeNames();

	while (attrEnum.hasMoreElements()) {
		String attrName = attrEnum.nextElement();
		Object attrValue = application.getAttribute(attrName);
	%>
	application 속성 :
	<b><%=attrName%></b> = <%=attrValue%><br>
	<%
	}
	%>

</body>
</html>