<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
	<h3>표현언어(EL)의 사용</h3>
	<table border="1" style="width:40%;border-collapse:collapse;text-align:center">
		<tr>
			<th>표현식</th>
			<th>값</th>
		</tr>
		<tr>
			<td>\${2 + 5}</td>
			<td>${2 + 5}</td>
		</tr>
		<tr>
			<td>\${"10" + 5}</td>
			<td>${"10" + 5}</td> <!-- 연결이 아니라 연산이 됨 -->
		</tr>
		<tr>
			<td>\${"10" + "5"}</td>
			<td>${"10" + "5"}</td> <!-- 연결이 아니라 연산이 됨 -->
		</tr>
		<tr>
			<td>\${"십" + "5"}</td>
			<td>에러 발생(EL에서의 +는 연산만)</td> <!-- NumberFormatException -->
		</tr>
		<tr>
			<td>\${4 / 5}</td>
			<td>${4 / 5}</td> <!-- 실수 가능 -->
		</tr>
		<tr>
			<td>\${5 / 0}</td>
			<td>${5 / 0}</td> <!-- Infinity -->
		</tr>
		<tr>
			<td>\${2 += 5}</td>
			<td>${2 += 5}</td> <!-- 문자열로 연결 -->
		</tr>
		<tr>
			<td>\${"한국" += "서울"}</td>
			<td>${"한국" += "서울"}</td> <!-- 문자열로 연결 -->
		</tr>
	</table>
</body>
</html>