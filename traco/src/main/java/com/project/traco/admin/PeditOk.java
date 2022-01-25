package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/peditok.do")
public class PeditOk extends HttpServlet {
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
		String days = req.getParameter("days");

		// 썸네일
		String thumbs = req.getParameter("thumbs");

		// 가격
		String adult = req.getParameter("adult");
		String kid = req.getParameter("kid");
		String toddle = req.getParameter("toddle");

		// 상세내용
		String infoimage = req.getParameter("infoimage");
		
		

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
		pdto.setPstatus(status); //상태
		pdto.setAreaseq(area); //아직 안만듬
		pdto.setPkgpriod(days); //일수
		pdto.setPstatus(status); //판매상태
		pdto.setPseq(seq); //상품번호
		
		int presult = pdao.pedit(pdto);
		
		if(pass==0) {
			pdao.ipdel(seq);
			ipresult = pdao.ipadd(); //이미지 패키지 연결
		}
		
		int result = iresult + tresult + ipresult + presult;
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/peditok.jsp");

		dispatcher.forward(req, resp);
	}
}
