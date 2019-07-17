<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<!-- 타이틀, 수량, 가격, 총가격 -->
	<div class="container">
		<table class="table table-hover">
			<tr>
				<td>
					전체선택
					<input type="checkbox">
				</td>
				<td>제품명</td>
				<td>Option</td>
				<td>수량</td>
				<td>가격</td>
				<td>합계</td>
			</tr>
			
			<c:forEach items="${cartList}" var="cart" varStatus="i">
			<tr id="del${i}">
				<td><input type="checkbox" title="del${i}" class="delNum" value="${cart.num}"></td>
				<td>${cart.title}</td>
				<td>${cart.contents}</td>
				<td><input type="number" id="amount${i.index}" class="amount" value="${cart.amount}"><input title="amount${i.index}" data-num="${cart.num}" class="updateBtn" type="button" value="수정"> </td>
				<td>${cart.price}</td>
				<td>${cart.amount*cart.price}</td>
			</tr>
			</c:forEach>
			
		</table> 
		<div>
			<button class="btn btn-danger" id="delBtn">Delete</button>
		</div>
		
	</div>
	<script type="text/javascript">
		$("#delBtn").click(function() {
			var num = [];
			var del=[];
			$(".delNum").each(function(d) {
				 if($(this).prop("checked")){
					num.push($(this).val())
					del.push($(this).attr("title"));
				}
			});
			
			jQuery.ajaxSettings.traditional=true;
			
			$.ajax({
				url:"cartDelete", 
				type:"POST",
				data:{
					num:num
				},
				success:function(data){
					for(var i=0;i<del.length;i++){
						$("#"+del[i]).remove();
					}
				},
				error:function(){
					
				}
			});
			
		});
	
		$(".updateBtn").click(function() {
			//num
			//amount
			//var id = $(this).attr("title");
			//var amount = $("#"+id).val();
			var amount = $(this).prev().val();
			var num =$(this).attr("data-num");
			
			$.ajax({
				url:"./cartUpdate",
				type:"POST",
				data:{
					amount:amount,
					num:num
				},
				success:function(data) {
					alert(data);
				}
				
			});
			
			
		});
	</script>

</body>
</html>