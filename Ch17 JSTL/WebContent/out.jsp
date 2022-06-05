<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out 예제</title>
</head>
<body bgcolor="#FFFFFF">
<h3>&lt;c:out&gt;</h3>

<table border="1"cellpadding=5 cellspacing=0>
	<c:forEach var="member"items="${members}">
	<tr>
	<td>${member.name}</td>
	<td><c:out value="${member.email}"escapeXml="false">
	<font color=red>email 없음</font>
	</c:out>
	</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>