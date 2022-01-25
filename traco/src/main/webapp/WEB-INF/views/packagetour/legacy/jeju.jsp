<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/traco/asset/css/bootstrap4.css">
<link rel="stylesheet" href="/traco/asset/css/main.css">

<script src="/traco/asset/js/jquery-1.12.4.js"></script>
<script src="/traco/asset/js/bootstrap4.js"></script>


<style>


img {
	width: 20rem;
	
	
}

.card {

	border: 3px solid black;

	margin : auto;
}



section.content {
	padding-left: 40px;
	padding-right: 40px;
}


div.card{

	margin: 0px auto;
}


.card-text {

display: inline;

}


.detail {

display: inline;
float : right;
}


.chip {
  display: inline-block;
  padding: 0 25px;
  height: 50px;
  font-size: 16px;
  line-height: 50px;
  border-radius: 25px;
  background-color: #f1f1f1;
}

.chip img {
  float: left;
  margin: 0 10px 0 -25px;
  height: 50px;
  width: 50px;
  border-radius: 50%;
}


</style>




</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
		
		
		<table class="table table-bordered list">	
			<tr>
				<th>제주도 추천 상품</th>
			
			</tr>
			<tr>
				<td>
					<form method="POST" action ="/traco/packagetour/detailpackage.do">
						<div class="card" style="width: 15rem;">
						  <img src="/traco/asset/images/cat03_big.jpg" class="card-img-top" alt="...">
						  <div class="card-body">
						    <h5 class="card-title" name="title">[제주]아시아나 한라산등반 당일치기</h5>
						    <h5 class="card-text">129000원</h5>
							<button type="submit" class="btn btn-primary detail" onclick="location.href='/traco/packagetour/detailpackage.do';">상세보기</button>
						  </div>
						</div>
					</form>				
				</td>
				<td>
					<div class="card" style="width: 15rem;">
					  <img src="/traco/asset/images/cat03_big.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <h5 class="card-title">[제주]아시아나 한라산등반 당일치기</h5>
					    <h5 class="card-text">129000원</h5>
						<button type="button" class="btn btn-primary detail" >상세보기</button>
					  </div>
					</div>					
				</td>
				<td>
					<div class="card" style="width: 15rem;">
					  <img src="/traco/asset/images/cat03_big.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <h5 class="card-title">[제주]아시아나 한라산등반 당일치기</h5>
					    <h5 class="card-text">129000원</h5>
						<button type="button" class="btn btn-primary detail">상세보기</button>
					  </div>
					</div>					
				</td>
				<td>
					<div class="card" style="width: 15rem;">
					  <img src="/traco/asset/images/cat03_big.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <h5 class="card-title">[제주]아시아나 한라산등반 당일치기</h5>
					    <h5 class="card-text">129000원</h5>
						<button type="button" class="btn btn-primary detail">상세보기</button>
					  </div>
					</div>					
				</td>
			</tr>
		
		
		</table>
		
		<table class="table table-bordered list">	
			<tr>
				<th>해시태그</th>
			</tr>
			<tr>
				<td>
				<div class="chip">
				  John Doe
				</div>
				</td>			
			
			</tr>
			
			<tr>
				<td>
					<div class="card" style="width: 15rem;">
					  <img src="/traco/asset/images/cat03_big.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <h5 class="card-title">[제주]아시아나 한라산등반 당일치기</h5>
					    <h5 class="card-text">129000원<h5>
						<button type="button" class="btn btn-primary detail">상세보기</button>
					  </div>
					</div>					
				</td>
				<td>
					<div class="card" style="width: 15rem;">
					  <img src="/traco/asset/images/cat03_big.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <h5 class="card-title">[제주]아시아나 한라산등반 당일치기</h5>
					    <h5 class="card-text">129000원<h5>
						<button type="button" class="btn btn-primary detail" >상세보기</button>
					  </div>
					</div>					
				</td>
				<td>
					<div class="card" style="width: 15rem;">
					  <img src="/traco/asset/images/cat03_big.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <h5 class="card-title">[제주]아시아나 한라산등반 당일치기</h5>
					    <h5 class="card-text">129000원<h5>
						<button type="button" class="btn btn-primary detail">상세보기</button>
					  </div>
					</div>					
				</td>
				<td>
					<div class="card" style="width: 15rem;">
					  <img src="/traco/asset/images/cat03_big.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <h5 class="card-title">[제주]아시아나 한라산등반 당일치기</h5>
					    <h5 class="card-text">129000원<h5>
						<button type="button" class="btn btn-primary detail">상세보기</button>
					  </div>
					</div>					
				</td>
			</tr>
		
		
		</table>		

			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	<script>
		
		

	</script>
</body>
</html>