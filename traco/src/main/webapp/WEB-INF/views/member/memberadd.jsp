<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Code</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
<style>

   .panel {
      width: 700px;
      margin: 0 auto; 
      margin-top: 30px;
      text-align: left;
   }
   
   .panel-body div{
      margin-top: 30px;
   }
   .panel input[type=submit] {
      
      margin-top: 30px;
      width: 570px;
   }
   
   .panel .panel-body {
      width: 600px;
      margin: 0 auto; 
      text-align: left;
   }
   
</style>
</head>
<body>

	<!-- member/login.jsp -->
	<main class="main">
		<%@include file="/WEB-INF/views/inc/header.jsp" %>
		<section class="content">
		
			<form method="POST" action="/traco/member/memberaddok.do">
			<div class="panel panel-default">
				<div class="panel-heading">회원가입</div>
				<div class="panel-body">
				
						<div>아이디</div>
						<input type="text" id="member_id" name="member_id" class="form-control" placeholder="아이디" required autofocus>
						<input type="button" id="idaddbtn" class="btn btn-default" value="중복검사" >					
						<span id="result"></span>
						
						<div>비밀번호</div>
						<input type="password" name="member_pw" class="form-control" placeholder="비밀번호" required>
											
						<div>이름</div>
						<input type="text" name="member_name" class="form-control" placeholder="이름" required>
											
						<div>생년월일</div>
						<input type="text" name="member_birth" class="form-control" placeholder="생년월일" required>
						
						<div>성별</div>
						<select class="form-control" name ="member_gender" >
							<option value="m" >남</option>
							<option value="f" >여</option>
						</select>
												
						<div>이메일</div>
						<input type="email" name="member_email" class="form-control" placeholder="이메일" required>
						
						<input type="submit" id="addsubmit" value="회원가입하기" class="btn btn-primary" style="display:none;">
					
				</div>
			</div>
			</form>
		</section>
		<%@include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>
	
	<script>


		$('#idaddbtn').click(()=>{
		
		//1. 아이디 전송
		//2. 서버(중복 검사) > 1 or 0 반환
		//3. 결과에 따라 조치(메시지 출력)
		
		//데이터 주고(단일 데이터: 아이디) + 받고(단일 데이터: 숫자)
		$.ajax({
			type: 'GET',
			url: '/traco/member/memberadddata.do',
			data: 'member_id=' + $('#member_id').val(), //id=hong
			dataType: 'text',
			success: function(result) {
				if (result >= '1') {
					$('#result').css('color', 'tomato');
					$('#result').text('이미 사용중인 아이디입니다.');

					$("#addsubmit").hide();
						
				} else {
					$('#result').css('color', 'cornflowerblue');
					$('#result').text('사용가능한 아이디입니다.');			
				
					$("#addsubmit").show();

				}
				
				if (result >= '1'){
					$(document).ready(function(){
						  $("form").submit(function(){
						    alert("이미 사용중인 아이디입니다.");
						    return false;
						  });
						});
				} else{
					$(document).ready(function(){
						  $("form").submit(function(){
						    alert("회원가입하셨습니다.");
						    return true;
						  });
						});
				}
			
			}
			
		});
	});

		
	

	</script>


</body>
</html>