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
.rez_box{
text-align: center;
padding: 50px;
border: 1px solid gray;
}
</style>
</head>
<body>
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="content">
			<div class="rez_box">
				<h3>예약 주문이 완료되었습니다.</h3>
				<p>예약 확정을 위해서는 24시간 이내로 입금을 완료하여 주십시오.</p>
				<input type="button" value="확인" style= float:right;
						class="btn btn-default" 
						onclick="location.href='/traco/main.do';">		
			</div>
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>
	<script>
	
	</script>
</body>
</html>