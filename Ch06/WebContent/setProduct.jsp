<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>setProduct.jsp</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	session.setAttribute("username",request.getParameter("username"));
%>
<body>
<div align ="center">
	<h2>상품선택</h2>
	<hr>
	<%=session.getAttribute("username") %>님 환영합니다!!!
	<hr>
	<form name="form1" method="POST" action ="add.jsp">
		<SELECT name = "product">
			<option>사과</option>
			<option>귤</option>
			<option>파인애플</option>
			<option>자몽</option>
			<option>레몬</option>
		</SELECT>
		<input type ="submit" value="추가"/>
	</form>
	<a href ="checkOut.jsp">계산</a>
</div>

</body>
</html>