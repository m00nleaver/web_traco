<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>
	
	
</style>
</head>
<body>
	<!-- board/list.jsp -->
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
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
					<td style="height:300px;vertical-align:middle;">${dto.boardm_content}</td>
				</tr>
			</table>
			
			<div class="btns">
			
				<input type="button" value="돌아가기"
					class="btn btn-default"
					onclick="location.href='/traco/community/communitylist.do?column=${column}&word=${word}';">
				
				<c:if test="${not empty member_id && dto.member_id == member_id}">
				<input type="button" value="수정하기"
					class="btn btn-primary"
					onclick="location.href='/traco/community/communityedit.do?boardm_seq=${dto.boardm_seq}';">
				
				<input type="button" value="삭제하기"
					class="btn btn-primary"
					onclick="location.href='/traco/community/communitydel.do?boardm_seq=${dto.boardm_seq}';">
				</c:if>						
			</div>
			
			<div class="btns">
				<input type="button" value="${dto.boardm_up}" class="btn btn-default">			
			</div>
			
			<form method="POST" action="/traco/community/commentaddok.do">
			<table class="commentadd">
				<tr>
					<td><textarea name="commentm_content" class="form-control" required></textarea></td>
					<td><input type="submit" value="댓글쓰기" class="btn btn-primary"></td>
				</tr>
			</table>
			<input type="hidden" name="boardm_seq" value="${dto.boardm_seq}">
			</form>
			
			<table class="table table-bordered comment">
				<c:forEach items="${clist}" var="cdto">
				<tr>
					<td>
						${cdto.commentm_content}
						<small>${cdto.member_id} ${cdto.commentm_date} ${cdto.commentm_up}</small></td>
					<td>
						<c:if test="${cdto.commentm_name == member_id}">
						<input type="button" value="삭제하기"	class="btn btn-default"	onclick="location.href='/traco/community/commentdelok.do?commentm_seq=${cdto.commentm_seq}&boardm_seq=${dto.boardm_seq}';">
						</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	<script>
	
	
	</script>
</body>
</html>







