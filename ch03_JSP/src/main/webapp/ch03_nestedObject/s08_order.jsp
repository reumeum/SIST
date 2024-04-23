<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매 정보</title>
</head>
<body>
	<%
	String[][] products = { { "가방", "200000" }, { "신발", "100000" }, { "옷", "50000" }, { "식사권", "150000" } };
	
	int shipping = 5000;
	int sum = 0;
	int totalPrice = 0;
	%>
	<h3>구매 정보</h3>
	<ul>
		<li>이름: <%=request.getParameter("name")%></li>
		<li>배송 희망일: <%=request.getParameter("order_date")%></li>
		<li>구입 내용: <%
		String[] items = request.getParameterValues("item");
		if (items != null) {
			for (int i = 0; i < items.length; i++) {
				if (i > 0)
			out.print(", ");
		%><%=items[i]%>
			<%
			}
			}
			%>
		</li>
		<%
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < products.length; j++) {
				if (items[i].equals(products[j][0])) {
			sum += Integer.parseInt(products[j][1]);
				}
			}
		}
		if (sum >= 300000) {
			shipping = 0;
		}
		totalPrice = sum + shipping;
		%>
		<li>배송비: <%=String.format("%,d", shipping)%>원
		</li>
		<li>총 구매비용(배송비 포함): <%=String.format("%,d", totalPrice)%>원
		</li>

	</ul>
</body>
</html>