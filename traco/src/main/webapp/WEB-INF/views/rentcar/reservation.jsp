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
	width: 80px;
}

	table, th, td {
	  border: 1px solid black;
	/*   border-collapse: collapse;
	 */}

</style>
</head>
<body>

	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
			
			
			<!--  <table class="content">
				
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
				
			
				
			</table> -->
			
				<p class="h2">
					주문/예약자 
				</p>
				<!--  <p>
				  <input type="checkbox" id="is-member" name="is-member" value="false">
				  <label for="is-member">회원정보와 동일</label><br>
				 
				 </p> -->
				 
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
  					
				
				 <br>
				 </div>
				 
				 <p class="h2">
					운전자 정보
				</p>
				<!--  <p>
				  <input type="checkbox" id="is-member" name="is-member" value="false">
				  <label for="is-member">회원정보와 동일</label><br>
				 
				 </p> -->
				 
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
  					
				
				 <br>
				 </div>
				 

				
			<!-- <c:if test = "${quantity != '0'}">
			<c:forEach var="j" begin="1" end="${quantity}"> -->
				<p class="h2">
					운전자 ${j}
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
			<!--  	</c:forEach> 
			</c:if> -->
			
			
				<p class="h3">
					입금은행
				</p> 
				<div>
			   		<label for="bank"></label>  					
 		  			<select id="bank" name="bank">
						<option value="신한은행">신한은행</option>
						<option value="국민은행">국민은행</option>
						<option value="농협">농협</option>
						<option value="우리은행">우리은행</option>
						<option value="하나은행">하나은행</option>
					</select>
					<input type="text" id="ac-name" name="ac-name" placeholder="입금자명" /><br>
					
					
				<p class="h3">
					결제금액
				</p> 
				<p> 
					37400원
				</p>

					
					

				 </div>
				<br>
				
				<p align="center">
				 <button id="reserveBtn" class = "btn btn-primary" onclick="location.href='/traco/rentcar/reservationok.do';">예약하기</button>
				</p> 
				
				<p align="center">
				 <button id="returnBtn" class = "btn btn-primary" onclick="location.href='/traco/rentcar/rentcar.do';">돌아가기</button>
				</p> 
				 
				 <br>

			<!--  <label for="price">총 가격</label>  					
				<input type="text" id="price" name = "price"/> 
				
				<!-- hidden -->
				<!--  <form id="reserve">
					<input type="text" name="pkgpm_seq"/>
					<input type="text" name="rez_date"/>
					<input type="text" name="rez_adultcnt"/>
					<input type="text" name="rez_kidcnt"/>
					<input type="text" name="rez_toddlercnt"/>
					<input type="text" name="member_seq"/>				
					<input type="text" name="bankm_name"/>				
				</form> -->
				
							


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
				$("#reserve input[name='rez_adultcnt']").val(adult);
				$("#reserve input[name='rez_kidcnt']").val(kid);
				$("#reserve input[name='rez_toddlercnt']").val(toddler);
				
				
			});

			$("#reserve input[name='pkgpm_seq']").val(`${pkSeq}`);
			$("#reserve input[name='rez_date']").val(`${date}`);
			$("#reserve input[name='member_seq']").val(`${memberSeq}`);
			$("#reserve input[name='bankm_name']").val($("select[id='bank'] option:selected").val());
			
			$("select[id='bank']").change(()=>{
				
				$("#reserve input[name='bankm_name']").val($("select[id='bank'] option:selected").val());
				
			});
			
		$("#reserveBtn").click(()=>{
			
				$.ajax({
				type: 'POST',
				url: '/traco/packagetour/jeju/insert/reserve/d.do',
				data: $('#reserve').serialize(),
				success: function(result) { 

				
					}
				
				}).then(			
					$.ajax({
					type: 'POST',
					url: '/traco/packagetour/jeju/insert/reserve/d.do',
					data: $('#reserve').serialize(),
					success: function(result) { 

					
						}
					
					}));
				 	
		});
		

	
	
	</script>
</body>
</html>