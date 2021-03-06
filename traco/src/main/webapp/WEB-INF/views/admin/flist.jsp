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
	td > span:hover{color:cornflowerblue; cursor:pointer;}
	h1{margin-left:90px;}
</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/admin/admininc/adminheader.jsp" %>
			
		<section class="content admin">
		<div class="box"><input type="button" class="btn btn-info" onclick="location.href='/traco/admin/adminmain.do';" value="메인메뉴"></div>
		<h1>항공권 리스트</h1>
			<table class="table table-bordered plist">
				<tr style="background-color:#CCC;">
					<th style="width:45px;">NO</th>
					<th style="width:115px;">상품여부</th>
					<th style="width:150px;">출발지</th>
					<th style="width:150px;">도착지</th>
					<th style="width:150px;">이륙일</th>
					<th style="width:100px;">시간</th>
					<th style="width:170px;">가격</th>
					<th style="width:120px;">수정/삭제</th>
				</tr>
				
				<c:forEach items="${flist}" var="pdto">
				<tr>
					<td>${pdto.airseq}</td>
					<td>${pdto.pstatus}</td>
					<td>${pdto.departname }</td>
					<td>${pdto.arrivalname }</td>
					<td>${pdto.airdate1}</td>
					<td>${pdto.airdate2}</td>
					<td title="성인: ${pdto.padultprice}원 아동: ${pdto.pkidprice}원 유아: ${pdto.ptoddleprice}원">성인: ${pdto.padultprice}원</td>
					<td> <!--seq 넘기기  -->
						<span class="glyphicon glyphicon-edit" onclick="location.href='/traco/admin/fedit.do?seq=${pdto.airseq}&status=${pdto.pstatus}';"></span> / 
						<span class="glyphicon glyphicon-trash" onclick="location.href='/traco/admin/fdel.do?seq=${pdto.airseq}';"></span>
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