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
					<th style="width:255px;">자동차명</th>
					<th style="width:100px;">자동차종류</th>
					<th style="width:100px;">상품여부</th>
					<th style="width:200px;">인수장소</th>
					<th style="width:150px;">가격</th>
					<th style="width:120px;">수정/삭제</th>
				</tr>
				
				<c:forEach items="${rlist}" var="pdto">
				<tr>
					<td>${pdto.carseq }</td>
					<td>${pdto.carname }</td>
					<td>${pdto.kindname}</td>
					<td>${pdto.cstatus}</td>
					<td>${pdto.areaname}</td>
					<td>${pdto.carprice }</td>
					<td> <!--seq 넘기기  -->
						<span class="glyphicon glyphicon-edit" onclick="location.href='/traco/admin/redit.do?seq=${pdto.carseq}&kind=${pdto.kindname}&status=${pdto.cstatus}';"></span> / 
						<span class="glyphicon glyphicon-trash" onclick="location.href='/traco/admin/rdel.do?seq=${pdto.carseq}';"></span>
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