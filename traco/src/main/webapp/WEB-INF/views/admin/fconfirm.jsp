<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	.plist{width:1000px; margin:0 auto;}
	.box {width:1000px; margin:-130px auto 20px auto; text-align:right;}
	tr th {text-align:center;}
	.table > tbody > tr > td {text-align:center; vertical-align:middle;}
	/* td > span:hover{color:cornflowerblue; cursor:pointer;} */
</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/admin/admininc/adminheader.jsp" %>
			
		<section class="content admin">
		<div class="box"><input type="button" class="btn btn-info" onclick="location.href='/traco/admin/adminmain.do';" value="메인메뉴"></div>
		
			<table class="table table-bordered plist">
				<tr style="background-color:#CCC;">
					<th style="width:45px;">NO</th>
					<th style="width:115px;">인원</th>
					<th style="width:150px;">출발일</th>
					<th style="width:150px;">출발시간</th>
					<th style="width:150px;">입금자</th>
					<th style="width:170px;">가격</th>
					<th style="width:100px;">입금여부</th>
					<th style="width:120px;">승인</th>
				</tr>
				
				<c:forEach items="${list}" var="pdto">
				<tr>
					<td>${pdto.rezseq}</td>
					<td title="성인: ${pdto.acnt}명 아동: ${pdto.kcnt}명 유아: ${pdto.tcnt}명">성인:${pdto.acnt}명</td>
					<td>${pdto.airdate1}</td>
					<td>${pdto.airdate2}</td>
					<td>${pdto.name}</td>
					<td>${pdto.price}원</td>
					<td>${pdto.status}</td>
					<td id="test">
						<input type="button" value="결제확인" class="btn btn-default">
						
					</td>
				</tr>
				</c:forEach>
			</table>
			
		</section>
		
	</main>
	<script>
	
		$('.btn').click(function(){
			document.querySelector("#test").innerHTML 
	        = "<span>결제확인</span>";
		});
	
		
		
	
	</script>
</body>
</html>