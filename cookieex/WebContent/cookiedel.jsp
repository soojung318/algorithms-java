<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie del</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	for(int i=0; i<cookies.length; i++){
		String str = cookies[i].getName();
		if(str.equals("cookieN")){
			out.println("name:"+cookies[i].getName() +"<br/>");
			cookies[i].setMaxAge(0);
			response.addCookie(cookies[i]);
		}
	}
%>

<a href = "cookietest.jsp">쿠키 확인</a>
</body>
</html>