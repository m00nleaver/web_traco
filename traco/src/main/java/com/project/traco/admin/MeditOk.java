package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/meditok.do")
public class MeditOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 인코딩
		req.setCharacterEncoding("UTF-8");

		String seq = req.getParameter("seq");
		String thumbname = req.getParameter("thumbname");
		String imagename = req.getParameter("imagename");

		// 패키지명
		String pkgname = req.getParameter("pkgname");

		// 상품개수
		String items = req.getParameter("items");

		// 지역선택
		String area = req.getParameter("area");

		// 상품 상태
		String status = req.getParameter("status");

		// 기간
		String startday = req.getParameter("startday");
		String endday = req.getParameter("endday");
		

		// 썸네일
		String thumbs = req.getParameter("thumbs");

		// 가격
		String adult = req.getParameter("adult");
		String kid = req.getParameter("kid");
		String toddle = req.getParameter("toddle");

		// 상세내용
		String infoimage = req.getParameter("infoimage");
		
		//카테고리
		String ctgseq = req.getParameter("minictg");
		
		
		AdminPDAO pdao = new AdminPDAO();
		AdminPDTO pdto = new AdminPDTO();
		
		AdminIDAO idao = new AdminIDAO();
		AdminIDTO idto = new AdminIDTO();
		
		int iresult =1;
		int tresult =1;
		int ipresult =1;
		
		int pass=1;
		//수정전 이름과 수정후 이름이 같지 않으면 실행
		if(!imagename.equals(infoimage)) {
			idto.setImgname(infoimage); //상세 이미지 등록
			iresult = idao.iadd(idto); //상세 이미지등록
			pass=0;
		}
		
		if(!thumbname.equals(thumbs)) {
			idto.setThumbname(thumbs); //썸네일 등록
			tresult = idao.tadd(idto); //썸네일 등록
			idao.tupdate(seq);
			
		}
		
		pdto.setPname(pkgname); //패키지명
		pdto.setPcount(items); //상품개수
		pdto.setPstart(startday); //시작일
		pdto.setPend(endday); //끝나는일
		pdto.setPadultprice(adult); //어른가격
		pdto.setPkidprice(kid); //아동 가격
		pdto.setPtoddleprice(toddle); //유아가격
		pdto.setMinictgseq(ctgseq); //카테고리번호
		pdto.setAreaseq(area); 
		pdto.setMstatus(status); //판매상태
		pdto.setPseq(seq); //상품번호
		
		int mresult = pdao.medit(pdto);
		
		if(pass==0) {
			pdao.imdel(seq);
			ipresult = pdao.imadd(); //이미지 미니투어 연결
		}
		
		int result = iresult + tresult + ipresult + mresult;
		System.out.println(iresult);
		System.out.println(tresult);
		System.out.println(ipresult);
		
		System.out.println(result);
		req.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/meditok.jsp");

		dispatcher.forward(req, resp);
	}
}
