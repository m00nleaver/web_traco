<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	
	.content { min-height: 1000px;
  			 margin-left: 30px; }
	
	.btns { width: 100%; }
	
	 h2 { text-align: center; 
 	  font-size: 30px;}
 	  
	.searchcar .scar1, .scar2, .scar3 { cursor: pointer; }
	
	
	.table table-bordered list tr > th{ cursor: pointer; }


</style>
</head>
<body>
	<!-- 렌트카 리스트 화면 -->
	<main class="main">
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
		
			<h2>렌트카 검색 결과</h2>
			
			  <div class="searchcar">
					<div class="scar1">
						<img src="/traco/asset/images/rentcar1.jpg" alt="hotcar"
							onclick="location.href='/traco/rentcar/rentcardetail.do';"
								style="width: 100%; height: 200px;">
					</div>
					
					<hr>
					
					<div class="scar2">
						<img src="/traco/asset/images/rentcar2.jpg" alt="hotcar"
							onclick="location.href='/traco/rentcar/rentcardetail.do';"
								style="width: 100%; height: 200px;">
					</div>
					
					<hr>
					
					<div class="scar3">
						<img src="/traco/asset/images/rentcar3.jpg" alt="hotcar"
							onclick="location.href='/traco/rentcar/rentcardetail.do';"
								style="width: 100%; height: 200px;">
					</div>
				</div>	
		
		
		
		
		  <!--  <table class="table table-bordered list">
			<c:forEach var="dto" items="${list}">
					<tr>
						<th onclick="location.href='/traco/rentcar/rentcardetail.do';">렌트카 번호</th>
						<th>차량명</th>
						<th>탑승인원</th>
						<th>차량재고</th>
						<th>가격</th>
						<th>제조사</th>
						<th>연료</th>
						<th>차 종류</th>
						<th>지역</th>
						<th>썸네일이미지</th>
						<th>대여상태</th>

						
					</tr>
					
						
		    		<tr>
		    			<td onclick="location.href='/traco/rentcar/rentcardetail.do';">${dto.carprod_seq}</td>
		    			<td>${dto.carprod_name}</td>
						<td>${dto.carprod_people}</td>
						<td>${dto.carprod_number}</td>
						<td>${dto.carprod_price}</td>
						<td>${dto.carmanufacturer_seq}</td>
						<td>${dto.carfuel_seq}</td>
						<td>${dto.carkind_seq}</td>
						<td>${dto.area_seq}</td>
						<td>${dto.thumbnaili_seq}</td>
						<td>${dto.status}</td>
		    		</tr>
		    </c:forEach>
	    
		</table> -->
		
		<div class="btns">
				<input type="button" value="돌아가기"
					class="btn btn-default"
					onclick="location.href='/traco/rentcar.do';">
		</div>
		
		</section>
		
		    
			
	<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>
   
   <script>
   
   </script>
</body>
</html>