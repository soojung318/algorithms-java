<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧셈하기</title>
</head>
<body>
<%= msg %>
</body>
</html>