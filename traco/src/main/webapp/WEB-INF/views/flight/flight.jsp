<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	form{
	border: 1px solid black;
	}
	
</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
		<!-- 조회박스 시작-->
			<!-- <div class="flight-heading">항공권 조회</div>
				<div class="flight-body">
					 <ul class="flight_search">
					 <li class="fs1">왕복</li>
					 <li class="fs2">편도</li>
					 </ul> -->
					
                  <div>
                    <button class="btn" type="submit">왕복</button>
                    <button class="btn" type="submit">편도</button>
               
                  </div>
                  <script>
                  function validateForm(form){
                  if(form.inputAdress1.value ==null){
                  alert("입력하세요");
                  form.title.focus();
                  return false;
                  }
                  </script>
                    <!-- 왕복 -->
                      <form class="row g-4 mt-5" action="flightlist.jsp"
                      onsubmit="return validateForm(this);">
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group">
                          <!-- 주소 -->
                            <label class="form-label" for="inputAddress1">출발지</label>
                            <input class="form-control " id="inputAddress1" type="text" placeholder="From where" />
                            	
                            		
                            	
                          </div>
                        </div>
                          <!-- 주소 -->
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group">
                            <label class="form-label" for="inputAddress2">도착지</label>
                            <input class="form-control" id="inputAddress2" type="text" placeholder="To where" />
                          </div>
                        </div>
                        
                          <!-- 날짜 출발 -->
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group">
                          	<label class="form-label" for="inputdateOne">출발일</label>
                            <input class="form-control" id="inputdateOne" type="date" />
                              </div>
                        </div>
                          <!-- 날짜 도착 -->
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group">
                          	<label class="form-label" for="inputDateTwo">도착일</label>
                            <input class="form-control" id="inputDateTwo" type="date" />
                             </div>
                        </div>
                          <!-- 인원 -->
                        <div class="col-sm-6 col-md-6 col-xl-5">
                          <div class="input-group">
                            <label class="form-label visually-hidden" for="adult">Person</label>
                            <select id="adult">
                              <option selected="selected">1</option>
                              <% for(int i =2; i<=10; i++){ %>
                              <option><%=i %></option>
                               <%} %>
                            </select> 
                            </div>
                            
                        </div>
                        
                        <div class="col-12 col-xl-10 col-lg-12 d-grid mt-6">
                          <button class="btn btn-secondary" type="submit">Search</button>
                        </div>
                      </form>
                      
                    <!-- 편도 -->
                    

					
						
				</div>
				<!-- 조회박스 끝 -->
				
				<!-- 조회결과 시작-->
				<%-- <table class="ftable table-bordered list">
				<!-- 컬럼 -->
				<tr>
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
			</table> --%>
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	<script>
	
	</script>
</body>
</html>