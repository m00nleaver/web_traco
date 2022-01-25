package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.traco.admin.AdminIDAO;
import com.project.traco.admin.AdminIDTO;

@WebServlet("/admin/addcarok.do")
public class AddcarOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 인코딩
		req.setCharacterEncoding("UTF-8");
		
		//2. 데이터 받기
		String name = req.getParameter("name"); //자동차명
		String price = req.getParameter("price"); //가격
		String count = req.getParameter("count"); //개수
		String kindseq = req.getParameter("kind"); //크기종류
		String seatnum = req.getParameter("seatnum"); //수용인원
		String status = req.getParameter("status"); //대여상태
		String thumb = req.getParameter("thumb"); //썸네일
		String areaseq = req.getParameter("h_area1"); //지역번호
		String areasecond = req.getParameter("h_area2"); //지역번호
		String manufseq = req.getParameter("manuf"); //제조사 번호
		String fuelseq = req.getParameter("fuel"); //연료번호
		System.out.println(seatnum);
		//System.out.println(areasecond);
		//지역번호 변경
		areaseq = changeareaseq(areaseq);
		
		AdminPDTO pdto = new AdminPDTO();
		AdminPDAO pdao = new AdminPDAO();
		


		
		pdto.setThumbname(thumb);
		int tresult = pdao.tadd(pdto); //썸네일 등록
		
	
		//System.out.println(req.getParameter("h_area1"));
		pdto.setCarname(name);
		pdto.setSeatnum(seatnum);
		pdto.setCarcount(count);
		pdto.setCarprice(price);
		pdto.setManufseq(manufseq);
		pdto.setFuelseq(fuelseq);
		pdto.setKindseq(kindseq);
		pdto.setAreaseq(areaseq);
		pdto.setAreasname(areasecond);
		pdto.setCstatus(status);
		
		int rresult = pdao.radd(pdto);
		
		int result = rresult + tresult;
		
		req.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/addcarok.jsp");

		dispatcher.forward(req, resp);
	}

	
	//지역번호바꿔주기
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