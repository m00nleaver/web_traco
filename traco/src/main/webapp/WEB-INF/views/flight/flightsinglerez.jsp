<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>
label {
	width: 120px;
}
th, td {
  text-align: center;
}

.content{
	padding-left : 100px;
	padding-right : 100px;
	min-height: 350px;

}
.orderbox{
min-height: 350px;
}
.rez_table{
height: 100px;}


#bankdiv { 
	position :relative;
	top : -220px;
	right: -500px;
}

</style>
</head>
<body>
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp"%>
		<section class="content">
			
			
			
			
			<h2>주문 / 예약</h2>
			
			<div class="rezpreview">
			<c:set var ="adulttotal" value ="0"/>
			<c:set var ="childtotal" value ="0"/>
			<c:set var ="toddlertotal" value ="0"/>
			<c:forEach items="${list4}" var="dto">
			<table class="rez_table">
			<tr>
			<th>이륙일</th>
			<th>이륙시간</th>
			<th>항공사</th>
			<th>출발지</th>
			<th>도착지</th>
			<th>성인가격</th>
			<th>아동가격</th>
			<th>소아가격</th>
			<th>잔여좌석</th>
			
			</tr>
			
			<tr>
			<td>${dto.airplanp_takeoffdate}</td>
			<td>${dto.airplanp_takeofftime}</td>
			<td>${dto.airplanl_name}</td>
			<td>${dto.sairport_name}</td>
			<td>${dto.eairport_name}</td>
			<td>${dto.airplanp_adultprice}</td>
			<td>${dto.airplanp_kidprice}</td>
			<td>${dto.airplanp_toddlerprice}</td>
			<td>${dto.airplanp_number}</td>
			</tr>
			</table>
			<c:set var ="adulttotal" value ="${total + dto.airplanp_adultprice}"/>
			<c:set var ="childtotal" value ="${total + dto.airplanp_kidprice}"/>
			<c:set var ="toddlertotal" value ="${total + dto.airplanp_toddlerprice}"/> 
			
			</c:forEach>
			
			</div>
			</section>
			
			<section class="content">
			
			<p class="h2">
					주문/예약자 
				</p>
			<!-- <h3>주문 / 예약자 정보</h3>
			 -->
			<p>
			<input type="checkbox" id="is-member" name="is-member" value="false"> 
			<label for="is-member">회원 정보와 동일</label><br>
			</p>		
			
			<div class="member">
			<!-- <input type="text" id="name" class="form-control" placeholder="이름" required>
			 -->
			<label for="name">이름</label>  					
  					<input type="text" id="name" name="name" placeholder="이름" /><br>
  					
			
			<!-- <input type="email" id="email" class="form-control" placeholder="이메일" required>
			 -->
			<label for="tel">전화번호</label>  	
  					<input  type="tel" id="tel" name="tel" placeholder="010-0000-0000"/><br>
  					
  					<label for="age">나이</label>  					
  					<select id="age" name="age">
						<c:forEach var="i" begin="1" end="100">
							<option value="${i}">${i}</option>
						</c:forEach>
						
					</select>
					<span>세</span><br>
					
  					<label for="gender">성별</label>  					
  					<select id="gender" name="gender">
							<option value="남자">남자</option>					
							<option value="여자">여자</option>
					</select><br>
					<label for="email">이메일</label>  	
  					<input type="email" id="email" name="email" placeholder="이메일"/><br>
  					
				<!-- 	<label for="email"></label>  	
  					<input class="member" type="text" id="request" name="request" placeholder="기타 요청 사항을 입력해주세요."/><br>

				 	 -->
				 <br>
				 </div>
			<%-- <label for="age">나이</label>
			<select id="age" name="age">
			<c:forEach var="i" begin="1" end="100">
				<option value="${i}">${i}</option>
			</c:forEach>
			</select>
			<span>세</span><br>
