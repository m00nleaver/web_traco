package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/addpackageok.do")
public class AddpackageOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//할일
		//1. POST > 인코딩
		//2. 데이터 가져오기(subject, content)
		//3. DB 작업 > insert > DAO 위임
		//4. 결과 피드백 > JSP 위임
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		//2.
		
		//패키지명
		String pkgname = req.getParameter("pkgname");
		
		//상품개수
		String items = req.getParameter("items");
		
		
		
		//지역선택
		String area = req.getParameter("area");
		
		//상품 상태
		String status = req.getParameter("status");
		
		//기간
		String startday = req.getParameter("startday");
		String endday = req.getParameter("endday");
		String days = req.getParameter("days");
		
		//썸네일
		String thumbs = req.getParameter("thumbs");
		
		//가격
		String adult = req.getParameter("adult");
		String kid = req.getParameter("kid");
		String toddle = req.getParameter("toddle");
		
		//상세내용
		String infoimage = req.getParameter("infoimage");
		
		
		//3.
		AdminPDAO pdao = new AdminPDAO(); //패키지
		AdminPDTO pdto = new AdminPDTO();
		AdminIDAO idao = new AdminIDAO(); //이미지
		AdminIDTO idto = new AdminIDTO();
		
		//이미지 등록부터
		idto.setThumbname(thumbs); //썸네일 등록
		idto.setImgname(infoimage); //상세 이미지 등록
		

		int tresult = idao.tadd(idto); //썸네일 등록		
		int iresult = idao.iadd(idto); //상세 이미지등록
		
		
		
		//패키지등록
		pdto.setPname(pkgname); //패키지명
		pdto.setPcount(items); //상품개수
		pdto.setPstart(startday); //시작일
		pdto.setPend(endday); //끝나는일
		pdto.setPadultprice(adult); //어른가격
		pdto.setPkidprice(kid); //아동 가격
		pdto.setPtoddleprice(toddle); //유아가격
		
		pdto.setAreaseq(area); //아직 안만듬
		pdto.setPkgpriod(days); //일수
		pdto.setPstatus(status); //판매상태
		
		int	presult = pdao.padd(pdto);
		
	
		
		int ipresult = pdao.ipadd();
		
		
		
		int result = presult+tresult+iresult+ipresult;
		
		req.setAttribute("result", result);
		
		//req.setAttribute("presult", presult);
		//req.setAttribute("tresult", tresult);
		//req.setAttribute("iresult", iresult);
		//req.setAttribute("ipresult", ipresult);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/addpackageok.jsp");
		

		dispatcher.forward(req, resp);
	}
}
