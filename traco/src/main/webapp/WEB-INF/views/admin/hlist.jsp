<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
.content.admin {
	width: 1000px;
	margin: 30px auto;
}

#box {
	width: 800px;
	height: 400px;
	margin: 0 auto;
}

#addbox {
	width: 300px;
	height: 300px;
	margin-right: 50px;
	float: left;
	text-align: center;
	vertical-align: middle;
}

#addbox input {
	height: 30px;
	margin-top: 125px;
	margin-bottom: 5px;
}

#btnbox {
	width: 100px;
	height: 300px;
	float: left;
	margin-right: 50px;
}

#btnbox input {
	margin: 70px 0 10px 10px;
}

#list {
	width: 250px;
	height: 300px;
	float: left
}

#box::after {
	content: "";
	display: block;
	clear: both;
}

.btn {
	width: 90px
}
</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/admin/admininc/adminheader.jsp"%>

		<%-- <section class="content admin">
		<h1>해쉬태그등록</h1>
			<form method="POST" onSubmit="return form_submit()" action="/traco/admin/hlistok.do">
			<div id="box">
				<div id="addbox"><input type="text" name="hash" ><br><span>해시태그 추가</span></div>
				<div id="btnbox"><input type="submit" value="ADD" class="btn btn-default" id="add"><input type="submit" value="REMOVE" class="btn btn-danger" id="remove"></div>
				<div id="list">
					<table style="width:200px; height:300px; margin:0 auto; text-align:center;">
					
						<tr>
							<td>
								<select multiple size="10" style="font-size:15px;">
								<c:forEach items="${hlist}" var="pdto">
									<option value="${pdto.hseq}">${pdto.hashtag}</option>
								</c:forEach>	
								</select>
							</td>
						</tr>
					
						
					</table>
				</div>
			</div>
			</form>
		</section> --%>

		<section class="content admin">
			<h1>해쉬태그등록</h1>

			<div id="box">

				<div id="addbox">
					<form id="form" onSubmit="return form_submit()">
						<input type="text" name="hash" id="text"><br> <span>해시태그
							추가</span>
					</form>
				</div>
				<div id="btnbox">

					<input type="button" value="Add" class="btn btn-default" id="add">

					<!-- <input type="button" value="Refresh" class="btn btn-info"
						id="refresh"> -->
						 <input type="button" value="Remove"
						class="btn btn-danger" id="remove">
				</div>

				<div id="list">
					<table
						style="width: 200px; height: 300px; margin: 0 auto; text-align: center;">

						<tr>
							<td>
								<form id="form1">
									<select multiple size="20" class="selbox" name="hashseq"
										style="font-size: 15px;">
										<c:forEach items="${list}" var="pdto">
											<option value="${pdto.hseq}">${pdto.hashtag}</option>
										</c:forEach>
									</select>
								</form>
							</td>
						</tr>


					</table>
				</div>
			</div>

		</section>



	</main>
	<script>
		function form_submit() {
			
				var check_submit = confirm('등록하시겠습니까?');
				return check_submit;
			
			/* confirm 함수는 확인창 결과값으로 TRUE 와 FALSE 값을 return 하게 된다*/

		}
		
		
		$('#add').click(()=>{

			$.ajax({
				type: 'POST',
				url: '/traco/admin/hlistdata.do',

				data: $('#form').serialize(),
				
				success: function(result) {
					console.log(result.result);
				}
			});
			alert('등록완료');
			$('#text').val('');
			
			$.ajax({
				type:'GET',
				url:'/traco/admin/hlistdata.do',
				dataType: 'json',
				success: function(result) {
					$('.selbox *').remove();
					result.forEach((item) => {	
						
						 $('.selbox').append('<option value="'+item.hashseq+'">'+item.hash+'</option>');
					 });
				},error:function(request,status,error){
			        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }

		
			});
			return false;
			
		});
		
		
		
		$('#refresh').click(()=>{ 
			
			$.ajax({
				type:'GET',
				url:'/traco/admin/hlistdata.do',
				dataType: 'json',
				success: function(result) {
					$('.selbox *').remove();
					result.forEach((item) => {	
						
						 $('.selbox').append('<option value="'+item.hashseq+'">'+item.hash+'</option>');
					 });
				},error:function(request,status,error){
			        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }

		
			});
		});
		
		$('#remove').click(()=>{

			$.ajax({
				type: 'POST',
				url: '/traco/admin/hlistdata.do',

				data: $('.selbox').serialize(),
				
				success: function(result) {
					console.log(result.result);
				}
			});
			alert('삭제완료');
			
			$.ajax({
				type:'GET',
				url:'/traco/admin/hlistdata.do',
				dataType: 'json',
				success: function(result) {
					$('.selbox *').remove();
					result.forEach((item) => {	
						
						 $('.selbox').append('<option value="'+item.hashseq+'">'+item.hash+'</option>');
					 });
				},error:function(request,status,error){
			        console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }

		
			});
			
			
		});
		
	</script>
</body>
</html>