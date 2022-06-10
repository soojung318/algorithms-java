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
	$(function(){
		$('input[type=radio]').click(function(evt){
			var category = evt.target.value;
			$('#key').val('');
			var obj = {};
			obj.cmd = 'getItemList';
			obj.category = category;
			
			$.ajax({
				url:'jdbcemp',
				method:'post',
				cache:false,
				data:obj,
				dataType:'text',
				success:function(res){
					var obj = JSON.parse(res);
					var options = "";
					for(var i=0; i<obj.length; i++){
						options += "<option value='"+obj[i]+"'>";
					}
					$('#list').html(options);
				},
				error:function(xhr,status,err){
					alert(err);
				}
			});
		});
		//.은 클랙스 셀렉터
		$('.td_empno').mouseover(function(evt){
			var empno = $(evt.target).text();
			var obj = {};
			obj.cmd = 'getImage';
			obj.empno = empno;
				
			$.ajax({
				url:'jdbcemp',
				method:'post',
				cache:false,
				data:obj,
				dataType:'json',
				success:function(res){
					$('#img1').attr("src","images/"+res.pic);
				},
				error:function(xhr,status,err){
					alert('Error:'+err);
				}
			});
		});
	});
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
<main>
<h2>사원정보 목록</h2>

<table>

<tr><th>사원번호</th><th>이름</th><th>부서번호</th><th>급여</th><th>고용날짜</th></tr>
<c:forEach var="emp" items="${list}">
<tr>
<td class="td_empno">${emp.empno}</td>
<td><a href="jdbcemp?cmd=getEmp&empno=${emp.empno}">${emp.ename}</a></td>
<td><a href="jdbcemp?cmd=empByDeptno&deptno=${emp.deptno}">${emp.deptno }</a></td>
<td>${emp.sal}</td>
<td>${emp.hiredate}</td>
</tr>
</c:forEach>
</table>
<form action="jdbcemp">
	<input type="hidden" name="cmd" value="search">
	<div>
		사번으로 검색<input type="radio" name="category" value="empno">
		이름으로 검색<input type="radio" name="category" value="ename">
		검색어<input type="text" id="key" name="key" list="list">
		<button type="submit">검색</button>
	</div>
</form>
</main>
<datalist id="list"></datalist>
<img id="img1">
<!-- <div><a href="jdbcemp?cmd=add">사원 추가</a></div> -->
</body>
</html>