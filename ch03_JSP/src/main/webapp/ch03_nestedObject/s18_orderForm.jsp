<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식 주문</title>
<script type="text/javascript">
/*
수량을 입력, 세가지 음식 중에서 하나는 꼭 주문
-> 각각의 수량이 0 이상
   세개의 수량을 더했을 때 1 이상 
[출력 예시]
짜장면 2개
짬뽕 1개
총 지불금액 : 13,000원

짜장면 4,000원
짬뽕 5,000원
볶음밥 6,000원
 */
 
 window.onload = function() {
	const myForm = document.getElementById("myForm");
	
	myForm.onsubmit = function() {
		const menus = document.querySelectorAll('input[type="number"]');
		
		let cnt = 0;
		for (let i=0; i < menus.length; i++) {
			cnt += menus[i].value;
		}
		
		if (cnt <= 0) {
			alert('음식의 개수를 1개 이상 입력해주세요');
			return false;
		}
	}
}
</script>
</head>
<body>
	<form action="s19_order.jsp" method="post" id="myForm">
		<table border="1">
			<tr>
				<td class="title">식사류</td>
				<td>
					<ul>
						<li>
							<label for="c0">짜장면</label>
							<input type="number" name="food_c0" id="c0" min="0" max="99" value="0">
						</li>
						<li>
							<label for="c1">짬뽕</label>
							<input type="number" name="food_c1" id="c1" min="0" max="99" value="0">
						</li>
						<li>
							<label for="c2">볶음밥</label>
							<input type="number" name="food_c2" id="c2" min="0" max="99" value="0">
						</li>
					</ul>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>