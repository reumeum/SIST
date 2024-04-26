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
<title>상품 상세정보</title>
<%
request.setCharacterEncoding("utf-8");
int num = Integer.parseInt(request.getParameter("num"));
%>
<script type="text/javascript">
window.onload = function() {
	const delete_btn = document.getElementById("delete_btn");

	delete_btn.onclick = function() {
		if (confirm("삭제 하시겠습니까?")) {
			location.replace('deleteTest.jsp?num=<%=num%>');
		}
	}
}
</script>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
	<div class="page-main">
		<%
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
				Date reg_date = rs.getDate("reg_date");
		%>
		<h2><%=name%></h2>
		<hr width="100%">
		상품 번호 :
		<%=num%><br> 가격 :
		<%=String.format("%,d", price)%><br> 재고 :
		<%=stock%><br> 제조국 :
		<%=origin%><br> 등록일자 :
		<%=reg_date%><br>
		<hr width="100%">
		<div class="align-right">
			<input type="button" value="수정"
				onclick='location.href="updateTestForm.jsp?num=<%=num%>"'> <input
				type="button" value="삭제" id="delete_btn"> <input
				type="button" value="목록 보기" onclick='location.href="selectTest.jsp"'>
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
					<input type="button" value="상품 수정 폼"
						onclick='location.href="updateTest.jsp?num=<%=num%>"'>
			</div>
		</div>
		<%
		} finally {
		DBUtil.executeClose(rs, pstmt, conn);
		}
		%>
	</div>
</body>
</html>