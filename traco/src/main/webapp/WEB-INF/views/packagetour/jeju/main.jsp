<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>


<style>

table, th, td {
  border: 1px solid black;
/*   border-collapse: collapse;
 */}

</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			
			
			
			<table class="content">
				<tr>
					<th>제주도 패키지 추천 상품 화면</th>
					<th></th>
					<th>
						<a href="/traco/packagetour/jeju/totalview.do">전체상품 보기</a>
					</th>
				</tr>	
				<tr>
					<th>썸네일</th>
					<th>제목</th>
					<th>가격</th>
					<th>자세히</th>				
				</tr>
			
			<c:forEach items="${recomList}" var="dto">
					<tr>
						<td>${dto.pkThumbSeq}</td>
						<td>${dto.pkName}</td>
						<td>${dto.adultPrice}</td>
						<td>
							<input type="button" value="자세히"
									class="btn btn-primary"
									onclick="location.href='/traco/packagetour/jeju/view.do?pkSeq=${dto.pkSeq}';">
						</td>
					</tr>
				</c:forEach> 
			
			</table>
			
			
			
			
			
			<!-- 해시태그 -->

			<div class="search">
				<form method="GET" action="/traco/packagetour/jeju/main.do">
				<table>
					<tr>
						<th>해시태그 목록</th>
					</tr>
					
					<tr>
						<c:forEach items="${tagList}" var="dto">
							<td>
								<input type="submit" value="${dto.tagName}" name="hashtag" class="btn btn-default tagbtn">
							</td>
						</c:forEach>
					
					</tr>
										
				</table>
				
				<table>
				
					<c:forEach items="${hashList}" var="dto">
					<tr>
						<td>${dto.pkThumbSeq}</td>
						<td>${dto.pkName}</td>
						<td>${dto.adultPrice}</td>
						<td>
							<input type="button" value="자세히"
									class="btn btn-primary"
									onclick="location.href='/traco/packagetour/jeju/view.do?pkSeq=${dto.pkSeq}';">
						</td>
					</tr>
					</c:forEach> 
				</table>
				
				</form>
			</div>		
			
		
		
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	<script>
		
	/* 	if 해시태그 있으면 , scroll to 그 위치
		https://velog.io/@ksh4820/JS-%EC%8A%A4%ED%81%AC%EB%A1%A4-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%EC%8A%A4%ED%81%AC%EB%A1%A4-%EC%9C%84%EC%B9%98-%EA%B5%AC%ED%95%98%EA%B8%B0
		https://developer.mozilla.org/en-US/docs/Web/API/Window/scrollTo
 */
	</script>
</body>
</html>