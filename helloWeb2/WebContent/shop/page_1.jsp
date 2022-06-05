<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로그래밍 서적 보기</title>
<style type="text/css">
	input[type=text] {border:none;}
	input[type=number] {width:50px;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> 
<script type="text/javascript">
	
	function toCart(){
		$.ajax({
			url:'shop',
			method:'post',
			cache:false,
			data: $('#order_form').serialize(),
			dataType:'json',
			success:function(res){
				alert(res.saved ? '장바구니에 저장':'Failed');
				location.reload();
			},
			error:function(xhr,status,err){
				alert(res);
			}
		});
	}
	
	//예제2-현재 작동 안함
	/*function order(){
		
		$.ajax({
			url:'shop',
			methos:'post'
			cache:false,
			data: $('#order_form').serialize(),
			dataType:'text',
			success:function(res){
				alert(res);
			},
			error:function(xhr,status,err){
				alert(res);
			}
		});*/
		
		//에제1
		//var qty = $('#qty').val();
		//var iQty = parseInt(qty);	//qty를 정수로 변환
		//if(iQty<5){
		//	alert('수량은 5 이상이어야 합니다');
		//	return;
			////return false;
		//}////return false;
	//}
</script>
</head>
<body>
<h3>프로그래밍 서적 보기</h3>
<main>
<form id="order_form" onsubmit="return toCart();">
	<input type="hidden" name="cmd" value="tocart">
<div><label>제목</label><input type="text" name="title" value="자바야 놀자" readonly></div>
<div><label>출판사</label><input type="text" name="pub" value="도서출판 신림" readonly></div>
<div><label>가격</label><input type="text" name="price" value="30000" readonly></div>
<div><label>출판일</label><input type="text" name="pubdate" value="2022-05-31" readonly></div>
<div><label>저자</label><input type="text" name="author" value="홍길동" readonly></div>
<div><label>수량</label><input type="number" id ="qty" name="qty" value="1" min="1"></div>
<div>
	<button type="reset">취소</button>
	<button type="submit">장바구니 담기</button>
</div>
</form>
<div>
	[<a href="shop?cmd=showcart">장바구니 내용보기</a>]
</div>
</main>
</body>
</html>