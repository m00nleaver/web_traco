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
	<!-- 조회결과 시작-->

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
						<%-- 	<label class="form-label visually-hidden" for="adult">Adult</label>
							<select name="adult">
								<option>0</option>
								<option selected="selected">1</option>
								<% for(int i =2; i<=10; i++){ %>
								<option><%=i %></option>
								<%} %>
							</select> 
							<label class="form-label visually-hidden" for="child">Child</label>
							<select name="child">
								
								<% for(int i =0; i<=10; i++){ %>
								<option><%=i %></option>
								<%} %>
							</select> 
							<label class="form-label visually-hidden" for="kid">Toddler</label>
							<select name="toddler">
								
								<% for(int i =0; i<=10; i++){ %>
								<option><%=i %></option>
								<%} %>
							</select>--%>
							
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

			<!-- 편도 -->

			<!-- 조회박스 끝 -->

				<form method = "get" action ="/traco/flightrez.do">
				<table class="ftable table-bordered list">
					<!-- 컬럼 -->
					<tr>
						<th>선택</th>
						<th>번호</th>
						<th>이륙일</th>
						<th>이륙시간</th>
						<th>좌석개수</th>
						<th>성인가격</th>
						<th>아동가격</th>
						<th>유아가격</th>
						<th>판매여부</th>
						<th>항공사</th>
						<th>출발지</th>
						<th>도착지</th>

					</tr>
					<!-- 결과 -->
					<c:forEach items="${list}" var="dto">
						<tr>
							<td><input type="radio"  name="single_seq" value="${dto.airplanp_seq}"></td>
							<td>${dto.airplanp_seq}</td>
							<td>${dto.airplanp_takeoffdate}</td>
							<td>${dto.airplanp_takeofftime}</td>
							<td>${dto.airplanp_number}</td>
							<td>${dto.airplanp_adultprice}</td>
							<td>${dto.airplanp_adultprice}</td>
							<td>${dto.airplanp_toddlerprice}</td>
							<td>${dto.salek_kind}</td>
							<td>${dto.airplanl_name}</td>
							<td>${dto.sairport_name}</td>
							<td>${dto.eairport_name}</td>

						</tr>
					</c:forEach>
					<c:if test="${empty list}">
						<tr>
							<td colspan="5">게시물이 없습니다.</td>
						</tr>
					</c:if>
				</table>
				
				

				
				
				<table class="ftable table-bordered list">
					<!-- 컬럼 -->
					<tr>
						<th>선택</th>
						<th>번호</th>
						<th>이륙일</th>
						<th>이륙시간</th>
						<th>좌석개수</th>
						<th>성인가격</th>
						<th>아동가격</th>
						<th>유아가격</th>
						<th>판매여부</th>
						<th>항공사</th>
						<th>출발지</th>
						<th>도착지</th>

					</tr>
					<!-- 결과 -->
					<c:forEach items="${list2}" var="dto">
						<tr>
							<td><input type="radio" name = "double_seq"  value="${dto.airplanp_seq}"></td>
							<td>${dto.airplanp_seq}</td>
							<td>${dto.airplanp_takeoffdate}</td>
							<td>${dto.airplanp_takeofftime}</td>
							<td>${dto.airplanp_number}</td>
							<td>${dto.airplanp_adultprice}</td>
							<td>${dto.airplanp_adultprice}</td>
							<td>${dto.airplanp_toddlerprice}</td>
							<td>${dto.salek_kind}</td>
							<td>${dto.airplanl_name}</td>
							<td>${dto.sairport_name}</td>
							<td>${dto.eairport_name}</td>

						</tr>
					</c:forEach>
					<c:if test="${empty list2}">
						<tr>
							<td colspan="5">게시물이 없습니다.</td>
						</tr>
					</c:if>
				</table>
				<input type="hidden" name="memberSeq" value="${memberSeq}"/>
				<input type="hidden" name="quantity" value="${quantity}"/>
				
				<%-- 
				<input type="hidden" name="adultcnt" value="${map.adult}"/>
				<input type="hidden" name="childcnt" value="${map.child}"/>
				<input type="hidden" name="toddlercnt" value="${map.toddler}"/> --%>
				<input type ="submit" value="예약하기">
				</form>
				</section>
				<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>
	
	<script>
	$('input[name=inputAddress1]').val('${map.inputAddress1}');
	$('input[name=inputAddress2]').val('${map.inputAddress2}');
	$('input[name=inputdateOne]').val('${map.inputdateOne}');
	$('input[name=inputdateTwo]').val('${map.inputdateTwo}');
	$('select[name=quantity]').val('${map.quantity}');
	/* $('input[name=adult]').val('${map.adult}');
	$('input[name=child]').val('${map.child}');
	$('input[name=toddler]').val('${map.toddler}'); */
	
	</script>
</body>
</html>