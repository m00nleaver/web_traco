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

</style>
</head>
<body>

	<div class="container">
		<h1 class="page-header"><small></small></h1>
	</div>
	<script>
	<c:if test="${result==1}">
	//성공
	alert('승인완료');
	location.href = '/traco/admin/fconfirm.do';
	</c:if>
	
	<c:if test="${result!=1}">
	//실패
	alert('failed');
	history.back();
	</c:if>
	</script>
</body>
</html>