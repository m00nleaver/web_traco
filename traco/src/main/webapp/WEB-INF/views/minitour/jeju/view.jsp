<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />


<style>

/* 	table, th, td {
	  border: 1px solid black;
	/*   border-collapse: collapse;
	 */} */
	 #datediv {
	 	width: 400px;
	 	height: 400px;
		vertical-align: text-top;
		text-align: center;
	 }

		 
	.form {
	
	float : right;
	
	}
	
	section {
		margin-left : 80px; 
		margin-right : 80px; 
	}

img {

  max-width: 100%;
  max-height: 100%;
  margin: auto;
  display: block;


.img-content {

	background-color : 

}


}


</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
		<br>
		<br>


		<section class="content">
						
		<div style="float :left; width:50%;">
			<table class="table">
				
				<tr>
					<th>상품번호</th>
					<td>${itemdto.MINIPM_NAME}</td>
				</tr>
				<tr>
					<th>출발일</th>
					<td id="start">${itemdto.MINIPM_START}</td>
				</tr>
				<tr>
					<th>복귀일</th>
					<td id="end">${itemdto.MINIPM_END}</td>
				</tr>
				<tr>
					<th>성인가격</th>
					<td>${itemdto.MINIPM_PRICE1}</td>
				</tr>
				<tr>
					<th>아동가격</th>
					<td>${itemdto.MINIPM_PRICE2}</td>
				</tr>
				<tr>
					<th>유아가격</th>
					<td>${itemdto.MINIPM_PRICE3}</td>
				</tr>
				<tr>
					<th>일자</th>
					<td>1</td>
				</tr>
				<tr>
					<th>상품상태</th>
					<td>${itemdto.MSTATUS}</td>
				</tr>
	
				
				</table>				
		</div>			
						
						
		<div class="form">


		<form id="ticket-form" method="GET" action="/traco/minitour/jeju/minireservation.do">
			<table class="table">
				<input type="hidden" name="miniSeq" value="${itemdto.MINIPM_SEQ}"/>
				<input type="hidden" name="memberSeq" value="${memberSeq}"/>
				<input type="hidden" id="set-start" name="start" value=""/>
				<input type="hidden" id="set-end" name="end" value=""/>
				
				
				
				<tr><td id="datediv">
				
				  <label for="daterange">날짜선택:</label>
				  <input type="text" name="daterange" id="daterange" value="" />
				  

				</td></tr>

				
				<tr><td>
					<div  style="float:right;">
					<label class="h3" for="quantity">인원</label>
					<select id="quantity" name="quantity">
						<c:forEach var="i" begin="1" end="30">
							<option value="${i}">${i}명</option>
						</c:forEach>
					</select>
					</div>
				</td></tr>
				
				<tr><td>

					<button style="float:right;" type="submit" class="btn btn-primary btn-lg ">티켓 구입</button> 
				
				</td></tr>
			</table>
			
			</form>
		</div>
		
				</section>
				
	<section class="content">
		<div class="img-content">
		
			<img src="/traco/asset/images/miniimage/${itemdto.IMAGEM_SEQ}.png"  alt="...">
		
		
		
		
		
		
		</div>		
				
	</section>
				
				
				
				
				
				
				
				


			
			
			
			

		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	
	<script>
/* 			//hoisted
 			$(qlistLoad()); */
 	
			
			
			$('#daterange').click();

			
			
/* 			//문의사항 추가
			$('#btnAdd').click(()=>{
				
				let addContent = $("#addContent").val();
				
				
				$.ajax({
					type: 'POST',
					url: '/traco/packagetour/jeju/viewqlist.do',
					
					data: 'addContent=' + addContent,
					
					success: function(result) {
						//{ "result": 2 }
						alert("문의사항이 등록되었습니다.");
						$(qlistLoad());
					}
				});
				
			});			 */
			
			

/*   			//목록 가져오기
			function qlistLoad(){
	 			$.ajax({
					type: 'GET',
					url: '/traco/packagetour/jeju/viewqlist.do',
					data: 'pkSeq=' + `${pkSeq}`,
					dataType: 'json',
					success: function(list) {
						 list.forEach((item) => {
							 console.log("dto있어?");
							 $('.qna').append(`<tr><td>\${item.qnaSeq}</td></tr>`);
							 $('.qna').append(`<tr><td>\${item.qnaContent}</td></tr>`);
	 						 $('.qna').append(`<tr><td>\${item.qnaComment}</td></tr>`);
	 					 });
					}
				}); 
		
			}   */
	
 
	
	
	
			let startDate = `${itemdto.MINIPM_START}`;
			let slist = startDate.substr(0,10).split('-');
			let endDate = `${itemdto.MINIPM_END}`;
			let elist = endDate.substr(0,10).split('-');
			
			startDate = slist[1] + "/" + slist[2] + "/" + slist[0];
			endDate = elist[1] + "/" + elist[2] + "/" + elist[0];
		
			
			$('#daterange').daterangepicker({
			    "startDate": "01/18/2022",
			    "endDate": "01/24/2022",
			    "minDate": startDate,
			    "maxDate": endDate,
			    "opens": "center",
			    "alwaysShowCalendars": true,


			});
			
			
			
			
			
			
			$(function(){
				$(".applyBtn").text("적용");			
			});
		
			$(function() {			
				$("#ticket-form").submit(function(e){
					if (`${memberSeq}`) {
						alert("회원입니다.");
	
					}else {
						e.preventDefault();
						alert("로그인이 필요합니다.");
						
					}
				});
			});
			
			let start;
			let end;
			
			$('#daterange').on('apply.daterangepicker', function(ev, picker) {
				
				  start = picker.startDate.format('YYYY-MM-DD');
				  
				  end = picker.endDate.format('YYYY-MM-DD');
				  
				  $("#start").text(start);
				  $("#end").text(end);
				  $("#set-start").val(start);
				  $("#set-end").val(end);
				  
				  
				  
				});
			
			
			
			
	</script>
</body>
</html>