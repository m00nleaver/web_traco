package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/addflightok.do")
public class AddflightOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		
		String status = req.getParameter("status");
		String calendar = req.getParameter("calendar");
		String time = req.getParameter("time");
		time= calendar+" "+time+":00";
		String departure = req.getParameter("departure");
		String arrival = req.getParameter("arrival");
		String seatnum = req.getParameter("seatnum");
		String adult = req.getParameter("adult");
		String kid = req.getParameter("kid");
		String tod = req.getParameter("tod");
		String company = req.getParameter("company");
		
		AdminPDTO pdto = new AdminPDTO();
		AdminPDAO pdao = new AdminPDAO();
		
		pdto.setAirdate1(calendar);
		pdto.setAirdate2(time);
		pdto.setSeatnum(seatnum);
		pdto.setPadultprice(adult);
		pdto.setPkidprice(kid);
		pdto.setPtoddleprice(tod);
		pdto.setStatusseq(status);
		pdto.setAircomseq(company);
		pdto.setDepartseq(departure);
		pdto.setArrivalseq(arrival);
		
		int result = pdao.fadd(pdto);
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/addflightok.jsp");

		dispatcher.forward(req, resp);
	}
}
