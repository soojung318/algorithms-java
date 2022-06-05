<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="addrbook_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록:작성화면</title>
</head>
<body>
<div align ="center">
<h2>주소록:작성화면</h2>	

<hr>
<a href = addrbook_control.jsp?action=list>주소록 목록으로</a><p>
<form name=form1 method=post action=addrbook_control.jsp>
<input type=hidden name="action" value="insert">
<table border="1">
	<tr>
		<th>이름</th>
		<td><input type="text" name="ab_name" maxlength="15"></td>
	</tr>
	<tr>
		<th>email</th>
		<td><input type="text" name="ab_email" maxlength="50"></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td><input type="text" name="ab_tel" maxlength="20"></td>
	</tr>
	<tr>
		<th>생 일</th>
		<td><input type="text" name="ab_birth" maxlength="10"></td>
	</tr>
	<tr>
		<th>회 사</th>
		<td><input type="text" name="ab_comdept" maxlength="20"></td>
	</tr>
	<tr>
		<th>메 모</th>
		<td><input type="text" name="ab_memo" maxlength="100"></td>
	</tr>	
</table>
<input type="submit" value="저장"/>
<input type="reset" value="취소"/>
</form>
</div>
</body>
</html>