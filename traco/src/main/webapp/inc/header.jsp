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

	<h1 class="title">Code</h1>
	
	<ul class="menu">
		<li onclick="location.href='/code/main.do';">Home</li>
		<li onclick="location.href='/code/board/list.do';">Board</li>
		<li onclick="location.href='/code/member/member.do';">Member</li>
		<li onclick="location.href='/code/etc/etc.do';">Etc</li>
	</ul>

</header>





