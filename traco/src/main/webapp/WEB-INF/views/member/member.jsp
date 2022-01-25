<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

	.panel {
		width: 200px;
		margin: 0 auto; 
		margin-top: 150px;
		text-align: center;
	}
	
	.info {
		margin-bottom: 10px;
	}

</style>
</head>
<body>
	<!-- member/member.jsp -->
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			
			<div class="panel panel-default">
				<div class="panel-heading">회원</div>
				<div class="panel-body">
								
					<c:if test="${not empty member_id}">
					<input type="button" value="로그아웃"
						class="btn btn-default"
						onclick="location.href='/traco/member/logoutok.do';">
					</c:if>
					
					<c:if test="${empty member_id}">
					<input type="button" value="로그인"
						class="btn btn-default"
						onclick="location.href='/traco/member/login.do';">
						
					<hr>
					
								
				
			
					<form method="POST" action="/traco/member/loginok.do">
						<input type="hidden" name="member_id" value="xtmy6gw9">
						<input type="hidden" name="member_pw" value="3ezHJ">
						<input type="submit" value="최민기" class="btn btn-default">
					</form>
					
					</c:if>
				</div>
			</div>
			
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	<script>
	
	</script>
</body>
</html>







