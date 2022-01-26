<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
	/* .contentname {visibility: hidden;}
	.info {visibility: hidden;} */
	.table.adminmenu {border-bottom: 0px;}
	.table>tbody>tr>th {vertical-align: middle;}
	.adminheader{width:1200px; height:250px;}
	.title{width:1200px; text-align:center; margin:0 auto; padding:20px;}
	.logo{width:150px;}
	.title span{font-size:30px;}
	.title .glyphicon:hover{color:cornflowerblue; cursor:pointer;}
	#open{visibility: hidden;}
	
	
	
</style>

<header class="adminheader">

	<div class="title"><img class="logo" src="/traco/asset/images/logo/logo.png" alt="로고"><span style="margin-right:20px;">관리자 페이지</span><span class="glyphicon glyphicon-home" onclick="location.href='/traco/main.do';"></span></div>
	
	<table class="table table-hover adminmenu" style="border-collapse: separate;">
		<tr>
			<th><input type="button" value="숨기기" class="btn btn-primary" id="hide">
				<input type="button" value="전체보기" class="btn btn-primary" id="open">
			</th>
			<th>여행 상품 관리</th>
			<th>렌트카 관리</th>
			<th>항공권 관리</th>
			<th>정보 관리</th>		
			<th>커뮤니티 관리</th>
			<th>회원 관리</th>
		</tr>
		<tr class="contentname">
			<td class="info"></td>
			<td class="info"><a href="/traco/admin/addpackage.do">패키지등록</a></td>
			<td class="info"><a href="/traco/admin/addcar.do">렌트카등록</a></td>
			<td class="info"><a href="/traco/admin/addflight.do">항공권등록</a></td>
			<td class="info"><a href="/traco/admin/addbanner.do">배너등록</a></td>
			<td class="info"><a href="/traco/admin/comulist.do">커뮤니티관리</a></td>
			<td class="info"><a href="/traco/admin/memlist.do">회원관리</a></td>
		</tr>
		<tr class="contentname">
			<td class="info"></td>
			<td class="info"><a href="/traco/admin/plist.do">패키지수정</a></td>
			<td class="info"><a href="/traco/admin/rlist.do">렌트카조회/수정</a></td>
			<td class="info"><a href="/traco/admin/flist.do">항공권조회/수정</a></td>
			<td class="info"><a href="/traco/admin/blist.do">배너조회/수정</a></td>
			<td class="info"></td>
			<td class="info"></td>
		</tr>
		<tr class="contentname">
			<td class="info"></td>
			<td class="info"><a href="/traco/admin/addmini.do">미니투어등록</a></td>
			<td class="info"></td>
			<td class="info"><a href="/traco/admin/fconfirm.do">항공권예약승인</a></td>
			<td class="info"><a href="">해시태그관리</a></td>
			<td class="info"></td>
			<td class="info"></td>
		</tr>
		<tr class="contentname">
			<td class="info"></td>
			<td class="info"><a href="/traco/admin/mlist.do">미니투어수정</a></td>
			<td class="info"></td>
			<td class="info"></td>
			<td class="info"></td>
			<td class="info"></td>
			<td class="info"></td>
		</tr>
	</table>

</header>

<script>


	$('#hide').click(function(){		
		$('.contentname').css('visibility','hidden');
		$('.info').css('visibility','hidden');
		$('#hide').css('visibility','hidden');	
		$('#open').css('visibility','visible');
	});


	$('#open').click(function(){
		$('.contentname').css('visibility','visible');
		$('.info').css('visibility','visible');
		$('#open').css('visibility','hidden');
		$('#hide').css('visibility','visible');
	});
</script>
