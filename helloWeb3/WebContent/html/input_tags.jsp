<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버로 데이터 전송을 위한 HTML 태그들</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		$('input[type=radio]').click(function(evt){
			var category = evt.target.value;
			if(category == 'empno'){
				
			}else if(category == 'ename'){
				
			}
		});
	});
</script>
</head>
<body>	
<form id="input_form" onsubmit="return test();">
	사번검색:<input type="radio" name="category" value="empno">
	이름검색:<input type="radio" name="category" value="ename">
</form>

<datalist>
	<option value="11">
	<option value="12">
	<option value="13">
</datalist>
<!--  <form>
	<div>
		<label>기혼</label>
		<input type="radio" id="married1" name="married" value="1">
	</div>
	<div>
		<label>미혼</label>
		<input type="radio" id="married2" name="married" value="0">
	</div>
	<div>
		<button type="reset">취소</button>
		<button type="submit">전송</button>
	</div>
</form>-->
</body>
</html>