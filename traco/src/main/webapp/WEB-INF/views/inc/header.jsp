<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	.title:first-letter {
		
		<c:if test="${not empty member_id}">
		color: cornflowerblue;
		</c:if>
		
	}
</style>
<!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/7f52bbfce1.js" crossorigin="anonymous"></script>
<!-- inc/header.jsp -->
<header class="header">



	<h1 class="title" >
		<img class="logo" src="/traco/asset/images/logo/logo.png" alt="로고" onclick="location.href='/traco/main.do';">


	</h1>
	
	<ul class="menu">
	
		<!-- <span class="glyphicon glyphicon-menu-hamburger" onclick="location.href='/traco/main.do';"></span> -->

	
		<li onclick="location.href='/traco/packagetour/jeju/pkmain.do';">패키지</li>
		<li onclick="location.href='/traco/minitour/jeju/main.do';">미니투어</li>
		
		<li onclick="location.href='/traco/flight.do';">항공</li>
		<li onclick="location.href='/traco/rentcar/rentcar.do';">렌트카</li>
		<li onclick="location.href='/traco/community/communitylist.do';">커뮤니티</li>
						
		<!-- 아이콘 -->
		<!-- https://fontawesome.com/v6.0 -->
		<div class ="submenu" style="margin-left:150px;">
		<span class="fa fa-user me-sm-1" aria-hidden="true" onclick="location.href='/traco/member/member.do';" <c:if test="${not empty member_id}"> style="color:cornflowerblue;" </c:if>></span>
		<span class="fas fa-shopping-cart"></span>
		
		<c:if test="${member_id eq 'admin'}">
		<span class="far fa-list-alt" onclick="window.open('/traco/admin/adminmain.do');" ></span>
		</c:if>
		
		<%-- <c:if test="${not empty member_id}">
		<span>로그인되었습니다.</span>
		</c:if> --%>
		</div>
		
		
	</ul>

</header>

<script>
	
</script>