<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>

<script src="/traco/asset/js/jquery-ui.js"></script>


<style>

/* table, th, td {
  border: 1px solid black;
/*   border-collapse: collapse;
 */} */


.area-title {
	width: 700px;
	height:40px;
	margin: 0px auto;
	
}
.area-select {
	width: 700px;
	height: 300px;
	  margin-top: 30px;
	  margin-bottom: 0px;
	  margin-right: auto;
	  margin-left: auto;
	display: block;
}

.

.table {
		margin: 0px auto;
		table-layout: fixed;
		
	
}

.div-left {
	width:350px;
	height:240px;
	float: left;	
	overflow-y: auto;
	
}
.div-right {
	width:350px;
	height:240px;
	float: left;	
	overflow-y: auto;
	
}

.content { 
	display: block;
	margin-top: 0px;
	padding: 80px;
	}


#card-table {
	width: 1000px;
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

#hash-box {
	padding:80px;
}
#tag-row {
	margin-left: 10px;
	margin-right: 150px;
}

.sel-table .ui-selected {
   background-color: #ddd;
   color: white;
 }
 
 .big {
 
 	font-size: 1.0em;
 }
 
 .center {
  display: flex;
  justify-content: center;
  align-items: center;
  float:left;
  margin-right:12px;

}

</style>
</head>
<body>


	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			
			
				<div class="area-select">
					<table style="border: 0px; margin-bottom: 0px;" class="table title">
						<tr>
							<th>대분류</th>
							<th>중분류</th>
						</tr>
					
					</table>
					<div class="div-left">
					     <table class="table left sel-table">
							<tr><td class="big">서울특별시</td></tr>
							<tr><td class="big">부산광역시</td></tr>
							<tr><td class="big">대구광역시</td></tr>
							<tr><td class="big">인천광역시</td></tr>
							<tr><td class="big">광주광역시</td></tr>
							<tr><td class="big">대전광역시</td></tr>
							<tr><td class="big">울산광역시</td></tr>
							<tr><td class="big">세종특별자치시</td></tr>
							<tr><td class="big">경기도</td></tr>
							<tr><td class="big">강원도</td></tr>
							<tr><td class="big">충청북도</td></tr>
							<tr><td class="big">충청남도</td></tr>
							<tr><td class="big">전라남도</td></tr>
							<tr><td class="big">전라북도</td></tr>
							<tr><td class="big">경상남도</td></tr>
							<tr><td class="big">경상북도</td></tr>
							<tr><td class="big">제주특별자치도</td></tr>

		
					    </table>
				    </div>					
				    <div class="div-right">
					    <table class="table right sel-table" id="small">

		
					    </table>
				    </div>
				    
				    				<p align="right">