<!-- 			<div class="input-group">
			<input class="form-control" id="rez_date" type="date" />					
			</div> -->

			
			<select class="form-control" id="rez_gender" >
							<option value="m" >남</option>
							<option value="f" >여</option>
						</select>
			</div> --%>
			
			<c:if test = "${quantity != '0'}">
			<c:forEach var="j" begin="1" end="${quantity}">
				<p class="h2">
					동행자 ${j}
				</p> 
				<div>
				   	<label for="name">이름</label>  					
  					<input type="text" id="name" name="name" placeholder="이름" /><br>
  					
  					<label for="tel">전화번호</label>  	
  					<input  type="tel" id="tel" name="tel" placeholder="010-0000-0000"/><br>
  					
  					<label for="age">나이</label>  					
  					<select id="age" name="age">
						<c:forEach var="i" begin="1" end="100">
							<option value="${i}">${i}</option>
						</c:forEach>
						
					</select>
					<span>세</span><br>
					
  					<label for="gender">성별</label>  					
  					<select id="gender" name="gender">
							<option value="남자">남자</option>					
							<option value="여자">여자</option>
					</select><br>
					<label for="email">이메일</label>  	
  					<input type="email" id="email" name="email" placeholder="이메일"/><br>
  					
				<!-- 	<label for="email"></label>  	
  					<input class="member" type="text" id="request" name="request" placeholder="기타 요청 사항을 입력해주세요."/><br>

				 	 -->
				 
				 </div>
				 <br>
				</c:forEach>
			</c:if>
			
			</section>
			
			<section class="content">
			<div class ="orderbox">
			<h1 class="h1">주문내역</h1>
			<hr style="height:2px;border-width:0;color:#ddd;background-color:#ddd">
			<table class="table">
				<tr>
						<th>성인</th>
						<th>아동</th>
						<th>유아</th>
						<th colspan="3">총 결제금액</th>

					</tr>
					
			
					<tr>
						<td id="adulttd"></td>
						<td id="kidtd"></td>
						<td id="childtd"></td>
						<td colspan="3" id="pricetd"></td>

						
					</tr>
		
		
			</table>
			
			
			</div>
			
			</section>
			

			<!-- <div class="input-group">
			<label for="price">총 가격</label>  					
				<input type="text" id="price" name = "price"/> 
				<span>원</span>
			</div> -->
			
			<!-- hidden -->
				<section class="content">
				<div id="bankdiv">
			
				<div style="padding-left:110px;"class="h2">입금은행</div>
				<div>
			   		<label for="bank"></label>  					
 		  			<select class="h3" id="bank" name="bank">
						<option value="신한은행">신한은행</option>
						<option value="국민은행">국민은행</option>
						<option value="농협">농협</option>
						<option value="우리은행">우리은행</option>
						<option value="하나은행">하나은행</option>
					</select>
					<input type="text" id="ac-name" name="ac-name" placeholder="입금자명" /><br>
				</div>
				
				<div style="position : relative; right : -110px; top : 50px;">
				 <button id="reserveBtn" class = "btn btn-primary btn-lg"onclick="location.href='/traco/flightrezok.do'">예약하기</button>
				</div>
				 
				
			</div>
				
				
				<%-- <form method="POST" id="reserve" action="/traco/flightrezok.do">
				<div class="input-group">
			<h4>입금은행</h4>
			<select id="bank" name ="bank" >
							<option value="1" >신한은행</option>
							<option value="2" >국민은행</option>
							<option value="3" >농협</option>
							<option value="4" >우리은행</option>
							<option value="5" >하나은행</option>
						</select>
			
			<input type="text" id ="rez_bankname" name ="rez_bankname" placeholder="입금자명">
			</div>
				
					<label for="rez_date">예약일자</label>
					<input type="text" name="rez_date"/>
					<label for="rez_adultcnt">어른</label>
					<input type="text" name="rez_adultcnt"/>
					<label for="rez_kidcnt">아이</label>
					<input type="text" name="rez_kidcnt"/>
					<label for="rez_toddlercnt">유아</label>
					<input type="text" name="rez_toddlercnt"/>
					<label for="member_seq">회원번호</label>
					<input type="text" name="member_seq"/>				
								
					<input type="hidden" name="member_seq" value="${member_seq}"/>
					<input type="hidden" name="single_seq" value="${single_seq}"/>
					<input type="hidden" name="double_seq" value="${double_seq}"/>
				
				<p align="center">
				 <button id="reserveBtn" class = "btn btn-primary">예약하기</button>
				</p> 
				</form> --%>
				
				<!-- hidden -->
				<form id="reserve">
					<input type="hidden" name="pkgpm_seq"/>
					<input type="hidden" name="rez_date"/>
					<input type="hidden" name="rez_adultcnt"/>
					<input type="hidden" name="rez_kidcnt"/>
					<input type="hidden" name="rez_toddlercnt"/>
					<input type="hidden" name="member_seq"/>				
					<input type="hidden" name="bankm_name"/>				
				</form>
			

		</section>

		<%@include file="/WEB-INF/views/inc/footer.jsp"%>
	</main>

	<script>
	//회원 정보 동일
	$('#is-member').click(()=>{
		
		let checked = $('#is-member').is(':checked');
		
		if (checked) {
			$(memberInfo());
			
		}
		
	});
	
	function memberInfo(){
		$.ajax({
		type: 'GET',
		url: '/traco/packagetour/jeju/member.do',
		data: 'memberSeq=' + `${memberSeq}`,
		dataType: 'json',
		success: function(dto) { 

			$(".member #name").val(`\${dto.name}`);
			$(".member #age").val(`\${dto.birth}`);
			$(".member #email").val(`\${dto.email}`);
			$(".member #gender").val(`\${dto.gender}`);
		
			
			
		}
		
	});

}  
	//현재 날짜 가져오기
	
	var today = new Date();

	var year = today.getFullYear();
	var month = ('0' + (today.getMonth() + 1)).slice(-2);
	var day = ('0' + today.getDate()).slice(-2);
	
	var hours = ('0' + today.getHours()).slice(-2); 
	var minutes = ('0' + today.getMinutes()).slice(-2);
	var seconds = ('0' + today.getSeconds()).slice(-2); 
	
	var dateString = year + '-' + month  + '-' + day +' ' + hours + ':' + minutes  + ':' + seconds;
	
	
	
	$("input[name='rez_date']").val(dateString);

	let price;
	let adult;
	let kid;
	let toddler;
	
	
	
	$("select[id='age']").change(()=>{
		let price = 0;
		let adult = 0;
		let kid = 0;
		let toddler = 0;
		
		$( "select[id='age'] option:selected" ).each(function() {
			 
			 if ($(this).val() >=12) {
			 price += parseInt(`${adulttotal}`);
			 adult += 1;
		 	} 
			else if ($(this).val() >=2) {
			 price += parseInt(`${childtotal}`);
			 kid += 1;
		 	}
			else {
				 price += parseInt(`${toddlertotal}`);
				 toddler += 1;
			 	}
		 	});
		
		$("#price").val(price);
		$("#pricetd").text(price);
		$("#adulttd").text(adult);
		$("#kidtd").text(kid);
		$("#childtd").text(toddler);
		
		
	});
	
	
	
	$("#reserve input[name='member_seq']").val(`${memberSeq}`);
	
	
	

	</script>
</body>

</html>
</body>
</html>