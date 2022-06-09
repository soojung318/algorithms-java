<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
-->
<%
	List<String> list = new ArrayList<>();
	list.add("강호동");
	list.add("손흥민");
	list.add("네이마르");
	
	pageContext.setAttribute("list",list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Test</title>
</head>
<body>
${list } :달러 그레이스 리스트
자바로 for문 돌리지 않아도 태그만으로 list를 출력 할 수 있다.
items==collection의 객체 하나하나가 mem에 저장됨.
<c:forEach var="mem" items="${list }">
	<div>${mem }</div>
</c:forEach>
</body>
</html>