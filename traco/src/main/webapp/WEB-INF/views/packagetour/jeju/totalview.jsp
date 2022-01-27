<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/css/ion.rangeSlider.min.css"/>

<script src="https://cdnjs.cloudflare.com/ajax/libs/ion-rangeslider/2.3.1/js/ion.rangeSlider.min.js"></script>


<style>
	table, th, td {
	  border: 1px solid black;
	/*   border-collapse: collapse;
	 */}
	 
	 #taglist {
	  width: 60px;
	  height: 50px;
	 }
	
	
	 .center {
  display: flex;
  justify-content: center;
  align-items: center;
}
	
	
	
.search {
	float: left;
	margin-top :60px; 

	}



.content .below {
	min-height: 200px;
}

.products {
	float : right;
	
	width: 800px;

}

.search > form > table > tbody > tr > td {
	padding : 10px;
}


.card {
	margin: auto;
	width:22rem;
	border:3px solid #ddd;
	padding: 8px;
}


.card img
{
  max-width: 100%;
  max-height: 100%;
  width: 198px;
  height:199px;
  object-fit: fill;
  margin: auto;
  display: block;
}

</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<br>
		<br>
		<br>
		<section class="content">
		
			<div class="search">
				<form method="GET" action="/traco/packagetour/jeju/totalview.do">
					<table class="center filter">
						<tr>
							<th colspan="4" class="h3" style="padding : 10px;">필터</th>
						</tr>
						<tr><td id="taglist" colspan="4">
								<label for="hashtag" class="h4">해시태그</label>
								<select id="hashtag" name="hashtag" style="width:180px; height:40px;">
										<option value="전체">전체</option>
									<c:forEach items="${tagList}" var="dto">
										<option value="${dto.tagName}">${dto.tagName}</option>
									</c:forEach>
								</select>
						</td></tr>
						
						
						
						<tr><td colspan="4">
						    <label for="startdate" class="h4">출발일자</label>
							<input type="date" id="startdate" name="startdate">
						</td></tr>
						
						
						<tr><td colspan="4">
						    <label for="price" class="h4">가격</label>
							<input type="text" class="js-range-slider" id="price" name="price" value="" />
							
						</td></tr>
						
						

						
						<tr>
							<td colspan="4">
						  		<input id="searchBtn" type="button" value="검색" style="float:right;">
						  	</td>
						</tr>						
					</table>
				</form>
			</div>
			

			
	<div id="all-box" class="products">
		<div style="width:1000px; margin:0px auto;">
			<span class="h1">검색결과</span> 						
			<span class="h1 btn btn-primary" onclick="location.href='/traco/packagetour/jeju/totalview.do';" class="h2" style="float:right;">전체상품 보기</span>
			
						
		</div>
		<hr style="height:2px;border-width:0;color:#ddd;background-color:#ddd">
		
		<div id="all-row" class="row">


		</div>
	
		
		</div>
			
			
			
			
</section>			
			
			
			
<!-- 						<tr>
						<th colspan="4">정렬</th>
						</tr>
						
						<tr>
							<td><input type="submit" value="판매량순" name="qorder" class="btn btn-default tagbtn"></td>
							<td><input type="submit" value="낮은가격순" name="ploworder" class="btn btn-default tagbtn"></td>
							<td><input type="submit" value="높은가격순" name="phighorder" class="btn btn-default tagbtn"></td>
							<td><input type="submit" value="날짜순" name="dateorder" class="btn btn-default tagbtn"></td>
						</tr>
						 -->
		
		
		
		
		<section class="content"></section>
		<section class="content"></section>
		<section class="content"></section>
		<section class="content"></section>
			

		
		<input type=hidden id="load"/>
		
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	
	<script>
	
	let plow;
	let phigh;
/* 	$("#hashtag").val();
 */	
 
 
	
	$(function() {
		$("#load").click();
	});
	
	$(document).on('click', '#searchBtn', function(e){
	    e.preventDefault();  
	  
	    $(".items").show();
	    
	  $(".items").each(function() {
		 
		  let p = parseInt($(this).attr('class').split(' ')[2]);
	  	
		  let tag = $(this).attr('class').split(' ')[1];
		  
		  
		  
		  if (!(p >= plow && p <= phigh)) {
			  $(this).hide();
		  }
		  
		  if ($("#hashtag").val() != "전체" && $("#hashtag").val() != tag){
			  
			  $(this).hide();
			  
		  }
		  
		  
		  
	  });
	    
	  
/* 	  if (selectedHash == "전체") {
		  
		  $(".tagitems").show();

	  }else {
	  
	  $(".tagitems").hide();
	  $("."+selectedHash).show();

	  } */
	  
	});

	
	
	$(".js-range-slider").ionRangeSlider({
        type: "double",
        min: 0,
        max: 1000000,
        from: 0,
        to: 1000000,
        grid: true,
        onFinish: function (data) {
            // Called then action is done and mouse is released
    		console.log(data.from);
            console.log(data.to);
            
            plow=data.from;
            phigh=data.to;
            
        }
    });
	
	$("button[type=button]").click( function() {
		$("button[type=button]").text(`${hello}`);
		} );

	
	
	
	
	$("#load").click(() => {
/* 		
		$('#tag-row').empty();

		$('#hash-row').empty();
		$("#hash-box").show();
		$('#recom-row').empty();
		$("#recom-box").show();
		$('#tag-row').append(`<button name="hashtag" class="center btn btn-secondary btn-lg tagbtn">전체</button>`);
		console.log("button clicked"); */
		
		$.ajax({
			type: 'GET',
			url: '/traco/tour/all.do',
			dataType: 'json',
			success: function(list) {
				


				
				 list.forEach((item) => {
	
					 $('#all-row').append(`<div class="col-md-4 \${item.tag} \${item.adultprice} items "><div class="card"><img src="/traco/asset/images/pkthumb/\${item.thumbseq}.jpg" class="card-img-top" alt="..."><div class="card-body"><h5 class="h4 card-title" name="title" style="height: 50px;">\${item.name}</h5><span class="h4 card-text">\${item.adultprice}원</span><button style="margin-left : 20px;" type="submit" class="btn btn-primary detail" onclick="location.href='/traco/packagetour/jeju/view.do?pkSeq=\${item.seq}';">상세보기</button></div></div></div>`);
					 
					 
				 });
			}
			
		}).done(
		 		
				function() {
				

				
				});
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	</script>
</body>
</html>