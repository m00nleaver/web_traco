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
					<th style="width:50px;">NO</th>
					<th style="width:200px;">카테고리</th>
					<th style="width:350px;">제목</th>
					<th style="width:100px;">글쓴이</th>
					<th style="width:350px;">날짜</th>
					<th style="width:100px;">조회수</th>
					<th style="width:50px;">삭제</th>
				</tr>
				
				<c:forEach items="${list}" var="pdto">
				<tr>
					<td>${pdto.seq}</td>
					<td>${pdto.ctg}</td>
					<td><a href='/traco/community/communityview.do?boardm_seq=${pdto.seq}' target="_blank">${pdto.title}</a></td>
					<td>${pdto.name}</td>
					<td>${pdto.date}</td>
					<td>${pdto.cnt}</td>
					<td> <!--seq 넘기기  -->
						<span class="glyphicon glyphicon-trash" onclick="location.href='/traco/admin/cdel.do?seq=${pdto.seq}&memseq=${pdto.memseq}';"></span>
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