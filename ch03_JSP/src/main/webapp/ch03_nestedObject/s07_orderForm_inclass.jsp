<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 구매</title>
<script type="text/javascript">
	window.onload = function() {
		const myForm = document.getElementById("myForm");

		myForm.onsubmit = function() {
			const nameField = document.getElementById("name");
			const orderDateField = document.getElementById("order_date");

			if (nameField.value.trim() == "") {
				const label = document.querySelector('label[for="'
						+ nameField.id + '"]');
				alert(label.textContent + " 항목을 입력해주세요.");
				nameField.value = "";
				nameField.focus();
				return false;
			}

			if (orderDateField.value.trim() == "") {
				const label = document.querySelector('label[for="'
						+ orderDateField.id + '"]');
				alert(label.textContent + " 항목을 입력해주세요.");
				orderDateField.value = "";
				orderDateField.focus();
				return false;
			}

			const items = document.getElementsByName("item");

			let cnt = 0;
			for (let i = 0; i < items.length; i++) {
				if (items[i].checked)
					cnt++;
			}
			if (cnt < 1) {
				alert("상품은 하나 이상 선택해주세요.");
				return false;
			}
		}
	}
</script>
</head>
<body>
	<%--
이름, 배송희망일 필수 입력. 상품은 하나 이상 필수 선택.
[출력 예시]
구매 금액이 30만원 미만이면 배송비 5천원 추가
이름: 홍길동
배송 희망일: 2024-04-23
구입 내용: 가방, 옷
배송비: 5,000원
총 구매비용(배송비 포함): 255,000원 
 --%>
	<form action="s08_order_inclass.jsp" method="post" id="myForm">
		<ul>
			<li><label for="name">이름</label> <input type="text" name="name"
				id="name"></li>
			<li><label for="order_date">배송 희망일</label> <input type="date"
				name="order_date" id="order_date"></li>
			<li><label>상품(30만원 미만 배송비 5천원 추가)</label> <br> <input
				type="checkbox" name="item" value="가방">가방(20만원) <input
				type="checkbox" name="item" value="신발">신발(10만원) <input
				type="checkbox" name="item" value="옷">옷(5만원) <input
				type="checkbox" name="item" value="식사권">식사권(15만원)</li>
		</ul>
		<input type="submit" value="전송">
	</form>
</body>
</html>