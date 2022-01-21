<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<!-- community/communityedit.jsp > community/communityeditok.jsp -->
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	<script>
	
		<c:if test="${result == 1}">
		//성공
		location.href = '/traco/community/communityview.do?boardm_seq=${boardm_seq}';
		</c:if>
		
		<c:if test="${result == 0}">
		//실패
		alert('failed');
		history.back();
		</c:if>
	
	</script>
</body>
</html>







