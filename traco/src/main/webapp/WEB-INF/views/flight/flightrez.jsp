<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>

<style>
form {
	border: 1px solid black;
}
.box{
height: 20px;
width: 200px;
}
</style>
<link href="asset/css/tabs.css" rel="stylesheet">
<script src="asset/js/tabs.js" type="text/javascript"></script>

</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="content">
			
			
			<!-- ㄴㅇㄹ -->
			
			<div class="rezpreview">
			결과
			<c:forEach items="${list3}" var="dto">
			<div class=" box">${dto.airplanp_seq}</div>
			</c:forEach>
			</div>
	
			<form>
			
			
			
			
			</form>
			
			
			

		</section>

		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>

	<script>
	
	
	
	 
	</script>
</body>

</html>