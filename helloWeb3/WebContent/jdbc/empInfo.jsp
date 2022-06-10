<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 상세 정보</title>
<style type="text/css">
	main{width:fit-content; margin:0 auto;}
	main>h3 {width:fit-content; margin:1em auto;}
	.container>div{border-bottom:1px dashed black; padding:0.2em 0.5em;}
	dib>label{display:inline-block; width:3em; padding-right:1em; text-align: right;}
	nav {width:fit-content; margin:1em auto;}
	a {text-decoration:none; color:blue;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
function remove(empno){
	var obj = {};	//빈 오브젝트.(key,value)가 아무고토 옶음. json데이터가 아무것도 없다.
	obj.cmd = 'delete';
	obj.empno = empno;
	if(!confirm('정말로 삭제하시겠어요?')) return;  	
	$.ajax({
		url:'jdbcemp',
		method:'post',
		cache:false,
		data:obj,
		dataType:'json',
		success:function(res){
			alert(res.deleted ? '삭제 성공' : '삭제 실패');
			 location.href="jdbcemp?cmd=list";
		},
		error:function(xhr,status,err){
			alert('Error:'+err);
		}			
	});
	return false;
}
</script>
</head>
<body>
<main>
<h3>사원정보 상세보기</h3>
<div class="container">
	<div><label>번호</label>${emp.empno }</div>
	<div><label>이름</label>${emp.ename }</div>
	<div><label>부서</label>${emp.deptno }</div>
	<div><label>급여</label>${emp.sal }</div>
	<div><label>입사</label>${emp.hiredate }</div>
</div>
<hr>
<nav>[<a href="jdbcemp?cmd=edit&empno=${emp.empno }">수정</a>]</nav>
<nav>[<a href="javascript:remove(${emp.empno })">삭제</a>]</nav>
</main>
</body>
</html>