<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.*,java.util.*" errorPage="addrbook_error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록: 목록</title>
</head>
<jsp:useBean id="arraylist" scope="request" class="java.util.ArrayList"/>
<body>
<div align=center>
<h2>주소록:목록화면</h2>
<hr>
<a href = "addrbook_form.jsp">주소록등록</a><p>
<table border=1>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>전화번호</th>
		<th>생 일</th>
		<th>회 사</th>
		<th>메 모</th>
	</tr>
<%

	/*AddrBook addrbook = new AddrBook();
	for(int i=0; i<addrlist.size(); i++){
		addrbook= addrlist.get(i);*/
	ArrayList<AddrBookDto> addrlist = (ArrayList<AddrBookDto>) request.getAttribute("addrlist");
	for(AddrBookDto dto :addrlist){
%>

	<tr>
		<td><a href="addrbook_edit_form.jsp"><%= dto.getAb_id() %></a></td>
		<td><%= dto.getAb_name() %></td>
		<td><%= dto.getAb_tel() %></td>
		<td><%= dto.getAb_birth() %></td>
		<td><%= dto.getAb_comdept() %></td>
		<td><%= dto.getAb_memo() %></td>
	</tr>
<%
	}
%>
	<tr>

</table>
</div>
</body>
</html>