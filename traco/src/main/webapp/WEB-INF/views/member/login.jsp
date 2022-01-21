<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	.panel input {
		margin-bottom: 5px;
	}
	
	.panel input[type=submit] {
		margin-top: 10px;
	}
	
</style>
</head>
<body>
	<!-- member/login.jsp -->
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			
			<div class="panel panel-default">
				<div class="panel-heading">회원</div>
				<div class="panel-body">
					
					<form method="POST" action="/traco/member/loginok.do">
						<input type="text" name="member_id" class="form-control" placeholder="아이디" required autofocus>
						<input type="password" name="member_pw" class="form-control" placeholder="비밀번호" required>
						<input type="submit" value="로그인" class="btn btn-default">
					</form>
					
				</div>
			</div>
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	<script>
	
	</script>
</body>
</html>







