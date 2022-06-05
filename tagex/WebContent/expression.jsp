<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트 중입니다...</title>
</head>
<body>
	<%!
		int i=10;
		String str = "abc";
		
		private int sum(int a, int b){
			return a+b;
		}
	%>
	
	<%= i %><br/>
	<%= str %><br/>
	<%= sum(1,5) %>
	<h1>testing...</h1>
</body>
</html>