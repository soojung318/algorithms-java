<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ezen.vo.EmpVO"%>
<%
	EmpVO emp = (EmpVO)request.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 상세보기</title>
<style type="text/css">
	main {width:fit-content; border:1px solid black; padding:10px; margin:0 auto;}
	main>div { text-decoration: underline;}
	a{text-decoration:none; color:blue;}
	
	<!-- main>div는 자식 select를 말함. 메인 아래의 바로 오는 div태그를 말한다. main div 처럼 띄어쓰기 하나는 자손 셀렉터.-->
</style>
</head>
<body>
<main>
	<h3>사원정보 상세보기</h3>
	<div>번호 <%=emp.getNum() %></div>
	<div>이름 <%=emp.getName() %></div>
	<div>전화 <%=emp.getPhone() %></div>
	<div>메일 <%=emp.getEmail() %></div>
	<hr>
	[<a href="emp?cmd=list">목록보기</a>]&nbsp;
	[<a href="emp?cmd=edit&num=<%=emp.getNum()%>">수정하기</a>]&nbsp;
	[<a href="emp?cmd=delete&num=<%=emp.getNum()%>">삭제하기</a>]
</main>
</body>
</html>