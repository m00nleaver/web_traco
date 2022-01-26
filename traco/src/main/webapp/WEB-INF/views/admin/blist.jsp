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
	.plist{width:650px; margin:0 auto;}
	.box {width:1000px; margin:-130px auto 20px auto; text-align:right;}
	tr th {text-align:center;}
	.table > tbody > tr > td {text-align:center; vertical-align:middle;}
	td > span:hover{color:cornflowerblue; cursor:pointer;}
	.banner{width:220px;}
		h1 {
	width: 1000px;
	margin-left:300px;
	font-size: 30px;
}
</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/admin/admininc/adminheader.jsp" %>
			
		<section class="content admin">
		<div class="box"><input type="button" class="btn btn-info" onclick="location.href='/traco/admin/adminmain.do';" value="메인메뉴"></div>
		<h1>배너 리스트</h1>
			<form method="POST" onSubmit="return form_submit()" action="/traco/admin/blistok.do">
			<table class="table table-bordered plist">
				<tr style="background-color:#CCC;">
					<th style="width:45px;">NO</th>
					<th style="width:235px;">이미지</th>
					<th style="width:150px;">이미지명</th>
					<th style="width:100px;">사용여부</th>
					<th style="width:120px;">수정/삭제</th>
				</tr>
				
				<c:forEach items="${list}" var="pdto">
				<tr>
					<td>${pdto.bseq }</td>
					<td><img src="/traco/asset/images/banner/${pdto.bfile}"  alt="배너이미지" class="banner"></td>
					<td>${pdto.bname}</td>
					<td><c:if test="${pdto.status=='사용중'}">${pdto.status}<input type="submit" class="btn btn-danger" value="사용중지"><input type="hidden" value="사용중지" name="status"><input type="hidden" value="${pdto.bseq}" name="seq"></c:if><c:if test="${pdto.status=='사용중지'}">${pdto.status}<input type="submit" class="btn btn-danger" value="사용중"><input type="hidden" value="사용중" name="status"><input type="hidden" value="${pdto.bseq}" name="seq"></c:if></td>
					<td> <!--seq 넘기기  -->
						<span class="glyphicon glyphicon-edit" onclick="location.href='/traco/admin/bedit.do?seq=${pdto.bseq}';"></span> / 
						<span class="glyphicon glyphicon-trash" onclick="location.href='/traco/admin/bdel.do?seq=${pdto.bseq}';"></span>
					</td>
				</tr>
				</c:forEach>
			</table>
			</form>
		</section>
		
	</main>
	<script>
	function form_submit()
	{
	/* confirm 함수는 확인창 결과값으로 TRUE 와 FALSE 값을 return 하게 된다*/
	var check_submit=confirm('바꾸시겠습니까?');

	return check_submit;
	}
	</script>
</body>
</html>