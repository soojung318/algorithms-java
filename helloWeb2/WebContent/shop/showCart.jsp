<%@page import="com.ezen.vo.ITBook"%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	List<ITBook> list = (List<ITBook>)request.getAttribute("list");
	int total = (int) request.getAttribute("total");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>장바구니 보기</title>
<style type="text/css">
	main {width:fit-content; padding:1em; margin:0 auto; }
	main>h3 { width:fit-content; margin:0 auto; padding-bottom:1em;}
	table { border:1px solid black; border-spacing:0; border-collapse:collapse;}
	th { border-bottom: 3px double black; background-color: #eee;}
	th, td { padding:5px 10px; border-right: 1px dashed black; }
	td:last-child { border-right:none; }
	td.num { text-align: right; }
	a { text-decoration: none;}
	tr:nth-child(odd) { background-color:lightblue;}
	tfoot td {border:none; background-color:lightgreen; border-top:3px double black; 
		font-weight: bolder; text-align: right;}
	tfoot td:nth-child(3) { border-right: 1px dashed black; }
	input[type=number] { width:2em;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script type="text/javascript">
	function update_qty(idx)
	{
		var qty = parseInt($('#qty'+idx).val());
		if(qty<1){
			alert('수량은 1 이상이어야 합니다');
			return;
		}
		//alert('idx:'+idx+', qty:'+qty);
		var obj = {};
		obj.cmd = 'update_qty';
		obj.idx = idx;
		obj.qty = qty;
		
		$.ajax({
			url:'shop',
			method:'post',
			cache:false,
			data:obj,
			dataType:'json',
			success:function(res){
				if(res.updated){
					alert('수량변경 성공');
					$('#total').text(res.total);
				}else{
					alert('변경 실패');
				}
			},
			error:function(xhr,status,err){
				alert(err);
			}
		});
	}
	
	function remove(idx)
	{
		if(!confirm('해당 품목을 삭제하시겠어요?')){
			return;
		}

		var obj = {};
		obj.cmd = 'remove';
		obj.idx = idx;
		
		$.ajax({
			url:'shop',
			method:'post',
			cache:false,
			data:obj,
			dataType:'json',
			success:function(res){
				if(res.removed){
					alert('품목삭제 성공');
					location.href='shop?cmd=showcart';
				}else{
					alert('삭제 실패');
				}
			},
			error:function(xhr,status,err){
				alert(err);
			}
		});
	}
	
	function cartEmpty()
	{
		if(!confirm('장바구니를 비우시겠어요?')){
			return;
		}
		
		var obj = {};
		obj.cmd = 'empty';
		
		$.ajax({
			url:'shop',
			method:'post',
			cache:false,
			data:obj,
			dataType:'json',
			success:function(res){
				alert(res.empty ? '장바구니를 비웠습니다':'Failed');
				location.href='shop?cmd=showcart';
			},
			error(xhr,status,err){
				alert(err);
			}
			
		});
	}
	
	function order()
	{
		if(!confirm('장바구니 상품을 주문하시겠어요?')){
			return;
		}
		
		var obj = {};
		obj.cmd = 'order';
		
		$.ajax({
			url:'shop',
			method:'post',
			cache:false,
			data:obj,
			dataType:'json',
			success:function(res){
				alert(res.ordered ? '주문 성공':'Failed');
				location.href='shop?cmd=showcart';
			},
			error(xhr,status,err){
				alert(err);
			}
			
		});
	}
</script>
</head>
<body>
<main>
<h3>장바구니 보기</h3>
<table>
<tr><th>도서명</th><th>출판사</th><th>저자</th><th>가격</th><th>수량</th><th>삭제</th></tr>
<%
	for(int i=0;i<list.size();i++){
		ITBook book = list.get(i); %>
		<tr><td><%=book.getTitle()%></td>
			<td><%=book.getPub()%></td>
			<td><%=book.getAuthor()%></td>
			<td class="num"><%=book.getPrice()%></td>
			<td class="num">
				<input type="number" id='qty<%=i%>' value="<%=book.getQty()%>">
				<button type="button" onclick="update_qty(<%=i%>);">변경</button>
			</td>
			<td><button type="button" onclick="remove(<%=i%>);">삭제</button>
		</tr>
<%	}
%>
<tfoot>
	<tr><td></td><td></td><td>총계</td><td>W <span id="total"><%=total%></span></td><td></td><td></td></tr>
</tfoot>
</table>
<p>
<div>
	[<a href="javascript:cartEmpty();">장바구니 비우기</a>]
	[<a href="javascript:order();">결제하기</a>]
</div>
<hr>
<div><label>계속 쇼핑</label>
	[
	<a href="shop?cmd=prog&page=1">1</a>
	<a href="shop?cmd=prog&page=2">2</a>
	<a href="shop?cmd=prog&page=3">3</a>
	<a href="shop?cmd=prog&page=4">4</a>
	]
</div>
</main>
</body>
</html>