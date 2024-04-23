<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
HashMap<String, Integer> menus = new HashMap<String, Integer>();
String[] menuNames = {"짜장면", "짬뽕", "볶음밥"};

menus.put(menuNames[0], 4000);
menus.put(menuNames[1], 5000);
menus.put(menuNames[2], 6000);

int[] orders = new int[menus.size()];
int totalPrice = 0;
%>
<title>주문 내역</title>
</head>
<body>
	<ul>
		<%
		for (int i = 0; i < menus.size(); i++) {
			orders[i] = Integer.parseInt(request.getParameter("food_c" + i));
			totalPrice += orders[i] * menus.get(menuNames[i]);
			if (orders[i] > 0) {
		%>
		<li><%=menuNames[i] %> <%=orders[i]%>개
		</li>
		<%
		}
		}
		%>
		<li>총 지불금액 : <%= String.format("%,d원", totalPrice) %></li>
	</ul>
</body>
</html>