<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ezen.vo.Employee"%>
<%
	pageContext.setAttribute("greeting", "Hello world");
	Employee emp = new Employee();
	emp.setEmpno(11);
	emp.setEname("scott");
	emp.setHiredate(java.sql.Date.valueOf("2001-06-17"));
	//emp를 영역 오브젝트 중 하나에 저장하고 EL을 통하여 화면에 표시해보세요.
	
	pageContext.setAttribute("emp",emp);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL(Expression Language)</title>
</head>
<body>
<%
	String greet = (String)pageContext.getAttribute("greeting");
	out.print("자바 코드를 사용한 경우: "+greet);		//1.자바 코드를 사용하여 화면에 표시
%>
Expression Tag를 사용한 경우: <%=greet %><%--jsp 주석태그,,, 2.Expression tag 이용하여 화면을 표시 --%>
<p>
EL을 사용한 경우: ${greeting } <!-- 3.EL을 사용하여 화면에 표시 -->
<p>
사번: ${emp.empno}<br>
이름: ${emp.ename}<br>
입사: ${emp.hiredate}<br>
</body>
</html>