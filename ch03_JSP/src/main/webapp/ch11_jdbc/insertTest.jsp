<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.util.DBUtil"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
</head>
<body>
	<%
	//POST 메서드 인코딩 타입 지정
	request.setCharacterEncoding("utf-8");

	//입력값 받아오기
	String name = request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	String origin = request.getParameter("origin");

	Connection conn = null;
	PreparedStatement pstmt = null;
	String sql = "";

	try {
		//1,2단계
		conn = DBUtil.getConnection();

		sql = "INSERT INTO product(num,name,price,stock,origin,reg_date) VALUES(product_seq.nextval,?,?,?,?,SYSDATE)";

		//3단계
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, price);
		pstmt.setInt(3, stock);
		pstmt.setString(4, origin);

		//4단계
		pstmt.executeUpdate();
	%>
	<div class="result-display">
		<div class="align-center">
			상품 등록 완료!
			<p>
				<input type="button" value="목록"
					onclick="location.href='selectTest.jsp'">
		</div>
	</div>
	<%
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	DBUtil.executeClose(null, pstmt, conn);
	}
	%>
</body>
</html>