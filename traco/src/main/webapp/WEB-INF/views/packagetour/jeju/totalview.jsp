<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/css/ion.rangeSlider.min.css"/>

<script src="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/js/ion.rangeSlider.min.js"></script>


<style>
	table, th, td {
	  border: 1px solid black;
	/*   border-collapse: collapse;
	 */}
	 
	 #taglist {
	  width: 214px;
	  height: 50px;
	 }
	 
</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
		
			<div class="search">
				<form method="GET" action="/traco/packagetour/jeju/totalview.do">
					<table>
						<tr>
							<th>필터</th>
						</tr>
						<tr><td id="taglist">
								<label for="hashtag">해시태그</label>
								<select id="hashtag" name="hashtag">
										<option value="전체">전체</option>
									<c:forEach items="${tagList}" var="dto">
										<option value="${dto.tagName}">${dto.tagName}</option>
									</c:forEach>
								</select>
						</td></tr>
						
						
						
						<tr><td>
						    <label for="startdate">출발일자</label>
							<input type="date" id="startdate" name="startdate">
						</td></tr>
						
						
						<tr><td>
						    <label for="price">출발일자</label>
							<input type="text" class="js-range-slider" id="price" name="price" value="" />
							
						</td></tr>
						
						
						<tr>
						<th>정렬</th>
						</tr>
						
						<tr>
							<td><input type="submit" value="판매량순" name="qorder" class="btn btn-default tagbtn"></td>
							<td><input type="submit" value="낮은가격순" name="ploworder" class="btn btn-default tagbtn"></td>
							<td><input type="submit" value="높은가격순" name="phighorder" class="btn btn-default tagbtn"></td>
							<td><input type="submit" value="날짜순" name="dateorder" class="btn btn-default tagbtn"></td>
						</tr>
						
						
						<tr>
							<td>
						  		<input type="submit" value="검색">
						  	</td>
						</tr>						
					</table>
				</form>
			</div>
			
			
			<button type="button">click me</button>

		
		
		
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
			
			<c:forEach items="${searchList}" var="dto">
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
					</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	
	<script>
	
/* 	From list.jsp
  
 
 	<c:if test="${map.searchmode == 'y'}">
	//검색 상태를 유지
	$('select[name=column]').val('${map.column}');
	$('input[name=word]').val('${map.word}');
	</c:if> */
	
	
	$(".js-range-slider").ionRangeSlider({
        type: "double",
        min: 0,
        max: 1000000,
        from: 0,
        to: 1000000,
        grid: true,
        onFinish: function (data) {
            // Called then action is done and mouse is released
    		console.log(data.from);
            console.log(data.to);
        }
    });
	
	$("button[type=button]").click( function() {
		$("button[type=button]").text(`${hello}`);
		} );

	
	
    
	</script>
</body>
</html>