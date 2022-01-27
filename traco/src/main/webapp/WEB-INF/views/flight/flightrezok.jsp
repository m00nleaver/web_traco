<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="content">
		</section>
			<div class="alertmessage">
				<h3>예약 주문이 완료되었습니다.</h3>
				<p>예약 확정을 위해서는 24시간 이내로 아래 계좌로 입금하여 주십시오.</p>
				<input type="text" name="abtbankname">
				<input type="text" name="abtaccount">			
			</div>
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>
	<script>
	$('input[name=abtaccount]').val('${}');
	</script>
</body>
</html>