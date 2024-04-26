<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.util.DBUtil"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Date"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
	<div class="page-main">
		<%
		request.setCharacterEncoding("utf-8");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM product ORDER BY num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
		%>
		<h2>상품목록</h2>
		<table>
			<tr>
				<th>상품 번호</th>
				<th>상품명</th>
				<th>가격</th>
				<th>재고</th>
			</tr>
			<%
			do {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
			%>
			<tr>
				<td><%=num%></td>
				<td><a href="detailTest.jsp?num=<%=num%>"><%=name%></a></td>
				<td><%=String.format("%,d원", price)%></td>
				<td><%=stock%>개</td>
			</tr>
			<%
			} while (rs.next());
			%>
		</table>
		<p>

			<div class="align-right"><input type="button" value="상품 등록하기"
				onclick='location.href="insertTestForm.jsp"'></div>
		<%
		} else {
		%>
		<div class="result-display">
			<div class="align-center">
				등록된 상품이 없습니다.
				<p>
					<input type="button" value="상품 등록하기"
						onclick='location.href="insertTestForm.jsp"'>
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
	</div>
</body>
</html>