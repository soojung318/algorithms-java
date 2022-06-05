<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ezen.vo.UserVO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<style type="text/css">
	main {width:fit-content;padding:15px; margin:0 auto;}
	#LoginForm {width:fit-content; padding:15px; border:1px solid black; margin:0 auto;
	border-radius:5px; margin:0 auto;}
	main>h3 {width:fit-content; margin:0 auto;}
	label{display:inline-block; width:3em; text-align:right; margin-right:1em;}
	dib:nth-child(4) {width:fit-content; margin:0 auto; margin-top:1em;}
	input{width:10em;}
	a{text-decoration:none; color:blue;}
	.link_user{display:inline-block; width:fit-content; font-size:0.08em;
	margin:10 auto;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){	///javascript 익명 함수
		//alert('jQuery Ready!');	//jQuery Ready Event Handler; 자바스크립트 쓸 준비 되었니?
	});
	
	function login(){
		//alert('로그인 함수');
		//jQuery는 id가 loginForm인 태그를 찾아서 거기있는 dataForm 값을 가져옴.
		var serData = $('#loginForm').serialize();		//시리얼: 직렬화,일렬
		//alert(serData);
		
		//비동기 전송방식
		$.ajax({	//json: Javascript Object Notation {'key':'value','key2':'value2',....}
			url:'user',
			method:'post',		//데이터 전송하는 방식
			cache:false,		//브라우저에 캐시를 남겨두지 않겠다.
			data:serData,		//보낼 데이터 내용
			dataType:'json', 	//응답온 데이터를 text로 받겠다.
								//text, json, html, xml  서버 측에서 JSON 문자열 형식으로 응답해야 한다.
			success:function(res){	//서버측에서 json문자열을 제공할 때(key,value)형식으로 제공
				//res는 UserService의 process() 결과가 들어있음.
				//alert(res.pass ? '로그인 성공' : '로그인 실패');
				if(res.pass){
					alert('로그인 성공');
					location.href='bbs?cmd=list';
				}else{
					alert('삭제 실패');
				}
			},
			error:function(xhr,status,err){
				alert(err);
			}
		});	
		
		return false;
	}
	
	function logout(){
		var obj = {};	//빈 오브젝트.(key,value)가 아무고토 옶음. json데이터가 아무것도 없다.
		obj.cmd = 'logout';
		
		if(!confirm('정말로 로그아웃하시겠어요?')) return;  // false이어야 true>> 로그아웃 하지 않을거면 그냥 아무것도 안하고 끝냄.
		$.ajax({
			url:'user',
			method:'post',
			cache:false,
			data:obj,
			dataType:'json',
			success:function(res){
				alert(res.logout ? '로그아웃 성공' : '로그아웃 실패');
			},
			error:function(xhr,status,err){
				alert(err);
			}			
		});
	}
	
	
</script>
</head>
<body>
<main>
<h3>로그인</h3>
<div class="link_user"><a href="user?cmd=add_form">회원등록</a>
 | <a href="">아이디/암호 찾기</a>
 | <a href="javascript:logout();">로그아웃</a>	<!-- 로그아웃은 서버 url이 아니고 javascript의 logout함수를 돌릴 거얌 -->
</div>
<form id="loginForm" action="user" method="post" onsubmit="return login();">
<input type="hidden" name="cmd" value="login" >

<!-- id: 자바스크립트에서 사용, name: 서버에서 사용되는 파라미터 -->
	<div><label for="uid">아이디</label><input type="text" id ="uid" name="uid" value="smith"></div>
	<div><label for="pwd">암  호</label><input type="password" id ="pwd"name="pwd" value="smithpwd"></div>
	<button type ="submit">로그인</button>
	<button type="reset">취소</button>
</form>
<hr>
<div class="link_user">[<a href="user?cmd=edit">회원정보 변경</a>]</div>
</main>
</body>
</html>