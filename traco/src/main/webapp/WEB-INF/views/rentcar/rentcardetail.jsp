<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
	.margin { min-height: 1300px;
  			 margin-left: 30px; }

	.rent-info .title .tableRent { 
			   float: right; 
			   border: 1px solid black;
}
	.margin .container .rent-info .title. .tableRent { display: inline-block; }
	
	.notice { 	padding: 50px;
				width: 500px; 
				font-size: 20px;
				
				}

</style>
</head>
<body>
	<main class="main">

		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="margin">
			<div class="container">
			<h1>렌트카상세</h1>
			
				

				<div id="detail-slider" class="detail-container">
					<div class="detail-slide">
						<img src="/traco/asset/images/rentdetail1.jpg" alt="hotcar">
					</div>
					
					<!-- <div class="rent-info">
								<div class="title">대여기준</div>
									<table class="tableRent">
										<tr>
											<th>탑승인원</th>
											<th>연료</th>
											<th>인수지역</th>
										</tr>
									</table>
							</div>
						</div>   -->
					
					
					
					<input type="button" value="예약하기" style= float:right;
						class="btn btn-default" 
						onclick="location.href='/traco/rentcar/reservation.do';">
						
						
					<div class="notice">
						
						
						*차량 색상지정은 불가하며 사진과 차량외관은 상이할 수 있습니다.<br>
						
						*기본 영업시간은 08:00~ 20:00입니다<br>
						
						*야간 배차 가능 : 20:00이후 ~22:00까지 (이후 시간불가)
						야간 인수가 가능하지만 시간당 10,000원 요금추가 됩니다
						(예)21:30 본사도착 배차료 20,000원)<br>
						
						야간배치는 추가 셔틀 운영이나 개별 픽업을 진행 해야 하기에 사전에 정확한
						항공시간을 본사에 알려 주셔야 진행 가능 합니다
						
						
						*조기반납 가능 : 07:00~ 08:00 (07시 이전 반납 불가)
						조기 반납비용 10,000 원 발생<br>
						조기 반납은 담당직원이 조기 출근하여 반납을 진행합니다.<br>
						차량 인수시 조기반납 예정이라고 고지 하셔야 가능합니다.<br>
						
						*애견동반 : 5키로미만 소형견에 한함 1마리당 50,000원 추가요금발생
						자동차 실내에서도 전용 케이지를 이용해야 합니다.<br>
						실내오염(털/분비물등) / 실내부품 파손시<br>
						클리닉 비용등 추가요금 발생 100,000~ 300,000만원<br>
						
						
						*낚시용품 지참 : 낚시용품 지참 불가입니다.<br>
						낚시용품 발견시 차량 인수 거절됩니다.<br>
						
						*탑승인원 : 탑승인원 초과시 차량인수는 거절되며 환불불가입니다.<br>
						영유아도 인원에 포함됩니다.<br>
						
						*연료 부족/환불 : 차량 반납 시 연료부족분은 고객님께서 지불하셔야 합니다.<br>
						반납시 남은 연료비 환불은 불가 합니다.<br>
											
					
					</div>
			
				
				
			</div>
		</section>
		
		
		
			

		
		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>
   
   
   <script>
   
   </script>
</body>
</html>