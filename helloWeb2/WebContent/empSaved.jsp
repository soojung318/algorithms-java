<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Boolean 객체를 boolean으로 언박싱
	boolean saved = (Boolean) request.getAttribute("saved");		//(Boolean): 클래스, (boolean): 일반 자료형.
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 추가 결과</title>
<script type="text/javascript">
	var saved = <%=saved%>;
	alert(saved? '사원정보 추가 성공':'사원정보 추가 실패');
	location.href='emp?cmd=list';
</script>
</head>
<body>

</body>
</html>