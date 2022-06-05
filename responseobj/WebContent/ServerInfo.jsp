<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Info for ServerInfo.jsp</title>
</head>
<body>
<h2>application 예제</h2>
1.서버정보:<%=application.getServerInfo() %><BR>
2.서블릿 API 버전 정보:<%=application.getMajorVersion()+"."+application.getMinorVersion() %><BR>
3.ServerInfo.jsp 파일의 Path 정보:<%=application.getRealPath("ServerInfo.jsp") %>

</body>
</html>

<!-- Catalina는 톰캣의 다른 이름 -->