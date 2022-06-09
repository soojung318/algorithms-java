<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	List<String> list = new ArrayList<>();
	list.add("강호동");
	list.add("손흥민");
	list.add("네이마르");
	
	//pageContext.setAttribute("list",list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Test</title>
</head>
<body>
c:set 태그를 이용하여 출력>>
<c:set var="list" value="<%=list %>"/>
<p>
[여기서부턴 c:forEach 태그를 이용하여 출력]<br>
${list } :달러 그레이스 리스트<br>
자바로 for문 돌리지 않아도 태그만으로 list를 출력 할 수 있다.<br>
items==collection의 객체 하나하나가 mem에 저장됨.<br>
c:forEach 태그를 이용하여 출력>>
<c:forEach var="mem" items="${list }">
	<div>${mem }</div>
</c:forEach>
var값은 영역에 들어가는 key.
</body>
</html>