<button type="button" id="search" class="btn btn-secondary btn-lg">검색</button>

				</p> 
				</div>



			</section>
			
			


			
		<section id="recom-box" class="content">
		<div style="width:1000px; margin:0px auto;">
			<span class="h1">추천상품</span> 						
			<span class="h1 btn btn-primary" onclick="location.href='/traco/packagetour/jeju/totalview.do';" class="h2" style="float:right;">전체상품 보기</span>
			
						
		</div>
		<hr style="height:2px;border-width:0;color:#ddd;background-color:#ddd">
		
		<div id="recom-row" class="row">
		  <div class="col-md-3">
	  				<div class="card">
			  <img src="/traco/asset/images/pkimage/41.png" class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="h4 card-title" name="title" style="height: 50px;">[제주]아시아나 한라산등반 당일치기</h5>
			    <span class="h4 card-text">129000원</span>
				<button style="margin-left : 20px;" type="submit" class="btn btn-primary detail" onclick="location.href='/traco/packagetour/jeju/view.do?pkSeq=1';">상세보기</button>
			  
			  
			  
			  </div>
			</div>
  
		  
		  </div>

		</div>
	
		
		</section>

		<br>
			

			
	

		<section id="hash-box" class="content">
		<div style="width:1000px; margin:0px auto;">
			<h1 class="h1">카테고리</h1>
		</div>
		<hr style="height:2px;border-width:0;color:#ddd;background-color:#ddd">
		
		
		
		<div id="tag-row" class="row">
				<button name="hashtag" class="center btn btn-secondary btn-lg tagbtn">전체</button>
		</div>
		
		
		
		<hr style="height:2px;border-width:0;color:#ddd;background-color:#ddd">
		
		<div id="hash-row" class="row">
		  <div class="col-md-3">
	  				<div class="card">
			  <img src="/traco/asset/images/pkimage/41.png" class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="h4 card-title" name="title" style="height: 50px;">[제주]아시아나 한라산등반 당일치기</h5>
			    <span class="h4 card-text">129000원</span>
				<button style="margin-left : 20px;" type="submit" class="btn btn-primary detail" onclick="location.href='/traco/packagetour/jeju/view.do?pkSeq=1';">상세보기</button>
			  </div>
			</div>
  
		  
		  </div>

		</div>
	
		
		</section>




		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	
	
	
	
	<script>
	
	
		
		$(document).on('click', '.tagbtn', function(e){
		    e.preventDefault();  
		  $(this).css('background-color', 'gold');
		  
		  console.log($(this).text());
		  
		  $('.tagbtn').not($(this)).css('background-color', 'rgb(239, 239, 239)');
		 
		  let selectedHash = $(this).text();
		  
		  if (selectedHash == "전체") {
			  
			  $(".tagitems").show();

		  }else {
		  
		  $(".tagitems").hide();
		  $("."+selectedHash).show();

		  }
		  
		});


	
		$("#hash-box").hide();
		$("#recom-box").hide();
	

 		$( ".sel-table tbody tr" ).bind( "mousedown", function ( e ) {
		    e.metaKey = true;
		} ).selectable();
	 

		$(".big").click(() => {
		    $("#small").empty();

			$.ajax({
				type: 'GET',
				url: '/traco/tour/area.do',
				data:'big=' + $(".big.ui-selected").text(),
				dataType: 'json',
				success: function(list) {
					 list.forEach((item) => {
		
						 $('#small').append(`<tr class="ui-selectable"><td class="small ui-selectee">\${item.small}</td></tr>`);

					 });
				}
				
			}).done(
			 		
					function() {
					
					$( ".sel-table tbody tr" ).bind( "mousedown", function ( e ) {
					    e.metaKey = true;
					} ).selectable();
					
					});
		});
		
		
		$("#search").click(() => {
			
			$('#tag-row').empty();
	
			$('#hash-row').empty();
			$("#hash-box").show();
			$('#recom-row').empty();
			$("#recom-box").show();
			$('#tag-row').append(`<button name="hashtag" class="center btn btn-secondary btn-lg tagbtn">전체</button>`);
			console.log("button clicked");
			
			$.ajax({
				type: 'GET',
				url: '/traco/tour/areapk.do',
				data:'big=' + $(".big.ui-selected").text()+"&small="+$(".small.ui-selected").text(),
				dataType: 'json',
				success: function(list) {
					
				  let taglist = [];
					
				  list.forEach((item) => {
					taglist.push(item.tag);    	
				  
				  });
				  
				  new Set([...taglist]).forEach((item)=>{
				  
					$('#tag-row').append(`<button name="hashtag" class="center btn btn-secondary btn-lg tagbtn">\${item}</button>`);
				  
				  });
					  
				   if (list.length > 4){
					   for (var i=0; i<4; i++){
							 $('#recom-row').append(`<div class="col-md-3"><div class="card"><img src="/traco/asset/images/pkthumb/\${list[i].thumbseq}.jpg" class="card-img-top" alt="..."><div class="card-body"><h5 class="h4 card-title" name="title" style="height: 50px;">\${list[i].name}</h5><span class="h4 card-text">\${list[i].adultprice}원</span><button style="margin-left : 20px;" type="submit" class="btn btn-primary detail" onclick="location.href='/traco/packagetour/jeju/view.do?pkSeq=\${list[i].seq}';">상세보기</button></div></div></div>`);
							 
						 }
				   }else {
					   
					   list.forEach((item) => {
							
							 $('#recom-row').append(`<div class="col-md-3"><div class="card"><img src="/traco/asset/images/pkthumb/\${item.thumbseq}.jpg" class="card-img-top" alt="..."><div class="card-body"><h5 class="h4 card-title" name="title" style="height: 50px;">\${item.name}</h5><span class="h4 card-text">\${item.adultprice}원</span><button style="margin-left : 20px;" type="submit" class="btn btn-primary detail" onclick="location.href='/traco/packagetour/jeju/view.do?pkSeq=\${item.seq}';">상세보기</button></div></div></div>`);
							 
							 
						 });
					   
				   }

					
					 list.forEach((item) => {
		
						 $('#hash-row').append(`<div class="col-md-3 \${item.tag} tagitems"><div class="card"><img src="/traco/asset/images/pkthumb/\${item.thumbseq}.jpg" class="card-img-top" alt="..."><div class="card-body"><h5 class="h4 card-title" name="title" style="height: 50px;">\${item.name}</h5><span class="h4 card-text">\${item.adultprice}원</span><button style="margin-left : 20px;" type="submit" class="btn btn-primary detail" onclick="location.href='/traco/packagetour/jeju/view.do?pkSeq=\${item.seq}';">상세보기</button></div></div></div>`);
						 
						 
					 });
				}
				
			}).done(
			 		
					function() {
					

					
					});
		});
		
		
	

		
	
	
	

	</script>
</body>
</html>