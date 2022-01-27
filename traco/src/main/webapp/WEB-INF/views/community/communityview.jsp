<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
</style>
</head>
<body>
	<!-- board/list.jsp -->
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="content">
			<h2 style="text-align: center;">Community</h2>
			<table class="table table-bordered add">
				<tr>
					<th>이름</th>
					<td>${dto.member_name}</td>
				</tr>
				<tr>
					<th>날짜</th>
					<td>${dto.boardm_date}</td>
				</tr>
				<tr>
					<th>읽음</th>
					<td>${dto.boardm_view}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${dto.postm_title}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td style="height: 300px; vertical-align: middle;">${dto.boardm_content}</td>
				</tr>

			</table>
			
			<div class="upbtn">
			
				<button id="boardm_up" class="btn label-danger">
					<span id="result" class="glyphicon glyphicon-heart">${dto.boardm_up}</span>
				</button>
			
			</div>
			<div class="communityviewbtns">

				<input type="button" value="돌아가기" class="btn btn-default"
					onclick="location.href='/traco/community/communitylist.do?column=${column}&word=${word}';">

				<c:if test="${not empty member_id && dto.member_id == member_id}">
					<input type="button" value="수정하기" class="btn btn-primary"
						onclick="location.href='/traco/community/communityedit.do?boardm_seq=${dto.boardm_seq}';">

					<input type="button" value="삭제하기" class="btn btn-primary"
						onclick="location.href='/traco/community/communitydel.do?boardm_seq=${dto.boardm_seq}';">
				</c:if>
			</div>


			<form method="POST" action="/traco/community/commentaddok.do">
				<c:if test="${not empty member_id}">
					<table class="commentadd">
						<tr>
							<td><textarea name="commentm_content" class="form-control"
									required></textarea></td>
							<td><input type="submit" value="댓글쓰기"
								class="btn btn-primary"></td>
						</tr>
					</table>
				</c:if>
				<input type="hidden" name="boardm_seq" value="${dto.boardm_seq}">
			</form>
			
			<c:forEach items="${clist}" var="cdto">
			<div style="width:700px; margin: 0px auto">
						
						<form method="POST" action="/traco/community/commenteditok.do">
							<div id="${cdto.commentm_seq}_texthide2" style="display:none;">
								<div><textarea name="commentm_content" class="form-control"	required></textarea></div>
								<div>
									<input type="submit" value="수정완료" class="btn btn-primary">
									<input id="${cdto.commentm_seq}_ceditbtn2" type="button" value="취소하기"	class="btn btn-primary">
								</div>
							</div>
							<input type="hidden" name="commentm_seq" value="${cdto.commentm_seq}">
							<input type="hidden" name="boardm_seq" value="${dto.boardm_seq}">
						</form>
						
						<div id="${cdto.commentm_seq}_texthide">
							<div class="form-control" style="height:auto;">
								<div>${cdto.commentm_content}</div>
								<div style="text-align: right; height:20px;">
									<small>${cdto.member_id}</small>&nbsp;&nbsp;ㆍ&nbsp;&nbsp;<small>${cdto.commentm_date}</small>
								</div>
							</div>
							<c:if test="${cdto.commentm_name == member_id}">
								<div>
									<input id="${cdto.commentm_seq}_ceditbtn" type="button" value="수정하기"	class="btn btn-default">
									
									<input type="button" value="삭제하기"	class="btn btn-default"
										onclick="location.href='/traco/community/commentdelok.do?commentm_seq=${cdto.commentm_seq}&boardm_seq=${dto.boardm_seq}';">
								</div>
							</c:if>
						</div>		
			</div>
			<br><br>
			</c:forEach>

		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>

	<script>
	var sum = ${dto.boardm_up};	

	<c:if test="${empty member_id}">
	
	$('#boardm_up').click(()=>{
		alert("로그인해야합니다.");
	});
	</c:if>	
	
	$('#boardm_up').click(()=>{
		$.ajax({
			type: 'GET',
			url: '/traco/community/communityviewdata.do',
			data: 'boardm_seq=' + ${dto.boardm_seq},
			dataType: 'json',
			success: function(result) {
				if (result.upresult == '1') {	
					sum += 1;					
					$('#result').text(sum);
				}else	if (result.downresult == '1') {	
					sum -= 1;					
					$('#result').text(sum);
				} 
			}
		});
	});
	
	<c:forEach items="${clist}" var="cdto">	
	$(document).ready(function(){
		
		  $("#${cdto.commentm_seq}_ceditbtn").click(function(){
		    $("#${cdto.commentm_seq}_texthide2").show();
		  });
 		  $("#${cdto.commentm_seq}_ceditbtn").click(function(){
 		    $("#${cdto.commentm_seq}_texthide").hide();
 		  });
 		
 		  $("#${cdto.commentm_seq}_ceditbtn2").click(function(){
 			  $("#${cdto.commentm_seq}_texthide").show();
 			});
 			$("#${cdto.commentm_seq}_ceditbtn2").click(function(){
 			  $("#${cdto.commentm_seq}_texthide2").hide();
 			});
		});
	</c:forEach>
	
	

	</script>
</body>
</html>







