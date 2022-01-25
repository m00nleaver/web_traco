<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	.panel{width:200px; margin:-100px auto;}
</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/admin/admininc/adminheader.jsp" %>
		<section class="content admin">
			<div class="panel panel-default">
				<div class="panel-heading">삭제하기</div>
				<div class="panel-body">
				
					<input type="button" value="돌아가기"
						class="btn btn-default"
						onclick="history.back();">
					
					<input type="button" value="삭제하기"
						class="btn btn-primary"
						onclick="location.href='/traco/admin/memdelok.do?seq=${seq}';">
					
				</div>
			</div>
		
		</section>
		
	</main>
	<script>
	
	</script>
</body>
</html>