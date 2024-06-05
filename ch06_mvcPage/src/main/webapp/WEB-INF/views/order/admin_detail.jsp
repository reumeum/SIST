<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 상세(관리자 전용)</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
window.onload = function() {
    // 상품 구매 유효성 체크
    const myForm = document.getElementById('order_form');
    myForm.onsubmit = function() {
        const items = document.querySelectorAll('input[type="text"]');
        for (let i = 0; i < items.length; i++) {
            if (items[i].value.trim() == '') {
                const label = document.querySelector('label[for="'+ items[i].id +'"]');
                alert(label.textContent + ' 항목은 필수 입력');
                items[i].value = '';
                items[i].focus();
                return false;
            }

            if (items[i].id == 'zipcode' && !/^[0-9]{5}$/.test(items[i].value)) {
                alert('우편번호를 입력하세요(숫자 5자리)');
                items[i].value = '';
                items[i].focus();
                return false;
            }
        }

        // 결제수단 유효성 체크
        const radio = document.querySelectorAll('input[type="radio"]:checked');
        if (radio.length < 1) {
            alert('결제수단을 선택하세요!');
            return false;
        }

    }
};
</script>
</head>
<body>
	<div class="page-main">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="content-main">
			<h2>구매 상세(관리자전용)</h2>
			<table>
				<tr>
					<th>상품명</th>
					<th>수량</th>
					<th>상품가격</th>
					<th>합계</th>
				</tr>
				<c:forEach var="detail" items="${detailList}">
					<tr>
						<td>${detail.item_name}</td>
						<td class="align-center"><fmt:formatNumber
								value="${detail.order_quantity}" /></td>
						<td class="align-center"><fmt:formatNumber
								value="${detail.item_price}" />원</td>
						<td class="align-center"><fmt:formatNumber
								value="${detail.item_total}" />원 <br>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3" class="align-right"><b>총구매금액</b></td>
					<td class="align-center"><fmt:formatNumber
							value="${order.order_total}" />원</td>
				</tr>
			</table>
			<ul>
				<li>
					<span for="receive_name">받는 사람</span> ${order.receive_name}
				</li>
				<li>
					<span for="zipcode">우편번호</span> ${order.receive_post}
				</li>
				<li>
					<span for="address1">주소</span> ${order.receive_address1} ${order.receive_address2}
				</li>
				<li>
					<span for="receive_phone">전화번호</span> ${order.receive_phone}
				</li>
				<li>
					<span>결제수단</span>
					<c:if test="${order.payment == 1}">통장입금</c:if>
					<c:if test="${order.payment == 2}">카드결제</c:if>
				</li>
				<li>
					<span>배송상태</span>
					<c:if test="${order.status == 1}">배송대기</c:if>
					<c:if test="${order.status == 2}">배송준비중</c:if>
					<c:if test="${order.status == 3}">배송중</c:if>
					<c:if test="${order.status == 4}">배송완료</c:if>
					<c:if test="${order.status == 5}">주문취소</c:if>
				</li>
				<li>
					<c:if test="${order.status == 1}">
					<input type="button" value="배송지정보수정" onclick="location.href=
											'modifyForm.do?order_num=${order.order_num}'">
					</c:if>
					<c:if test="${order.status != 5}">
					<input type="button" value="배송상태수정" onclick="location.href=
											'modifyStatusForm.do?order_num=${order.order_num}'">
					</c:if>
					<c:if test="${order.status == 4 or order.status == 5}">
					<input type="button" value="삭제" onclick="location.href=
											'deleteOrder.do?order_num=${order.order_num}'">
					</c:if>
					<input type="button" value="주문목록" onclick="location.href='adminList.do'">
				</li>
			</ul>
		</div>
	</div>
</body>
</html>

