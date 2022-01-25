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

	table, th, td {
	  border: 1px solid black;
	/*   border-collapse: collapse;
	 */}
	 #datediv {
	 	width: 600px;
	 	height: 400px;
		vertical-align: text-top;
		text-align: center;
	 }
	 div.sticky {
	  position: -webkit-sticky;
	  position: sticky;
	  top: 0;
	  background-color: yellow;
	  padding: 50px;
	  font-size: 20px;
	}
		 

</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
						

		<form id="ticket-form" method="GET" action="/traco/packagetour/jeju/reservation.do">
			<table class="content">
				<input type="hidden" name="pkSeq" value="${itemdto.pkSeq}"/>
				<input type="hidden" name="memberSeq" value="${memberSeq}"/>
				
				
				<tr><th>제목</th></tr>
				
				<tr><td id="datediv">
				
				  <label for="daterange">날짜선택:</label>
				  <input type="text" name="daterange" id="daterange" value="" />
				  

				</td></tr>

				
				<tr><td>
					<label for="quantity">인원</label>
					<select id="quantity" name="quantity">
						<c:forEach var="i" begin="1" end="30">
							<option value="${i}">${i}명</option>
						</c:forEach>
					</select>
				</td></tr>
				
				<tr><td>

					<button type="submit" class="btn btn-primary">티켓 구입</button> 
				
				</td></tr>
			</table>
			
			
			
				
			<table class="content">
				
				<tr>
					<th>상품번호</th> 
					<th>상품명</th>
					<th>판매개수</th>
					<th>출발일</th>
					<th>복귀일</th>
					<th>성인가격</th>
					<th>아동가격</th>
					<th>유아가격</th>
					<th>썸네일번호</th>
					<th>썸네일이름</th>
					<th>이미지번호</th>
					<th>지역이름</th>
					<th>일자</th>
					<th>상품상태</th>
				</tr>
				
		
				<tr>
					<td>${itemdto.pkSeq}</td>
					<td>${itemdto.pkName}</td>
					<td>${itemdto.pkQuantity}</td>
					<td>${itemdto.pkStartDate}</td>
					<td>${itemdto.pkEndDate}</td>
					<td>${itemdto.adultPrice}</td>
					<td>${itemdto.kidPrice}</td>
					<td>${itemdto.toddlerPrice}</td>
					<td>${itemdto.pkThumbSeq}</td>
					<td>${itemdto.pkThumbName}</td>
					<td>${itemdto.pkImageSeq}</td>
					<td>${itemdto.pkAreaName}</td>
					<td>${itemdto.pkPeriod}</td>
					<td>${itemdto.pkStatus}</td>
				</tr>
				
				</table>
			</form>
				
			<table class="content qna">
				
				<tr><td>이용문의</td></tr>

				<tr><td style="width:700px; text-align:center;">
				
				<form id="addQna">
				<textarea style="width:700px;" rows="5"  id="addContent" placeholder="댓글을 작성하세요"></textarea>
	         		<br>
		         <button type="button" id="btnAdd">문의사항 추가</button>
		        </form> 
				</td></tr>
				
				<tr></tr>				
				
					
			</table>

			
			
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	
	<script>
			//hoisted
 			$(qlistLoad());
 	
			
			
			
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
			
			

  			//목록 가져오기
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
		
			}  
	
 
	
	
	
			let startDate = `${itemdto.pkStartDate}`;
			let slist = startDate.substr(0,10).split('-');
			let endDate = `${itemdto.pkEndDate}`;
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
			
			
			
			
			$('#daterange').click();
			
			
			$(function(){
				$(".applyBtn").text("적용");			
			});
		
			$(function() {			
				$("#ticket-form").submit(function(e){
					if (`${memberSeq}`== "0") {
						e.preventDefault();
						alert("로그인안됨");
					}else {
						
						alert("회원임")
					}
				});
			});
			
			
			
			
			
			/* 문의하기 */
			
			
			
			//댓글 쓰기 (버튼을 눌러서 id값이 넘어와 실행되는 자바스크립트 구문)
		    $("#btnReply").click(function(){
		        var replytext=$("#replytext").val(); //댓글 내용
		        var bno="1"; //게시물 번호
		        var param={ "replytext": replytext, "bno": bno};
		        //var param="replytext="+replytext+"&bno="+bno;
		        $.ajax({
		            type: "get", //데이터를 보낼 방식
		            url: "${path}/reply/insert.do", //데이터를 보낼 url
		            data: param, //보낼 데이터

		            success: function(){ //데이터를 보내는것이 성공했을시 출력되는 메시지
		                alert("댓글이 등록되었습니다.");
		                listReply2(); //댓글 목록 출력
		            }
		        });
		    });

			

			
			
			
			
			
			
	</script>
</body>
</html>