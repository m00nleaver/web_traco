<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<style>
 

 .content { min-height: 1700px;
  			 margin-left: 30px; }
  			 
  legend {
  	border: 1px solid black;
    background-color: none;
    color: #000;
    padding: 3px 6px;
}
  			 
  .btns { float: right; 
 		   margin-bottom: 20px;
 		}
 
 h2 { text-align: center; 
 	  font-size: 30px;
 
 }
 
 .pcar { text-align: center; }
 
 .p1 { border: 1px solid black;
 	   float: left; 
 	   margin-right: 100px;
 	   width: 200px;
 	   height: 500px;
 	   
}
 .p2 { border: 1px solid black; 
 	   float: left; 
 	   margin-right: 100px;
 	   width: 200px;
 	   height: 500px;
 	  
 
 }
 .p3 { border: 1px solid black; 
  	   margin-right: 100px;
 	   float: left; 
 	   width: 200px;
 	   height: 500px;
 	   
 
 }
 
  h3 { text-align: center; 
 	  font-size: 30px;
 }
 
 .e1 { border: 1px solid black;
 	   float: left; 
 	   margin-right: 100px;
 	   width: 200px;
 	   height: 500px;
 	   vertical-align: middle;
}
 .e2 { border: 1px solid black; 
 	   float: left; 
 	   margin-right: 100px;
 	   width: 200px;
 	   height: 500px;
 	    vertical-align: middle;
 
 }
 .e3 { border: 1px solid black; 
  	   margin-right: 100px;
 	   float: left; 
 	   width: 200px;
 	   height: 500px;
 	    vertical-align: middle;
 
 }
 
</style>
</head>
<body>
<!-- 렌트카 메인화면 -->

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			<div class="rentcar">
			<h1>렌트카</h1>
			
			
			<form>
				<fieldset>
					<legend>렌트카 검색</legend>

					<select name="boheom">
						<option>보험선택</option>
						<option value="1">완전자차</option>
						<option value="2">일반자차</option>
					</select>
					
					<br>
					
					<select name="takeplace">
						<option>인수장소</option>
						<option value="1">제주</option>
						<option value="2">부산</option>
						<option value="3">서울</option>
						<option value="4">대구</option>
						<option value="5">인천</option>
						<option value="6">광주</option>
						<option value="7">경기</option>
						<option value="8">울산</option>
						<option value="9">세종</option>
						<option value="10">충남</option>
						<option value="11">충북</option>
						<option value="12">전남</option>
						<option value="13">전북</option>
					</select>
					
					<br>
					
				<div class="date">	
					<input type="text" value="인수일자" id="takedate">
				
					<input type="text" value="반납일자" id="returndate">
				</div>		
					
				<div class="btns">
			
				<input type="button" value="검색"
					class="btn btn-default"
					onclick="location.href='/traco/rentcar/rentcarlist.do';">
				
				<!-- <input type="button" value="검색"
				class="btn btn-default"
				onclick="location.href='/traco/rentcar/rentcardetail.do';"> -->
		
				
				</div>
					
			
				</fieldset>
				
				<h2>인기있는 자동차</h2>
				
				<div class="pcar">
					<div class="item1">
						<img src="/traco/asset/images/starex1.jpg" alt="hotcar"
								style="width: 100%; height: 200px;">
					</div>
					<div class="item2">
						<img src="/traco/asset/images/car2.jpg" alt="hotcar"
								style="width: 100%; height: 200px;">
					</div>
					<div class="item3">
						<img src="/traco/asset/images/car3.jpg" alt="hotcar"
								style="width: 100%; height: 200px;">
					</div>
				</div>
				
				
				<h2>트레코 특별 이벤트</h2>
				
				
				<div id="slideShow">
					
						<img src="/traco/asset/images/event1.jpg" alt="event"
							style="width: 100%; height: 600px;">
				

				</div>
				
				
				
		
				
			</form>
		</div>
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
	
	  $(function(){
	         $("#takedate,#returndate").datepicker({
	             dateFormat: 'yy-mm-dd' //달력 날짜 형태
	             ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
	             ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
	             ,changeYear: true //option값 년 선택 가능
	             ,changeMonth: true //option값  월 선택 가능                
	             ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
	             ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
	             ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
	             ,buttonText: "선택" //버튼 호버 텍스트              
	             ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
	             ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
	             ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
	             ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
	             ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
	             ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
	             ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
	         });                   
	         
	         //초기값을 오늘 날짜로 설정
	         $('#datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
	      })
	      
	      
	   


	
	</script>
</body>
</html>