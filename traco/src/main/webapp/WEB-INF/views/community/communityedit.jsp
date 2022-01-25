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
	<!-- community/communityview.jsp > community/communityedit.jsp -->
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			
			<form method="POST" action="/traco/community/communityeditok.do">
			<table class="table table-bordered add">
				<tr>
					<th>제목</th>
					<td><input type="text" name="postm_title" class="form-control" required value="${dto.postm_title}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="boardm_content" class="form-control" required>${dto.boardm_content}</textarea></td>
				</tr>
			</table>
			
			<div class="communityeditbtns">
				<input type="button" value="돌아가기"
					class="btn btn-default"
					onclick="location.href='/traco/community/communityview.do?boardm_seq=${dto.boardm_seq}';">
				<input type="submit" value="수정하기"
					class="btn btn-primary">										
			</div>
			
			<input type="hidden" name="boardm_seq" value="${dto.boardm_seq}">
			</form>
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	<script>
	
	</script>
</body>
</html>







