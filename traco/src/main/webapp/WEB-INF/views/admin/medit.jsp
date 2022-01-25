<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	.content{margin:80px auto 0 auto;}
	.addbox{border:1px solid black;}
	.addbox{width:1000px; height:900px; margin:0 auto}
	.table > tbody > tr > td {vertical-align:middle; text-align:center;}
	.addbox tbody tr td:first-child{background-color: #CCC;}
	h1{width:1000px; margin:0 auto; font-size:30px;}
	.price{width:100px; margin:0px 20px 0px 15px;}
	
	/* 전송버튼 */
	#sendbox{text-align:center; margin-top:20px;}
	#sendbox input{width:150px;}
	
	/* 돌아가기*/
	#tomain{text-align:right; width:1000px; margin:0 auto; padding-bottom:10px;}
</style>
<script>
	window.onload = function() {
		today = new Date();
		console.log("today.toISOString() >>>" + today.toISOString());
		today = today.toISOString().slice(0, 10);
		console.log("today >>>> " + today);
		bir = document.getElementById("calendar1");
		bir.value = today;
	}

</script>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/admin/admininc/adminheader.jsp" %>
	
		<section class="content">
			<h1>미니투어 수정</h1>
			<div id="tomain"><input type="button" value="메인메뉴" class="btn btn-info" onclick="location.href='/traco/admin/adminmain.do';"></div>
			<form method="POST" action="/traco/admin/meditok.do">
				
					<table class="table table-bordered addbox">
					<!-- 상품명 -->
						<tr>
							<td style="width:160px; height:100px;">상품명</td>
							<td><input type="text" name="pkgname" style="width:550px;" value="${pdto.pname}"></td>
							<td style="width:100px; background-color:#CCC;">상품개수</td>
							<td style="width:150px;">
								<select name="items">
									<option value="${pdto.pcount}">${pdto.pcount}</option>
									<option value="100">100</option>
									<option value="200">200</option>
									<option value="400">400</option>
									<option value="500">500</option>
									<option value="1000">1000</option>									
								</select>
							</td>
						</tr>
						<!--상품종류  -->
						<tr>
							<td style="width:160px; height:100px; background-color:#CCC;">상품 종류</td>
							<td>
								<span><input type="radio" name="kind" value="mini" checked>미니투어</span>
  								
  								
							</td>
							<td style="width:100px; background-color:#CCC;">지역선택</td>
							<td style="width:150px;">
								<select name="area">
									<option value="${pdto.areaseq}">${pdto.areaname}</option>
									<c:forEach items="${alist}" var="pdto">
										<option  value="${pdto.areaseq}">${pdto.areaname}</option>
									</c:forEach>
									
								</select></td>
						</tr>
						<!--상품여부  -->
						<tr>
							<td style="height:100px;">상품 여부</td>
							<td colspan="3">
								<span style="margin-right:100px;"><input type="radio" name="status" value="판매진행">판매 진행</span>
								<span style="margin-right:100px;"><input type="radio" name="status" value="판매종료">판매 종료</span>
								<span><input type="radio" name="status" value="매진">매진</span>
							</td>
							
						</tr>
						<!--기간  -->
						<tr>
							<td style="height:100px;">기간</td>
							<td>
								<input type="date" id="calendar1" min="2022-01-19" name="startday" value="${pdto.pstart}"> ~ <input type="date" id="calendar2" name="endday" max="2022-10-01" style="margin-right:30px;" value="${pdto.pend}">
							</td>
							<td style="width:100px; background-color:#CCC;">카테고리
							</td>
							<td style="width:150px;">
								<select name="minictg">
									<option value="${pdto.minictgseq}">${pdto.minictgname}</option>
									<c:forEach items="${catlist}" var="pdto">
										<option  value="${pdto.minictgseq}">${pdto.minictgname}</option>
									</c:forEach>
									
								</select>
							</td>
							
						</tr>
						<!--썸네일이미지  -->
						<tr>
							<td style="height:100px;">썸네일 이미지</td>
							<td colspan="3">
								<input type="file"name="thumbs" style="margin-left:200px;" value="${idto.thumbname}" required>기존파일:${idto.thumbname}
							</td>
							
						</tr>
						<!--가격  -->
						<tr>
							<td style="height:100px;">가격</td>
							<td colspan="3">
								성인<input type="text" name="adult" class="price" value="${pdto.padultprice}">
								아동<input type="text" name="kid" class="price" value="${pdto.pkidprice}">
								유아<input type="text" name="toddle" class="price" value="${pdto.ptoddleprice}">							
							</td>
							
						</tr>
						<!--상세이미지  -->
						<tr>
							<td style="height:100px;">상세 이미지</td>
							<td colspan="3"><input type="file" name="infoimage" style="margin-left:200px;" value="${idto.imgname}" required>기존파일:${idto.imgname}</td>
							
						</tr>
					
					</table>
				
					<div id="sendbox"><input type="submit" value="수정완료" class="btn btn-success"></div>
					
					
					<input type="hidden" name="seq" value="${pdto.pseq}">
					<input type="hidden" name="thumbname" value="${idtoname.thumbname}">
					<input type="hidden" name="imagename" value="${idtoiname.imgname}">
			</form>
		
		</section>
		
	</main>

	<script>
		
	
	</script>
</body>
</html>