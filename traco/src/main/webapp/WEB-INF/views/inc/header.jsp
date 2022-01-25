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
	
		<span class="glyphicon glyphicon-menu-hamburger" onclick="location.href='/traco/main.do';"></span>

	
		<li onclick="location.href='/traco/packagetour/jeju/main.do';">제주도 패키지</li>
		<li onclick="location.href='/traco/minitour/jeju/main.do';">제주도 미니</li>
		<li onclick="location.href='/traco/packagetour/land/main.do';">내륙 패키지</li>
		<li onclick="location.href='/traco/minitour/land/main.do';">내륙 미니</li>
		<li onclick="location.href='/traco/route.do';">경로찾기</li>
		<li onclick="location.href='/traco/flight.do';">항공</li>
		<li onclick="location.href='/traco/rentcar.do';">렌트카</li>
		<li onclick="location.href='/traco/community/communitylist.do';">커뮤니티</li>

		<!--  <div class="search"><input type="text" value="검색"></div>-->
		<div class="box">
			  <div class="container-1 search">
			      <span class="icon"><i class="fa fa-search"></i></span>
			      <input type="search" id="search" placeholder="Search..." />
			  </div>
			</div>
					
		<!-- 아이콘 -->
		<!-- https://fontawesome.com/v6.0 -->
		<div class ="submenu">
		<span class="fa fa-user me-sm-1" aria-hidden="true" onclick="location.href='/traco/member/member.do';"></span>
		<span class="fas fa-shopping-cart"></span>
		<span class="far fa-list-alt" onclick="location.href='/traco/admin/adminmain.do';"></span>
		</div>
		
		
	</ul>

</header>

<script>
	
</script>
