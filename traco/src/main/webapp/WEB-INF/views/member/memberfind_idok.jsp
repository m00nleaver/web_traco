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
	
	.panel input[type=button] {
		margin-top: 10px;
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
		
			<div class="panel panel-default">
				<div class="panel-heading">아이디찾기</div>
				<div class="panel-body">
						
						<c:if test="${not empty memberfind_id}">				
						<div style="text-align: center;">
							<div> 찾으신 ID정보입니다.<br><br> ID: ${memberfind_id}</div>
						</div>
						</c:if>	
						<c:if test="${empty memberfind_id}">	
						<div style="text-align: center;">
							<div>찾으시는 회원정보가 존재하지 않습니다.</div>
						</div>
						</c:if>
						<br>
						
						<input type="button" value="로그인"		class="btn btn-primary"	onclick="location.href='/traco/member/login.do';">														
						<input type="button" value="패스워드찾기" class="btn btn-primary" onclick="location.href='/traco/member/memberfind_pw.do';">
						<input type="button" value="뒤로가기" class="btn btn-primary" onclick="location.href='/traco/member/memberfind_id.do';">

						
					
				</div>
			</div>
		
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	<script>
	
	</script>
</body>
</html>







