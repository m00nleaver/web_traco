<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

	.panel {
		width: 700px;
		margin: 0 auto; 
		margin-top: 100px;
		text-align: left;
	}
	
	.panel-body div{
		margin-top: 30px;
	}
	.panel input[type=submit] {
		
		margin-top: 30px;
		width: 570px;
	}
	
	.panel .panel-body {
		width: 600px;
		margin: 0 auto; 
		text-align: left;
	}
	
</style>
</head>
<body>
	<!-- member/login.jsp -->
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
		
			<form method="POST" action="/traco/member/memberfind_pwok.do">
			<div class="panel panel-default">
				<div class="panel-heading">패스워드디찾기</div>
				<div class="panel-body">
										
						<div>아이디</div>
						<input type="text" id="member_id" name="member_id" class="form-control" placeholder="아이디" required autofocus>
						
												
						<div>이메일</div>
						<input type="text" name="member_email" class="form-control" placeholder="이메일" required>
						
						<input type="submit" value="비밀번호찾기" class="btn btn-primary">
					
				</div>
			</div>
			</form>
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	<script>

	</script>
</body>
</html>







