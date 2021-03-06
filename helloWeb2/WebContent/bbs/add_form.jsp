<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기 폼</title>
<style type="text/css">
	main { width:fit-content; margin:0 auto; }
	main>h3 { width:fit-content; margin:10px auto; }
	label { display:inline-block; width:3em; padding-right:0.5em; text-align: right;}
	label[for=contents]{vertical-align:top; margin-top:2em; }
	#div_btn {width:fit-content; margin:10px auto; }
	input[type=text] { width:300px;}
	textarea { width:300px; }
	footer { width:fit-content; margin:5px auto; }
	a { text-decoration: none;}
	#title {margin-bottom:0.5em;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function add()
	{
		var serData = $('#add_form').serialize();
		$.ajax({
			url:'bbs',
			method:'post',
			cache:false,
			data:serData,
			dataType:'json',
			success:function(res){
				alert(res.added ? '글저장 성공':'Failed');
				location.href='bbs?cmd=list';
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
<h3>게시판 글쓰기 폼</h3>
<form id="add_form" onsubmit="return add();">
<!-- value="add" 는 서버로 cmd=add 라는 파라미터를 전달하는 겁니다	-->
	<input type="hidden" name="cmd" value="add">
	<div>
	<!-- for="title" 은 아이디가 "title" 인 입력박스를 위한 라벨이란 뜻인데 그 라벨을 클릭해도 연결된 입력박스에 마우스 커서가 들어가게 됩니다 -->
		<label for="title">제목</label>
		<!-- name="title" 은 서버로 전달할 파라미터의 이름을 의미하는데 서버측에서 request.getParameter("title") 부분에서 사용됩니다 -->
		<input type="text" id="title" name="title" value="제목 샘플">
	</div>
	<div>
		<label for="content">글내용</label>
		<textarea rows="5" col="30" id="contents" name="content">글내용</textarea>
	</div>
	<div id="div_btn">
		<button type="reset">취소</button>
		<button type="submit">저장</button>
	</div>
</form>
<hr>
<footer>
	[<a href="bbs?cmd=list">글목록</a>]	
</footer>
</main>
</body>
</html>