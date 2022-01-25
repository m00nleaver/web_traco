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

</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			
			
			<table class="content">
				<tr>
					<th>제주도 패키지 추천 상품 화면</th>
				</tr>
				
				<tr>
					<td>
						<a href="/traco/packagetour/packagetotalsearch.do?region=jeju&mode=total">전체상품 보기</a>
					</td>
				</tr>
				
				
			
			</table>
			
			
							<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.pkname}</td>
				</tr>
				</c:forEach>
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	<script>
	
	</script>
</body>
</html>