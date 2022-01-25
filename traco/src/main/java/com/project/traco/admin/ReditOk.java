package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/reditok.do")
public class ReditOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		String seq = req.getParameter("seq");
		String thumbname = req.getParameter("thumbname");  //기존썸네일
		String thumbseq = req.getParameter("thumbseq");//기존썸네일
		
		String carname = req.getParameter("name");
		String price = req.getParameter("price");
		String count = req.getParameter("count");
		String kindseq = req.getParameter("kind");
		String seatnum = req.getParameter("seatnum");
		String status = req.getParameter("status");
		String areaseq = req.getParameter("h_area1");
		String thumb = req.getParameter("thumb"); //수정후 썸네일
		String manufseq = req.getParameter("manuf");
		String fuelseq = req.getParameter("fuel");
		
		//지역번호 바꿔주기
		areaseq = changeareaseq(areaseq);
		
		AdminPDAO pdao = new AdminPDAO();
		AdminPDTO pdto = new AdminPDTO();
		
		AdminIDAO idao = new AdminIDAO();
		AdminIDTO idto = new AdminIDTO();
	
		int tresult = 1;
		if(!thumbname.equals(thumb)) {
			idto.setThumbname(thumb);
			tresult = idao.tadd(idto); //썸네일 등록
			idao.rtupdate(seq);
		}
		
		pdto.setCarname(carname);
		pdto.setSeatnum(seatnum);
		pdto.setCarcount(count);
		pdto.setCarprice(price);
		pdto.setManufseq(manufseq);
		pdto.setFuelseq(fuelseq);
		pdto.setKindseq(kindseq);
		pdto.setAreaseq(areaseq);
		pdto.setCstatus(status);
		pdto.setCarseq(seq);
		
		int rresult = pdao.rupdate(pdto);
		
		int result = rresult +tresult;
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/reditok.jsp");

		dispatcher.forward(req, resp);
	}
	
	private String changeareaseq(String areaseq) {
		if(areaseq.equals("1")) {
			areaseq="230";
		}else if(areaseq.equals("2")) {
			areaseq="231";
		}else if(areaseq.equals("3")) {
			areaseq="233";
		}else if(areaseq.equals("4")) {
			areaseq="234";
		}else if(areaseq.equals("5")) {
			areaseq="235";
		}else if(areaseq.equals("6")) {
			areaseq="236";
		}else if(areaseq.equals("7")) {
			areaseq="237";
		}else if(areaseq.equals("8")) {
			areaseq="239";
		}else if(areaseq.equals("10")) {
			areaseq="238";
		}else if(areaseq.equals("11")) {
			areaseq="244";
		}else if(areaseq.equals("12")) {
			areaseq="245";
		}else if(areaseq.equals("13")) {
			areaseq="242";
		}else if(areaseq.equals("14")) {
			areaseq="243";
		}else if(areaseq.equals("15")) {
			areaseq="246";
		}else if(areaseq.equals("16")) {
			areaseq="241";
		}else if(areaseq.equals("17")) {
			areaseq="240";
		}
		return areaseq;
	}
	
	
}