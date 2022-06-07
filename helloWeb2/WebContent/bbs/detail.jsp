<%@page import="com.ezen.vo.BBSVO"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	BBSVO bbs = (BBSVO) request.getAttribute("bbs");
	String uid = (String) session.getAttribute("uid");
	System.out.println("uid:"+uid);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시글 상세보기</title>
<style type="text/css">
	main { width:fit-content; margin:10px auto; }
	main>h3 { width:fit-content; margin:10px auto; }
	table {border:1px solid black; width:600px; border-spacing:0; border-collapse: collapse;}
	th{ border-right:3px double black; background-color:#eee; width:15%;}
	tr:last-child td { width:85%; height:7em; overflow: auto;}
	th, td { border-bottom: 1px solid black; padding:5px;}
	td:nth-child(2) { width:15%;}
	footer { width:fit-content; margin:1em auto; }
	a { text-decoration: none; }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function edit(no){
		var uid ='<%=uid %>';
		var writer = '<%=bbs.getWriter()%>';
		alert(uid+','+writer);
		if(uid!=writer){
			
			alert('작성자만 수정할 수 있습니다.');
			return;
		}
		location.href='bbs?cmd=edit&num='+no;
	}
</script>
</head>
<body>
<main>
<h3>게시글 보기</h3>
<table>
	<tr><th>번호</th><td><%=bbs.getNo()%></td><th>제목</th><td><%=bbs.getTitle()%></td></tr>
	<tr><th>작성자</th><td><%=bbs.getWriter()%></td><th>작성일</th><td><%=bbs.getDate()%></td></tr>
	<tr><th>내용</th><td colspan="3"><%=bbs.getContent()%></td></tr>
</table>
<hr>
<footer>
	[<a href="bbs?cmd=list">목록보기</a>]
	[<a href="javascript:edit(<%=bbs.getNo()%>);">수정하기</a>]
</footer>
</main>
</body>
</html>