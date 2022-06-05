<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");	
	String username = request.getParameter("username");
	
	//username이 null이 아닌 경우 세션에 값을 저장
	if(username != null){
		session.setAttribute("user",username);
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>sns_list.jsp</title>
</head>
<body>
<div align=center>
<h3>SNS Chatting!!</h3>
<hr>
<form action="sns.jsp" method="POST">
<!-- 세션에 저장된 이름 출력 -->
@<%=session.getAttribute("user") %>
<input type ="text" name="msg">
<input type="submit" value="SNS">
</form>
<hr>
</div align="left">
<ul>
<%
	// application 내장 객체를 통해 msgs 이름으로 저장된 ArrayList를 가지고 옴
	ArrayList<String> msgs = (ArrayList<String>)application.getAttribute("msgs");

	// msgs가 null이 아닌 경우에만 목록 출력
	if(msgs != null){
		for(String msg:msgs){
			out.println("<LI>"+msg+"</LI>");
		}
	}
%>
</ul>
</body>
</html>