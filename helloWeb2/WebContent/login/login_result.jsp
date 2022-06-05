<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean pass = (Boolean) request.getAttribute("pass");
	System.out.println("pass:"+pass);
 %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 화면</title>
<script type="text/javascript">
	var pass=<%= pass%>;	<!--서버에서 pass 정보를 먼저 t/f 로 알림-->
	alert(pass?'로그인 성공': '로그인 실패');
	location.href='user?cmd=login_form';
</script>
</head>

<body>
로그인 성공
</body>
</html>