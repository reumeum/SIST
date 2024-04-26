<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.util.DBUtil"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정 완료</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");

	int num = Integer.parseInt(request.getParameter("num"));
	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	String origin = request.getParameter("origin");

	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "";

	try {
		conn = DBUtil.getConnection();
		sql = "UPDATE product SET name=?, price=?, stock=?, origin=? WHERE num=?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, price);
		pstmt.setInt(3, stock);
		pstmt.setString(4, origin);
		pstmt.setInt(5, num);

		pstmt.executeUpdate();
	%>
	<div class="result-display">
		<div class="align-center">
			상품 수정이 완료 되었습니다.
			<p>
				<input type="button" value="상품 상세정보"
					onclick='location.href="detailTest.jsp?num=<%=num%>"'>
		</div>
	</div>
	<%
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
	DBUtil.executeClose(null, pstmt, conn);
	}
	%>
</body>
</html>