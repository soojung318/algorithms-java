<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 추가 폼</title>
</head>
<body>
<h3>사원정보 추가</h3>
<!-- 그냥 화면에 출력하지 않고 고쳐서 출력을 해야함 -->
<!-- 주소창에 데이터 보이는 방식은 모두 get 방식이나 보안상 위험하므로 post 방식 사용 -->
<form action="emp" method="post">
	<input type="hidden" name="cmd" value="add" >
	<div><label for="num">번호</label><input type="text" name="num"></div>
	<div><label for="name">이름</label><input type="text" name="name"></div>
	<div><label for="phone">전화</label><input type="text" name="phone"></div>
	<div><label for="email">메일</label><input type="text" name="email"></div>
	<button type="reset">취소</button>
	<button type="submit" >저장</button>
</form>

</body>
</html>