<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.util.DBUtil"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	int num = Integer.parseInt(request.getParameter("num"));

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";

	try {
		conn = DBUtil.getConnection();

		sql = "SELECT * FROM product WHERE num=?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			String name = rs.getString("name");
			int price = rs.getInt("price");
			int stock = rs.getInt("stock");
			String origin = rs.getString("origin");
	%>
	<div class="page-main">
		<h2 class="align-center">상품 수정</h2>
		<form id="myForm" action="updateTest.jsp" method="POST">
			<input type="hidden" name="num" value=<%=num%>>

			<ul>
				<li><label for="name">이름</label> <input type="text" name="name"
					id="name" value=<%=name%> size="20" maxlength="10"></li>
				<li><label for="price">가격</label> <input type="number"
					name="price" id="price" value=<%=price%> size="20" maxlength="9"></li>
				<li><label for="stock">개수</label> <input type="number"
					name="stock" id="stock" value=<%=stock%> size="20" maxlength="9"></li>
				<li><label for="origin">원산지</label> <input type="text"
					name="origin" id="origin" value=<%=origin%> size="20"
					maxlength="30"></li>
			</ul>
			<div class="align-right">
				<input type="submit" value="수정">
			</div>
		</form>
	</div>
	<%
	} else {
	%>
	<div class="result-display">
		<div class="align-center">
			상품을 찾을 수 없습니다.
			<p>
				<input type="button" value="상품 등록하기"
					onclick='location.href="insertTestForm.jsp"'> <input
					type="button" value="목록 보기"
					onclick='location.href="selectTest.jsp"'>
		</div>
	</div>
	<%
	}

	} catch (Exception e) {
	%>
	<div class="result-display">
		<div class="align-center">
			오류가 발생했습니다. 다시 시도해주세요.
			<p>
				<input type="button" value="목록 보기"
					onclick='location.href="selectTest.jsp"'>
		</div>
	</div>
	<%
	e.printStackTrace();
	} finally {
	DBUtil.executeClose(rs, pstmt, conn);
	}
	%>
</body>
</html>