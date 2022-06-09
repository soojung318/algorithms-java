<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버로 데이터 전송을 위한 HTML 태그들</title>
</head>
<body>
<form>
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
</form>
</body>
</html>