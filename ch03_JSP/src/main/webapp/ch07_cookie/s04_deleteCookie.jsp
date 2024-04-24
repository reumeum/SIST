<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제</title>
</head>
<body>
	<%
	//클라이언트로부터 전송된 쿠키 정보를 반환
	Cookie[] cookies = request.getCookies();
	if (cookies != null || cookies.length > 0) {
		for (int i=0; i < cookies.length; i++) {
			//name 이라는 쿠키명을 사용하는 쿠키가 존재하는지 검색
			if(cookies[i].getName().equals("name")) {
				//name 쿠키명으로 쿠키 생성
				//어차피 삭제될 것이기 때문에 빈 문자열 대입
				Cookie cookie = new Cookie("name", "");
				cookie.setMaxAge(0); //쿠키 유효시간이 바로 만료됨
				
				//생성된 쿠키를 클라이언트에 전송
				response.addCookie(cookie);
				
				out.println("name 쿠키를 삭제합니다.");
			}
		}
	} else {
		out.println("쿠키가 존재하지 않습니다.");
	}
%>
</body>
</html>