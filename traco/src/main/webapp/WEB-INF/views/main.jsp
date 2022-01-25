<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
#myCarousel {
	width: 900px;
	margin: 0 auto;
}
.marign{
	margin-top: 100px;
}
.col-md-3 {
    width: 24%;
}
</style>
</head>
<body>

	<main class="main">

		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="marign">
			<div class="container">
			
				<div id="myCarousel" class="carousel slide" data-ride="carousel"">
					
					<ol class="carousel-indicators">
					<c:forEach items="${banner}" var="dto">
					
						<c:if test="${dto.banneri_seq == 1}">
						<li data-target="#myCarousel" data-slide-to="{dto.banneri_seq}" class="active"></li>
						</c:if>
						
						<c:if test="${dto.banneri_seq > 1}">
						<li data-target="#myCarousel" data-slide-to="{dto.banneri_seq}"></li>
						</c:if>
						
					</c:forEach>
					
<!-- 					<li data-target="#myCarousel" data-slide-to="0" class="active"></li> -->
<!-- 						<li data-target="#myCarousel" data-slide-to="1"></li> -->
<!-- 						<li data-target="#myCarousel" data-slide-to="2"></li> -->
<!-- 						<li data-target="#myCarousel" data-slide-to="3"></li> -->


					</ol>

					<div class="carousel-inner">
					<c:forEach items="${banner}" var="dto">
					<c:if test="${dto.banneri_seq == 1}">
						<div class="item active">
							<img src="/traco/asset/images/banner/${dto.banneri_imageurl}" alt=""
								style="width: 100%; height: 200px;">
						</div>
					</c:if>
					<c:if test="${dto.banneri_seq > 1}">
						<div class="item">
							<img src="/traco/asset/images/banner/${dto.banneri_imageurl}" alt=""
								style="width: 100%; height: 200px;">
						</div>
					</c:if>
					</c:forEach>
<!-- 						<div class="item active"> -->
<!-- 							<img src="/traco/asset/images/cat01.jpg" alt="Los Angeles" -->
<!-- 								style="width: 100%; height: 200px;"> -->
<!-- 						</div> -->
<!-- 						<div class="item"> -->
<!-- 							<img src="/traco/asset/images/cat02.jpg" alt="Chicago" -->
<!-- 								style="width: 100%; height: 200px;"> -->
<!-- 						</div> -->

					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</section>

		<section class="marign">
			<div class="container">
				<h1>패키지</h1>

				<c:forEach items="${toppackage}" var="dto">
				<div class="row">
					<div class="col-sm-6 col-md-3">
						<div class="thumbnail" onclick="location.href='/traco/member/login.do';">
							<img
								src="https://cdn.pixabay.com/photo/2016/01/19/17/57/car-1149997_960_720.jpg"
								alt="...">
							<div class="caption">
								<p>${dto.area_name }</p>
								<h4>${dto.pkgpm_name}</h4>
								<p>${dto.pkgpm_adultprice}원 / 성인</p><p>${dto.pstatus}</p>
							</div>
						</div>
					</div>
				</c:forEach>							
				</div>
			</div>
		</section>
		
		<section class="marign">
			<div class="container">
				<h1>미니투어</h1>

				<c:forEach items="${topmini}" var="dto">
				<div class="row">
					<div class="col-sm-6 col-md-3">
						<div class="thumbnail" onclick="location.href='/traco/member/login.do';">
							<img
								src="https://cdn.pixabay.com/photo/2016/01/19/17/57/car-1149997_960_720.jpg"
								alt="...">
							<div class="caption">
								<p>${dto.minictg_name} | ${dto.area_name}</p>
								<h4>${dto.minipm_name}</h4>
								<p>${dto.minipm_price1}원 / 성인</p><p>${dto.pstatus}</p>
							</div>
						</div>
					</div>
				</c:forEach>							
				</div>
			</div>
		</section>

		<div>"${member_seq}" </div>
	
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>
	<script>
		$('.thumbnail').css('cursor','pointer');
		
		$('.thumbnail').hover(function(){
			$(this).css('transform','translate(10px,-10px)');
			$(this).css('box-shadow','10px 10px 10px 0px rgb(68 68 68 / 20%)');
		},function(){
			$(this).css('transform','translate(0px,0px)');
			$(this).css('box-shadow','0px 0px 0px 0px');   
		});
	</script>
</body>
</html>