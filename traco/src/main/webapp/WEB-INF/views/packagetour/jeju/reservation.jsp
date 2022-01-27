<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
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
	

}




#bankdiv { 
	position :relative;
	top : -220px;
	right: -500px;
}



</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		
		
		<br>
		<br>
		
		
		
		
		<section class="content">
			<div>
			<h1 class="h1">상품정보</h1>
			<hr style="height:2px;border-width:0;color:#ddd;background-color:#ddd">
			<table class="table">
				<tr>
						<th>상품명</th>
						<th>출발일</th>
						<th>복귀일</th>
						<th>성인가격</th>
						<th>아동가격</th>
						<th>유아가격</th>


					</tr>
					
			
					<tr>
						<td>${itemdto.pkName}</td>
						<td>${start}</td>
						<td>${end}</td>
						<td>${itemdto.adultPrice}</td>
						<td>${itemdto.kidPrice}</td>
						<td>${itemdto.toddlerPrice}</td>
						
					</tr>
		
		
			</table>
		<br>
		<br>
		
			
			</div>
			
			<div>
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
		
		
		
		<section class="content">
			
			
				<p class="h2">
					주문/예약자 
				</p>
				<p>
				  <input type="checkbox" id="is-member" name="is-member" value="false">
				  <label for="is-member">회원정보와 동일</label><br>
				 
				 </p>
				 
				 <div class="member">
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
				 <br>
				 </div>
				 

				
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
				 <button id="reserveBtn" class = "btn btn-primary btn-lg">예약하기</button>
				</div>
				 
				
			</div>
					
					

				<br>
				

				 <br>
				
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
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	
	
	
	
	
	
	<script>
		
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
	

			
			let price;
			let adult;
			let kid;
			let toddler;
			
			$("select[id='age']").change(()=>{
				 price = 0;
				let adult = 0;
				let kid = 0;
				let toddler = 0;

				$( "select[id='age'] option:selected" ).each(function() {
					 
					 if ($(this).val() >=12) {
					 price += parseInt(`${itemdto.adultPrice}`);
					 adult += 1;
				 	} 
					else if ($(this).val() >=2) {
					 price += parseInt(`${itemdto.kidPrice}`);
					 kid += 1;
				 	}
					else {
						 price += parseInt(`${itemdto.toddlerPrice}`);
						 toddler += 1;
					 	}
				 	});
				
				$("#price").val(price);
				$("#pricetd").text(price);
				$("#adulttd").text(adult);
				$("#kidtd").text(kid);
				$("#childtd").text(toddler);
				$("#reserve input[name='rez_adultcnt']").val(adult);
				$("#reserve input[name='rez_kidcnt']").val(kid);
				$("#reserve input[name='rez_kidcnt']").val(kid);
				$("#reserve input[name='rez_toddlercnt']").val(toddler);
				$("#reserve input[name='rez_toddlercnt']").val(toddler);
				
				
				
			});

			$("#reserve input[name='pkgpm_seq']").val(`${pkSeq}`);
			$("#reserve input[name='rez_date']").val(`${date}`);
			$("#reserve input[name='member_seq']").val(`${memberSeq}`);
			$("#reserve input[name='bankm_name']").val($("select[id='bank'] option:selected").val());
			
			$("select[id='bank']").change(()=>{
				
				$("#reserve input[name='bankm_name']").val($("select[id='bank'] option:selected").val());
				
			});
			
		let count = 0;
			

		$("#reserveBtn").click(  ()=>{
			
			$("#reserveBtn").attr('disabled', true);
			$("#reserveBtn").text("예약 진행중 ");
			$("#reserveBtn").append("<i class='fa fa-circle-o-notch fa-spin'></i>");
			
			
			
			
			
			$.ajax({
				type: 'POST',
				url: '/traco/packagetour/jeju/insert/reserve/rez.do',
				data: $('#reserve').serialize(),
				success: function(result) { 
						
					
					console.log(result);
					
					let res = Object.values(result)[0];
					
					count+= res;				
					}
				
				}).done( function (){
						
						$.ajax({
							type: 'POST',
							url: '/traco/packagetour/jeju/insert/reserve/packager.do',
							data: $('#reserve').serialize(),
							success: function(result) { 
									
								
								console.log(result);
								
								
								let res = Object.values(result)[0];
								
								count += res;
								
								}
								
							});
					}
				
				).done(
						
				function() { 
					
				function wait() {
						if (count == 2) {
							
							alert("예약완료");
							location.href = "/traco/main.do";
					
						} else {
							
							alert("예약실패");
						}
						
					}
					
					
					const waiting = setTimeout(wait, 5000);
					
				}
				);
				

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
		
/* 		
		function insertPackageR() {
			
			
			$.ajax({
				type: 'POST',
				url: '/traco/packagetour/jeju/insert/reserve/packager.do',
				data: $('#reserve').serialize(),
				success: function(result) { 
						
					
					console.log(result);
					}
				
				});
			
		}
		function insertRez() {
			
			
			$.ajax({
				type: 'POST',
				url: '/traco/packagetour/jeju/insert/reserve/rez.do',
				data: $('#reserve').serialize(),
				success: function(result) { 
						
					
					console.log(result);
					}
				
				});
			
		} */
		
		
	
	</script>
</body>
</html>