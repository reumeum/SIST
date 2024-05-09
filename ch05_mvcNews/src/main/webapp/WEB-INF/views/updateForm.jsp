<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뉴스 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript">
window.onload = function() {
    const myForm = document.getElementById("update_form");
    myForm.onsubmit = function() {
    	
        const items = document.querySelectorAll(".input-check");
        
        for (let i=0; i<items.length; i++) {
            if (items[i].value.trim() == "") {
                const label = document.querySelector("label[for='"+ items[i].id +"']");
                alert(label.textContent + " 항목은 필수 입력");
                items[i].value="";
                items[i].focus();
                return false;
            }
        }
    }
    
    //썸네일 변경
    const file = document.querySelector("input[type='file']");
    file.onchange = function(event) {
        const reader = new FileReader();
        
        reader.onload = function(event) {
            const img = document.getElementById("img");
            img.setAttribute('src', this.result);
        };
        
        reader.readAsDataURL(this.files[0]);
    }
}
</script>

</head>
<body>
<div class="page-main">
	<h2>뉴스 수정</h2>
	<form id="update_form" action="update.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="num" value="${vo.num}">
		<ul>
			<li>
				<label for="title">제목</label>
				<input type="text" name="title" id="title"  value="${vo.title}" class="input-check" size="30" maxlength="50">
			</li>
			<li>
				<label for="writer">작성자</label>
				<input type="text" name="writer" id="writer" value="${vo.writer}" class="input-check" size="10" maxlength="10">
			</li>
			<li>
				<label for="passwd">비밀번호</label>
				<input type="password" name="passwd" id="passwd" class="input-check" size="12" maxlength="12">
			</li>
			<li>
				<label for="email">이메일</label>
				<input type="email" name="email" id="email" value="${vo.email}" class="input-check" size="30" maxlength="50">
			</li>
			<li>
				<label for="article">내용</label>
				<textarea rows="5" cols="40" name="article" id="article" class="input-check">${vo.article}</textarea>
			</li>
			<li>
				<label>이미지 미리보기</label>
				<img id="img" alt="기사 이미지" src="${pageContext.request.contextPath}/upload/${vo.filename}" width="200px">
			</li>
			<li>
				<label for="filename">사진 변경</label>
				<input type="file" name="filename" id="filename" accept="image/gif,image/png,image/jpeg">
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="목록" onclick="location.href='list.do'">
		</div>
	</form>
</div>
</body>
</html>