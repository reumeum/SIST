<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="../css/style.css" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<body>
	<div class="page-main">
		<h2 class="align-center">상품 등록</h2>
		<form id="myForm" action="insertTest.jsp" method="POST">
			<ul>
				<li>
					<label for="name">이름</label>
					<input type="text" name="name" id="name" size="20" maxlength="10" >
				</li>
				<li>
					<label for="price">가격</label>
					<input type="number" name="price" id="price" size="20" maxlength="9" >
				</li>
				<li>
					<label for="stock">개수</label>
					<input type="number" name="stock" id="stock" size="20" maxlength="9" >
				</li>
				<li>
					<label for="origin">원산지</label>
					<input type="text" name="origin" id="origin" size="20" maxlength="30" >
				</li>
			</ul>
			<div class="align-right">
				<input type="submit" value="전송">
				<input type="button" value="목록" onclick="location.href='selectTest.jsp'">
			</div>
		</form>
	</div>
</body>
</html>