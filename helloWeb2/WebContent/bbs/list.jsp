<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ezen.vo.BBSVO, java.util.*,com.ezen.service.BBService"%>
<%
	List<BBSVO> list=(List<BBSVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>게시판</title>
</head>
<body>
<h3>글쓰기</h3>
<%
	for(int i=0; i<list.size(); i++	){
%>
	<!-- empVO형의 객체를 하나 출력. toString -->
		<%=list.get(i) %><br>
<%
	}
%>
<table>
	<tr><th>번호</th><th>작성자</th><th>제목</th><th>날짜</th></tr>
<%
	for(int i=0; i<list.size(); i++){
		BBSVO bbs = list.get(i);	
%>
		<tr>
		<td><%= bbs.getNo()%></td>
		<td><%= bbs.getWriter()%></a></td>
		<td><%= bbs.getTitle() %></td>
		<td><%= bbs.getDate() %></td>
		</tr>
		
<%	
	} 
%>
<a href="emp?cmd=add_form">글쓰기</a>
	
</table>
</table>
</body>
</html>