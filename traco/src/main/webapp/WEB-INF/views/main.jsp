<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			<div class="frame"></div>
		</section>
		<div>"${member_seq}"</div>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	<script>
	
	</script>
</body>
</html>