<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="com.ezen.vo.*"%>
    
    <% List<Employee>list = (List<Employee>)request.getAttribute("list"); 
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서내 사원정보</title>
<style type="text/css">
	a {text-decoration: none; color:blue;}
	a:hover{color:gold;}
	main{width:fit-content; margin:0 auto;}
	main>h3 {width:fit-content; margin:1em auto;}
	table{width:fit-content; padding:1em; border:1px solid black;
	border-spacing:0; border-collapse:collapse;}
	th{background-color:#eee; border-bottom:3px double black;}
	th,td{border-right:1px dashed black; width:fit-content; padding:0.2em 1em;}
	td{border-bottom:1px solid black;}
	th:last-child{border-right:none;}
	td:last-child{border-right:none;}
</style>
</head>
<body>
<h2>부서(${list[0].deptno })내 사원정보</h2>
<table>

<tr><th>사원번호</th><th>이름</th><th>부서번호</th><th>급여</th><th>고용날짜</th></tr>
<c:forEach var="emp" items="${list}">
<tr>
<td>${emp.empno}</td>
<td><a href="jdbcemp?cmd=getEmp&empno=${emp.empno}">${emp.ename}</a></td>
<td><a href="jdbcemp?cmd=empByDeptno&deptno=${emp.deptno}">${emp.deptno }</a></td>
<td>${emp.sal}</td>
<td>${emp.hiredate}</td>
</tr>
</c:forEach>
</table>
</body>
</html>