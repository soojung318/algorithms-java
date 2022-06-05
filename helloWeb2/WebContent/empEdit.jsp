<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ezen.vo.EmpVO"%>
<%
	EmpVO emp = (EmpVO)request.getAttribute("emp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 수정폼</title>
</head>
<body>
<h3>사원정보를 수정해주세요</h3>
<!-- 그냥 화면에 출력하지 않고 고쳐서 출력을 해야함 -->
<!-- 주소창에 데이터 보이는 방식은 모두 get 방식이나 보안상 위험하므로 post 방식 사용 -->
<form action="emp" method="post">
<input type="hidden" name="cmd" value="update" >
<input type="hidden" name="num" value="<%=emp.getNum()%>">
<div>번호: <%=emp.getNum() %></div>
<div>이름: <%=emp.getName() %></div>
<div>전화: <input type="text" name="phone" value="<%=emp.getPhone() %>"></div>
<div>메일: <input type="text" name="email" value="<%=emp.getEmail() %>"></div>
<button type="submit" >저장</button>
</form>

</body>
</html>