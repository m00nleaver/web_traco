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
			<h2 style="text-align: center;">Community</h2>
			<c:if test="${map.searchmode == 'y'}">
			<div style="text-align:center;margin:10px;color:#777;">'${map.word}'(으)로 검색한 ${list.size()}개의 게시물이 있습니다.</div>
			</c:if>
			<table class="table table-bordered list">
				<tr>
					<th>번호</th>
					<th>분류</th>
					<th>제목</th>
					<th>추천</th>
					<th>글쓴이</th>
					<th>날짜</th>
					<th>조회</th>

				</tr>
				<c:forEach items="${list}" var="dto">

				<tr>
					<td>${dto.boardm_seq}</td>
					<td>${dto.communityc_name}</td> 
					<td>
						<a href="/traco/community/communityview.do?boardm_seq=${dto.boardm_seq}&column=${map.column}&word=${map.word}&page=${nowPage}">${dto.postm_title}</a>
						
						<c:if test="${dto.commentcount > 0}">
						<span class="badge">${dto.commentcount}</span>
						</c:if>
						
						<c:if test="${dto.isnew <= 1}">
						<span class="label label-danger">new</span>
						</c:if>
					</td> 
					<td>${dto.boardm_up}</td>
					<td>${dto.member_id}</td>
					<td>${dto.boardm_date}</td>
					<td>${dto.boardm_view}</td>
			
				</tr>
				</c:forEach>
				<c:if test="${list.size() == 0}">
				<tr>
					<td colspan="5">게시물이 없습니다.</td>
				</tr>
				</c:if>
			</table>
			<div class="btns-right">
				<c:if test="${not empty member_id}">
					<input type="button" value="내글보기" class="btn btn-success" onclick="location.href='/traco/community/communitylist.do?column=member_id&word=${member_id}';">
				</c:if>
				<c:if test="${not empty member_id}">
				<input type="button" value="글쓰기"	class="btn btn-primary"	onclick="location.href='/traco/community/communityadd.do';">
				</c:if>
			</div>
			
			<div class="pagebar">${pagebar}</div>
			
			<div class="search">
				<form method="GET" action="/traco/community/communitylist.do">
				<table class="table_search">
					<tr>
						<td>
							<select name="column" class="form-control">
								<option value=postm_title>제목</option>
								<option value="boardm_content">내용</option>
								<option value="member_id">작성자</option>
							</select>
						</td>
						<td>
							<input type="text" name="word" class="form-control" required >
						</td>
						<td>
							<input type="submit" value="검색하기" class="btn btn-default">
						</td>
						<td>
							<input type="button" value="목록보기"	class="btn btn-default" onclick="location.href='/traco/community/communitylist.do';">
						</td>
							
					</tr>
				</table>
				</form>
			</div>	
			

		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	<script>
		<c:if test="${map.searchmode == 'y'}">
		//검색 상태를 유지
		$('select[name=column]').val('${map.column}');
		$('input[name=word]').val('${map.word}');
		</c:if>
	
	</script>
</body>
</html>







