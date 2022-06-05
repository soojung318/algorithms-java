<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.ezen.vo.EmpVO"%>
<%
	//jsp에는 자바 코드가 최소한으로 들어가야함.
	List<EmpVO> list = (List<EmpVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 목록</title>
<style type="text/css">
	main{width:fit-content; margin:0 auto; border:1px solid black; padding:10px;}
	table {border:1px solid black; border-spacing: 0px; border-collapse: collapse;
			margin-top:20px; }
	td, th{border:1px solid black; padding:5px 10px; text-align: center;}
	th{background-color:#eee;}
	a{text-decoration: none; color:blue;}
	a:hover{color:gold;}
	
</style>
</head>
<body>
<h3>사원정보 보기</h3>
<%
	for(int i=0; i<list.size(); i++	){
%>
	<!-- empVO형의 객체를 하나 출력. toString -->
		<%=list.get(i) %><br>
<%
	}
%>
<table>
	<tr><th>번호</th><th>이름</th><th>전화</th><th>이메일</th></tr>
<%
	for(int i=0; i<list.size(); i++){
		EmpVO emp = list.get(i);	
%>
		<tr>
		<td><%= emp.getNum()%></td>
		<td><a href="emp?cmd=getEmp&num=<%=emp.getNum()%>"><%=emp.getName()%></a></td>
		<td><%= emp.getPhone() %></td>
		<td><%= emp.getEmail() %></td>
		</tr>
		
<%	} 
%>
<a href="emp?cmd=add_form">추가하기</a>
	
</table>
</body>
</html>