<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Boolean 객체를 boolean으로 언박싱
	boolean updated = (Boolean) request.getAttribute("updated");		//(Boolean): 클래스, (boolean): 일반 자료형.
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 결과</title>
<script type="text/javascript">
	var updated = <%= updated%>;
	alert(updated ? '수정 성공':'Failed');
	location.href='emp?cmd=list';
	<!--location 위치. 주소창의 hyper reference(href) 는 다음과 같은 주소이다.-->
</script>
</head>
<body>

</body>
</html>