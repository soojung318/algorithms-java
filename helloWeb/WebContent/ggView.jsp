<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%	//Scriptlet
	//jsp는 servlet 으로 바뀌지만 여기에 쓰는 자바 코드는 바뀌지 않고 그대로 자바코드가 됌
	String msg = (String)request.getAttribute("msg");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 보기</title>
</head>
<body>
<!-- Expression: out.print와 같은 의미  -->
<%= msg%>
</body>
</html>

<!-- 
이 코드들은 자바가 됨.
Scriptlet의 코드들은 자바로 작성된 부분이기 때문에 그대로 자바로 전달됨.
클래스 밖에 있는 것은 자바 코드가 아니다....??
Scriptlet 안에 있는 메소드는 서비스 메소드이다.
서블릿의 response.setContentType()에 1번줄 의 contentType=""이 연결됨.
 -->