package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/addminiok.do")
public class AddminiOk extends HttpServlet {
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
		
		
		//썸네일
		String thumbs = req.getParameter("thumbs");
		
		//가격
		String adult = req.getParameter("adult");
		String kid = req.getParameter("kid");
		String toddle = req.getParameter("toddle");
		
		//상세내용
		String infoimage = req.getParameter("infoimage");
		
		//카테고리
		String minictg = req.getParameter("minictg");
		
		
		//3.
		AdminIDAO idao = new AdminIDAO();
		AdminIDTO idto = new AdminIDTO();
		
		idto.setThumbname(thumbs); //썸네일 등록
		idto.setImgname(infoimage); //상세 이미지 등록
		
		AdminPDAO pdao = new AdminPDAO();
		
		AdminPDTO pdto = new AdminPDTO();
		
		pdto.setPname(pkgname); //패키지명
		pdto.setPcount(items); //상품개수
		pdto.setPstart(startday); //시작일
		pdto.setPend(endday); //끝나는일
		pdto.setPadultprice(adult); //어른가격
		pdto.setPkidprice(kid); //아동 가격
		pdto.setPtoddleprice(toddle); //유아가격
		
		pdto.setAreaseq(area);
		pdto.setMinictgseq(minictg);
		pdto.setMstatus(status);
		
		int	mresult = pdao.madd(pdto); //미니투어 등록
		
		
		
		int tresult = idao.tadd(idto); //썸네일 등록		
		int iresult = idao.iadd(idto); //상세 이미지등록
		int imresult = pdao.imadd(); //이미지미니투어 등록
		
		
		int result = tresult+iresult+imresult+mresult;
		
		//req.setAttribute("tresult", tresult); //썸네일
		//req.setAttribute("iresult", iresult);	//이미지
		//req.setAttribute("imresult", imresult);	//이미지미니투어
		//req.setAttribute("mresult", mresult);	//미니투어
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/addminiok.jsp");

		dispatcher.forward(req, resp);
	}
}
