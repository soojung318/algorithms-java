<%@page import="com.ezen.vo.BBSVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BBSVO bbs = (BBSVO) request.getAttribute("bbs");
	System.out.println("bbs:"+bbs.getNo());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function update(){
		if(!confirm('정말로 수정하시겠습니까?')) return false;
		
		var serData = $('#edit_form').serialize();
		
		$.ajax({
			url:'bbs',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				//alert(res);
				
				alert(res.updated ? '수정 성공':'수정 실패');
				location.href='bbs?cmd=detail&num=<%=bbs.getNo()%>';
			},
			error:function(xhr,status,err){
				alert(err);
			}
		});
		return false;
	}
</script>
</head>
<body>
<main>
<h3>게시판 글 수정 폼</h3>
<form id="edit_form" onsubmit="return update();">
<!-- value="add" 는 서버로 cmd=add 라는 파라미터를 전달하는 겁니다	-->
	<input type="hidden" name="cmd" value="update">
	<input type="hidden" name="num" value="<%=bbs.getNo()%>">
	<div>
	<!-- for="title" 은 아이디가 "title" 인 입력박스를 위한 라벨이란 뜻인데 그 라벨을 클릭해도 연결된 입력박스에 마우스 커서가 들어가게 됩니다 -->
		<label for="title">제목</label>
		<!-- name="title" 은 서버로 전달할 파라미터의 이름을 의미하는데 서버측에서 request.getParameter("title") 부분에서 사용됩니다 -->
		<input type="text" id="title" name="title" value="<%=bbs.getTitle()%>">
	</div>
	<div>
		<label id="lbContent">본문</label>
		<textarea id="content" name="content"><%=bbs.getContent() %></textarea>
	</div>
	<div id="div_btn">
		<button type="reset">취소</button>
		<button type="submit">저장</button>
	</div>
</form>
<hr>
<footer>
	[<a href="bbs?cmd=list">목록</a>]	
</footer>
</main>
</body>
</html>