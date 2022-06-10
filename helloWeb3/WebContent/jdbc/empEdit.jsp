<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 수정 폼</title>
<style type="text/css">
	label{ display:inline-block; width::4em; margin-right:1em; text-align:right; }
	main{ width:fit-content; margin:0 auto;}
	main>h3 {text-align:center;}
	form {border:1px solid black; padding:0.5em 1em;}
	form > div:last-child { width:fit-content; margin: 0.7em auto;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
function update(){
	   if(!confirm('입력하신 값으로 수정하겠습니까?')) return false;
	   var formdate=$('#edit_form').serialize();
	   alert(formdate);
	   $.ajax({
	       url:'jdbcemp',
	       method:'post',
	       cache:false,
	       data:formdate,
	       dataType:'json',
	       success:function(res){
	          alert(res.updated? '수정성공':'실패' );
	          location.href='jdbcemp?cmd=getEmp&empno=${emp.empno}';
	          
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
<h3>사원정보 수정 폼</h3>
<form id="edit_form" onsubmit="return update();">
	<input type="hidden" name="cmd" value="update">
	<input type="hidden" name="empno" value="${emp.empno }">
	<div>
		<label>사원번호</label>${emp.empno}
	</div>
	<div>
		<label>사원이름</label>${emp.ename}
	</div>
	<div>
		<label for="deptno">부서번호</label>
		<input type="text" id="deptno" name="deptno" value="${emp.deptno}">
	</div>
	<div>
		<label for="sal">급여</label>
		<input type="text" id="sal" name="sal" value="${emp.sal}">
	</div>
	<div>
		<button type="reset">취소</button>
		<button type="submit">저장</button>
	</div>
</form>
</main>
</body>
</html>