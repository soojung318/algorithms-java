<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록:에러화면</title>
</head>
<body>
<div align ="center">
<h2>주소록:에러화면</h2>
<hr>
에러 발생<br/>
<%=exception%>

</body>
</html>