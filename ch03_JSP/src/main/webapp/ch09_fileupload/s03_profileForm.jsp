<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 사진 업로드 폼</title>
<script type="text/javascript">
window.onload = function() {
    const image = document.getElementById("image");
    const submit_btn = document.getElementById("submit_btn");

    const file = document.getElementById("file");
    file.onchange = function() {
        if (!file.files[0]) {
            image.src = "../images/face.png";
            submit_btn.style.display = "none";
            return;
        }
        
        // 선택한 파일이 있는 경우에만 실행
        const reader = new FileReader();
        reader.readAsDataURL(file.files[0]);

        reader.onload = function() {
            image.src = reader.result;
            submit_btn.style.display = '';
        }
    }
}

</script>
</head>
<body>
	<h2>프로필 사진 업로드하기</h2>
	<img id="image" src="../images/face.png" width="200" height="200" >
	<form action="/ch03_JSP/profile" method="POST"
		enctype="multipart/form-data">
		<input type="file" name="file" id="file"
			accept="image/png, image/jpeg, image/gif"> <input
			type="submit" value="전송" id="submit_btn" style="display: none;">
	</form>
</body>
</html>
