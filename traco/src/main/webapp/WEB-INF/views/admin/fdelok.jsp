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
</style>
</head>
<body>

	<div class="container">
		<h1 class="page-header">
			<small></small>
		</h1>
	</div>
	<script>
		<c:if test="${result==1}">
		//성공
		alert('삭제완료');
		location.href = '/traco/admin/flist.do';
		</c:if>

		<c:if test="${result==0}">
		//실패
		alert('삭제실패');
		history.back();
		</c:if>
	</script>
</body>
</html>