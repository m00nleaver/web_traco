<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
	.margin { min-height: 1300px;
  			 margin-left: 30px; }

	.margin .rok { margin-top: 50px;
				   padding: 50px;
				   border: 1px solid black; 
				   font-size: 40px;
				   text-align: center;
	}
	
	.margin .rok. .btn btn-default { width: 50%; }
	
</style>
</head>
<body>
	<main class="main">

		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="margin">
	
				<div class="rok">
						예약이 완료되었습니다. <br>
						입금계좌: 신한은행 115-741-598254 <br>
						7일 이내에 입금이 완료되지 않을 경우 취소처리 됩니다.<br>
						감사합니다.<br>
					
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
	