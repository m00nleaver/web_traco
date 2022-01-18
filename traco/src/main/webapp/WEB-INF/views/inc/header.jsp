<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.title:first-letter {
		
		<c:if test="${not empty id}">
		color: cornflowerblue;
		</c:if>
		
	}
</style>

<!-- inc/header.jsp -->
<header class="header">

	<!-- <h1 class="title" onclick="location.href='/traco/main.do';"></h1> -->
	<img src="/traco/asset/images/unknown.png" alt="로고" class="headerimg" onclick="location.href='/traco/main.do';">
	
	<ul class="menu">
		<li onclick="location.href='/traco/main.do';">전체메뉴</li>
		<li onclick="location.href='/traco/jeju.do';">제주도투어</li>
		<li onclick="location.href='/traco/land.do';">내륙투어</li>
		<li onclick="location.href='/traco/route.do';">경로찾기</li>
		<li onclick="location.href='/traco/flight.do';">항공</li>
		<li onclick="location.href='/traco/rentcar.do';">렌트카</li>
		<li onclick="location.href='/traco/community.do';">커뮤니티</li>
		<div><input type="text" value="검색"></div>
		<span class="glyphicon glyphicon-user" onclick="location.href='/traco/member.do';"></span>
		<span class="glyphicon glyphicon-heart"></span>
		<span class="glyphicon glyphicon-calendar"></span>
	</ul>

</header>

<script>
	
</script>





