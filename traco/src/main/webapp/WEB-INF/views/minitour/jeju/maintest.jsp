<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>



<style>





</style>
</head>
<body>

	<main class="main">

		<section class="content">
			

<div class="slick_sd">
  <div class="slick_list"><img src="http://kenwheeler.github.io/slick/img/fonz1.png"/></div>
  <div class="slick_list"><img src="http://kenwheeler.github.io/slick/img/fonz2.png"/></div>
  <div class="slick_list"><img src="http://kenwheeler.github.io/slick/img/fonz3.png"/></div>
  <div class="slick_list"><img src="http://kenwheeler.github.io/slick/img/fonz3.png"/></div>
  <div class="slick_list"><img src="http://kenwheeler.github.io/slick/img/fonz2.png"/></div>
  <div class="slick_list"><img src="http://kenwheeler.github.io/slick/img/fonz1.png"/></div>
</div>
		
		</section>

	</main>
	<script>
		
		$('.slick_sd').slick({
			  dots: true,
			  infinite: true,
			  speed: 300,
			  slidesToShow: 1,
			  centerMode: true,
			  variableWidth: true
			});
			
	</script>
</body>
</html>