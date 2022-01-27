<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>

<style>
form {
	border: 1px solid black;
}
</style>
<link href="asset/css/tabs.css" rel="stylesheet">
<script src="asset/js/tabs.js" type="text/javascript"></script>

</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="content">
			<!-- 조회박스 시작-->
			
			<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">왕복</li>
		<li class="tab-link" data-tab="tab-2">편도</li>
	</ul>


			<!-- 왕복 -->
			<div class="search">
			<div id="tab-1" class="tab-content current">
				<form method="GET" class="row g-4 mt-5 form"
					action="/traco/flightlist.do" onsubmit="check();">
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<!-- 주소 -->
							<label class="form-label" for="inputAddress1">출발지</label> <input
								class="form-control " name="inputAddress1" type="text"
								placeholder="From where" />



						</div>
					</div>
					<!-- 주소 -->
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<label class="form-label" for="inputAddress2">도착지</label> 
							<input
								class="form-control" name="inputAddress2" type="text"
								placeholder="To where" />
								
						</div>
					</div>

					<!-- 날짜 출발 -->
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<label class="form-label" for="inputdateOne">출발일</label> <input
								class="form-control" name="inputdateOne" type="date" />
						</div>
					</div>
					
					
					<!-- 날짜 도착 -->
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<label class="form-label" for="inputdateTwo">도착일</label> <input
								class="form-control" name="inputdateTwo" type="date" />
						</div>
					</div>
					
					<!-- 인원 -->
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<%-- <label class="form-label visually-hidden" for="adult">Adult</label>
							<select name="adult">
								<option selected="selected">1</option>
								<% for(int i =2; i<=10; i++){ %>
								<option><%=i %></option>
								<%} %>
							</select> <label class="form-label visually-hidden" for="child">Child</label>
							<select name="child">
								<% for(int i =0; i<=10; i++){ %>
								<option><%=i %></option>
								<%} %>
							</select> <label class="form-label visually-hidden" for="kid">Toddler</label>
							<select name="toddler">
								<% for(int i =0; i<=10; i++){ %>
								<option><%=i %></option>
								<%} %>
							</select> --%>
							<label for="quantity">인원</label>
							<select id="quantity" name="quantity">
						<c:forEach var="i" begin="1" end="30">
							<option value="${i}">${i}명</option>
						</c:forEach>
						</select>
						</div>

					</div>

					<div class="col-12 col-xl-10 col-lg-12 d-grid mt-6">
						<button onclick="show()" class="btn btn-secondary" type="submit"
							id="searchbtn">검색</button>


					</div>
				</form>
			</div>
			</div>
			
			
			<div class="search">
			<div id="tab-2" class="tab-content">
			<form method="GET" class="row g-4 mt-5 form"
					action="/traco/flightsinglelist.do" onsubmit="check();">
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<!-- 주소 -->
							<label class="form-label" for="inputAddress1">출발지</label> <input
								class="form-control " name="inputAddress1" type="text"
								placeholder="From where" />



						</div>
					</div>
					<!-- 주소 -->
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<label class="form-label" for="inputAddress2">도착지</label> <input
								class="form-control" name="inputAddress2" type="text"
								placeholder="To where" />
						</div>
					</div>

					<!-- 날짜 출발 -->
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<label class="form-label" for="inputdateOne">출발일</label> <input
								class="form-control" name="inputdateOne" type="date" />
						</div>
					</div>
					<!-- 날짜 도착 -->
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<label class="form-label blanklabel" for="inputdateTwo"></label> 
							<div class="blankbox"></div>
						</div>
					</div>
					<!-- 인원 -->
					<div class="col-sm-6 col-md-6 col-xl-5">
						<div class="input-group">
							<%--< label class="form-label visually-hidden" for="adult">Adult</label>
							<select name="adult">
								<option>0</option>
								<option selected="selected">1</option>
								<% for(int i =2; i<=10; i++){ %>
								<option><%=i %></option>
								<%} %>
							</select> <label class="form-label visually-hidden" for="child">Child</label>
							<select name="child">
								
								<% for(int i =0; i<=10; i++){ %>
								<option><%=i %></option>
								<%} %>
							</select> <label class="form-label visually-hidden" for="kid">Toddler</label>
							<select name="toddler">
								
								<% for(int i =0; i<=10; i++){ %>
								<option><%=i %></option>
								<%} %>
							</select> --%>
							
							<label for="quantity">인원</label>
					<select id="quantity" name="quantity">
						<c:forEach var="i" begin="1" end="30">
							<option value="${i}">${i}명</option>
						</c:forEach>
						</select>
						</div>

					</div>

					<div class="col-12 col-xl-10 col-lg-12 d-grid mt-6">
						<button onclick="show()" class="btn btn-secondary" type="submit"
							id="searchbtn">검색</button>

					</div>
				</form>
					</div>
	
</div>
			
			
			

		</section>

		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>

	<script>
	
	
	 function show(){
		 console.log("버튼1");
			$('.list-div').css('display', '');		
	}
	 $(document).ready(function(){
			$('button.btn2').click(function(){
				$('#inputAddress2').hide();
			});
		}))		
		
	 
	</script>
</body>

</html>