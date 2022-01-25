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
	<!-- community/communityadd.jsp -->
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="content">

			<form method="POST" action="/traco/community/communityaddok.do">
				<table class="table table-bordered add">
				
					<select class="form-control" name ="communityc_seq" style="width:700px; text-align: center; margin: 0px auto;" >
						<c:forEach items="${Kategorie}" var="dto">
							<option value="${dto.communityc_seq}">${dto.communityc_name}</option>
						</c:forEach>
					</select>

					<tr>
						<th>제목</th>
						<td><input type="text" name="postm_title"
							class="form-control" required></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="boardm_content" class="form-control"
								required></textarea></td>
					</tr>
				</table>

				<div class="communityaddbtns">
					<input type="button" value="돌아가기" class="btn btn-default"
						onclick="location.href='/traco/community/communitylist.do';">
					<input type="submit" value="글쓰기" class="btn btn-primary">
				</div>
			</form>

		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>

	<script>
		
	</script>
</body>
</html>







