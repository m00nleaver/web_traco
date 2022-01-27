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
	width: 500px;
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
	width: 500px;
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
			<h1>배너이미지 등록</h1>
			<div id="tomain">
				<input type="button" value="메인메뉴" class="btn btn-info"
					onclick="location.href='/traco/admin/adminmain.do';">
			</div>
			<form method="POST" action="/traco/admin/addbannerok.do">
				<table class="table table-bordered addbox">
					
					<tr>
						<td style="width:100px;">배너이름</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>배너이미지</td>
						<td style=""><input type="file" name="file" style="width:180px; margin-left:100px;"></td>
					</tr>
					<tr>
						<td>링크URL</td>
						<td><input type="text" name="url"></td>
					</tr>
					<tr>
						<td>배너카테고리</td>
						<td>
							<select name="ctg" style="width:100px; height:30px; font-size:20px;">
								<option>카테고리</option>
								<option value="1">인기</option>
								<option value="2">추천</option>
								<option value="3">이벤트</option>
							</select>
						</td>
					</tr>



				</table>
				<div id="sendbox">
					<input type="submit" value="작성완료" class="btn btn-success">
				</div>
			</form>

		</section>

	</main>
	<script>
		
	</script>
</body>
</html>