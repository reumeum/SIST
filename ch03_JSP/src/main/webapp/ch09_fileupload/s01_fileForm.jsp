<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ch03_JSP/fileUpload" method="POST" enctype="multipart/form-data">
		작성자 <input type="text" name="user"><br>
		제목 <input type="text" name="title"><br>
		파일명 <input type="file" name="uploadFile"><br>
		<input type="submit" value="파일 올리기">
	</form>
</body>
</html>