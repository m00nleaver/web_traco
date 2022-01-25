<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
.content {
	margin: 80px auto 0 auto;
}

.addbox {
	border: 1px solid black;
}

.addbox {
	width: 1000px;
	height: 400px;
	margin: 0 auto
}

.table>tbody>tr>td {
	vertical-align: middle;
	text-align: center;
}

.addbox tbody tr td:first-child {
	background-color: #CCC;
}

h1 {
	width: 1000px;
	margin: 0 auto;
	font-size: 30px;
}



/* 첫번째 줄*/
td #name {
	width: 300px;
}

td #price {
	width: 150px;
}

/* 자동차종류*/
td>.type {
	margin-left: 20px;
	font-size: 25px;
}
/* 자동차 여부*/
td .status {
	font-size: 25px;
	margin: 0 auto 0 30px;
}

#thumb {
	margin: 0 auto;
}

/* 전송버튼 */
#sendbox {
	text-align: center;
	margin-top: 40px;
	margin-bottom: 40px;
}

#sendbox input {
	width: 150px;
}

/* 돌아가기*/
#tomain {
	text-align: right;
	width: 1000px;
	margin: 0 auto;
	padding-bottom: 10px;
}

td .status{
	margin-right:5px;
}
.status1{
	margin-right:30px;
}

.price{
	width:100px;
	height:35.5px;
	margin-left:10px;
}

.price1{
	margin-right:40px;
}


</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/admin/admininc/adminheader.jsp"%>
		<section class="content">
			<h1>항공권 등록</h1>
			<div id="tomain">
				<input type="button" value="메인메뉴" class="btn btn-info"
					onclick="location.href='/traco/admin/adminmain.do';">
			</div>
			<form method="POST" action="/traco/admin/feditok.do">
				<table class="table table-bordered addbox">
					<!-- <tr>
						<td style="width:140;">항공권명</td>
						<td colspan="5" style="text-align:left;">
							<input type="text" name="name" style="width:400px; margin-left:30px;">
						</td>
						
					</tr> -->
					<tr>
						<td>상품여부</td>
						<td colspan="3">
							<span class="status1"><input type="radio" name="status" value="1" class="status" <c:if test="${requestScope.status eq '판매가능'}"> checked</c:if>>판매 가능</span>
							<span class="status1"><input type="radio" name="status" value="2" class="status" <c:if test="${requestScope.status eq '판매불가'}"> checked</c:if>>판매 종료</span>
							<span class="status1"><input type="radio" name="status" value="매진" class="status">매진</span>
						</td>
						<td style="background-color: #CCC;">항공사</td>
						<td>
							<select name="company">
								<option value="${pdto.aircomseq}">${pdto.aircomname}</option>
								<c:forEach items="${blist}" var="pdto">
								<option value="${pdto.aircomseq}">${pdto.aircomname}</option>
								</c:forEach>
							</select>
						</td>
						
					</tr>
					<tr>
						<td>이륙일</td>
						<td colspan="3">
							<input type="date" name="calendar" value="${pdto.airdate1}">
						</td>
						
						<td style="background-color: #CCC;">이륙시간</td>
						<td><input type="time" name="time" value="${pdto.airdate2}"></td>
					</tr>
					<tr>
						<td>출발지</td>
						<td>
							<select name="departure">
								<option value="${pdto.departseq}">${pdto.departname}</option>
								<c:forEach items="${alist}" var="pdto">
								<option value="${pdto.airportseq}">${pdto.airportname}</option>
								</c:forEach>
							</select>
						</td>
						<td style="background-color: #CCC;">도착지</td>
						<td>
							<select name="arrival">
								<option value="${pdto.arrivalseq}">${pdto.arrivalname}</option>
								<c:forEach items="${alist}" var="pdto">
								<option value="${pdto.airportseq}">${pdto.airportname}</option>
								</c:forEach>
							</select>
						</td>
						<td style="background-color: #CCC;">좌석개수</td>
						<td>
							<select name="seatnum">
								<option value="${pdto.seatnum}">${pdto.seatnum}</option>
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="15">15</option>
								<option value="20">20</option>
								<option value="25">25</option>
								<option value="30">30</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>가격</td>
						<td colspan="5">
							<span class="price1">성인<input type="text" name="adult" class="price" value="${pdto.padultprice}"></span>
							<span class="price1">아동<input type="text" name="kid" class="price" value="${pdto.pkidprice}"></span>
							<span class="price1">유아<input type="text" name="tod" class="price" value="${pdto.ptoddleprice}"></span>
						</td>
						
					</tr>

					

				</table>
				<div id="sendbox">
					<input type="submit" value="수정완료" class="btn btn-success">
				</div>
				
				<input type="hidden" value="${pdto.airseq}" name="airseq">
			</form>

		</section>

	</main>
	<script>
		
	</script>
</body>
</html>