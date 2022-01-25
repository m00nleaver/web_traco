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
	.plist{width:1200px; margin:0 auto;}
	.box {width:1000px; margin:-130px auto 20px auto; text-align:right;}
	tr th {text-align:center;}
	.table > tbody > tr > td {text-align:center; vertical-align:middle;}
	td > span:hover{color:cornflowerblue; cursor:pointer;}
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
					<th style="width:260px;">상품명</th>
					<th style="width:90px;">상품개수</th>
					<th style="width:90px;">상품 종류</th>
					<th style="width:90px;">상품여부</th>
					<th style="width:230px;">기간</th>
					<th style="width:170px;">가격</th>
					<th style="width:120px;">수정/삭제</th>
				</tr>
				
				<c:forEach items="${plist}" var="pdto">
				<tr>
					<td>${pdto.pseq }</td>
					<td>${pdto.pname }</td>
					<td>${pdto.pcount }</td>
					<td>패키지</td>
					<td>${pdto.pstatus}</td>
					<td>${pdto.pstart} ~ ${pdto.pend }</td>
					<td title="성인: ${pdto.padultprice}원 아동: ${pdto.pkidprice}원 유아: ${pdto.ptoddleprice}원">성인: ${pdto.padultprice}원</td>
					<td> <!--seq 넘기기  -->
						<span class="glyphicon glyphicon-edit" onclick="location.href='/traco/admin/pedit.do?seq=${pdto.pseq}';"></span> / 
						<span class="glyphicon glyphicon-trash" onclick="location.href='/traco/admin/pdel.do?seq=${pdto.pseq}';"></span>
					</td>
				</tr>
				</c:forEach>
			</table>
			
		</section>
		
	</main>
	<script>
	
	</script>
</body>
</html>