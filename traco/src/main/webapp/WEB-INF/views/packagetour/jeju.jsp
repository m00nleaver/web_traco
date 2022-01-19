<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>

<style>

img {
	width: 20rem;
	border: 3px solid black;
	
	
}

.card {

	border: 3px solid black;

	margin : auto;
}

.col-sm-3 {


}


section.content {
	padding-left: 40px;
	padding-right: 40px;
}

.btn {
	display: inline;
}

.price-btn {
  display: flex;
  justify-content: space-between;
}

</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
		<h1>제주도 추천상품</h1>
			
		<div class="container-fluid">
		
		<!-- (for문으로 4개의 이미지 처리) * 4 행 -->
            <div class="row">
                <div class="col-sm-3">
		      				<div class="card" style="width: 20rem;">
							  <img src="/traco/asset/images/logo/logo.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">제목</h5>
							    <p class="card-text">내용</p>
								<div class="price-btn">
							    	<span class="card-text">가격</span>
							    	<a href="#" class="btn btn-primary">Go</a>
							    </div>
							  </div>
							</div> 	
                </div>
                
                <div class="col-sm-3">
		      				<div class="card" style="width: 20rem;">
							  <img src="/traco/asset/images/logo/logo.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">Card title</h5>
							    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							    <a href="#" class="btn btn-primary">Go somewhere</a>
							  </div>
							</div> 	
                </div>
                <div class="col-sm-3">
		      				<div class="card" style="width: 20rem;">
							  <img src="/traco/asset/images/logo/logo.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">Card title</h5>
							    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							    <a href="#" class="btn btn-primary">Go somewhere</a>
							  </div>
							</div> 	
                </div>
                <div class="col-sm-3">
		      				<div class="card" style="width: 20rem;">
							  <img src="/traco/asset/images/logo/logo.png" class="card-img-top" alt="...">
							  <div class="card-body">
							    <h5 class="card-title">Card title</h5>
							    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
							    <a href="#" class="btn btn-primary">Go somewhere</a>
							  </div>
							</div> 	
                </div>
            </div>
        </div>
			


				
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	<script>
	
	</script>
</body>
</html>