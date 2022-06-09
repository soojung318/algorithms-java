<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="com.ezen.vo.*"%>
    
    <% List<Employee>list = (List<Employee>)request.getAttribute("list"); 
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 출력</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function test(){
		//console.log($('#input_form').serialize());
		var formdata = $('#input_form').serialize();
		$.ajax({
			url:'jdbcemp',
			method:'post',
			cache:false,
			data:formdata,
			dataType:'json',
			success:function(res){
				alert(res.)
			}
		});
		return false;
	}
</script>
<style type="text/css">
	table,th,td{ border: 1px black solid; margin:0 auto; border-collapse:collapse; 
	 width: 40em; height: 2em;}
	h2{text-align: center;}
	th{background-color: maroon;}
	tr:nth-child(odd) {background-color:aqua;}
	div{text-align: center;}
</style>
</head>
<body>
<h2>사원정보 출력</h2>

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
<form id="input_form" onsubmit="return test();">
	<div>
		<label>사번으로 검색</label>
		<input type="radio" id="empno" name="empno" value="empno">
	</div>
	<div>
		<label>이름으로 검색</label>
		<input type="radio" id="ename" name="ename" value="ename">
	</div>
	<div>
		<button type="reset">취소</button>
		<button type="submit">전송</button>
	</div>
</form>
<!-- <div><a href="jdbcemp?cmd=add">사원 추가</a></div> -->
</body>
</html>