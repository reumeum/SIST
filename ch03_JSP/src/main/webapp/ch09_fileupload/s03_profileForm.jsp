<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 사진 업로드 폼</title>
<script type="text/javascript">
window.onload = function () {
	const fileInput = document.getElementbyId("file");
	
	fileInput.onchange = function() {
		const imgPreview = document.getElementByTagName("img");
		imgPreview.src = "../images/"
	}
	
}
</script>
</head>
<body>
	<h2>프로필 사진 업로드하기</h2>
	<img src="../images/face.png" width="200" height="200">
	<form action="/ch03_JSP/profile" method="POST" enctype="multipart/form-data">
		<input type="file" name="file" id="file" accept="image/png, image/jpeg, image/gif">
		<input type="submit" value="전송" id="submit_btn" style="display:none;">
	</form>
</body>
</html>