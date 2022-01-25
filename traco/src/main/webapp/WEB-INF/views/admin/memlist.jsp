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
.plist {
	width: 1000px;
	margin: 0 auto;
}

.box {
	width: 1000px;
	margin: -130px auto 20px auto;
	text-align: right;
}

tr th {
	text-align: center;
}

.table>tbody>tr>td {
	text-align: center;
	vertical-align: middle;
}

td>span:hover {
	color: cornflowerblue;
	cursor: pointer;
}

.pagebar {
	text-align: center;
	margin-top: 20px;
	
}
</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/admin/admininc/adminheader.jsp"%>

		<section class="content admin">
			<div class="box">
				<input type="button" class="btn btn-info"
					onclick="location.href='/traco/admin/adminmain.do';" value="메인메뉴">
			</div>


			<table class="table table-bordered plist">
				<tr style="background-color: #CCC;">
					<th style="width: 45px;">NO</th>
					<th style="width: 105px;">이름</th>
					<th style="width: 150px;">ID</th>
					<th style="width: 300px;">이메일</th>
					<th style="width: 50px;">성별</th>
					<th style="width: 100px;">삭제</th>
				</tr>

				<c:forEach items="${list}" var="pdto">
					<tr>
						<td>${pdto.memseq}</td>
						<td>${pdto.memname}</td>
						<td>${pdto.id}</td>
						<td>${pdto.email}</td>
						<td><c:choose>
								<c:when test="${pdto.gender eq 'm'}">남자</c:when>
								<c:when test="${pdto.gender eq 'f'}">여자</c:when>
							</c:choose></td>
						<td><span class="glyphicon glyphicon-trash"
							onclick="location.href='/traco/admin/memdel.do?seq=${pdto.memseq}';"></span>
						</td>
					</tr>
				</c:forEach>
			</table>

			<div class="pagebar">${pagebar}</div>

		</section>

	</main>
	<script>
	
	</script>
</body>
</html>