package com.project.traco.flightticket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/flightrezok.do")
public class Flightrezok extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 
		req.setCharacterEncoding("UTF-8");
				
		//2.
		
		String rez_adultcnt = req.getParameter("rez_adultcnt");
		String rez_kidcnt = req.getParameter("rez_kidcnt");
		String rez_toddlercnt = req.getParameter("rez_toddlercnt");
		String bankm_seq = req.getParameter("bank");
		String member_seq = req.getParameter("member_seq");
		String single_seq = req.getParameter("single_seq");
		String double_seq = req.getParameter("double_seq");
		
		FlightrezDAO dao = new FlightrezDAO();
		
		FlightrezDTO dto = new FlightrezDTO();
		
		
			dto.setRez_adultcnt(rez_adultcnt);
			dto.setRez_kidcnt(rez_kidcnt);
			dto.setRez_toddlercnt(rez_toddlercnt);
			dto.setBankm_seq(bankm_seq);
			dto.setMember_seq(member_seq);
			dto.setSingle_seq(single_seq);
			dto.setDouble_seq(double_seq);
			dto.setConfirm("0");
			dto.setDeposit_seq("1");
			dto.setRez_seq("rez.nextval");
			
			int result = dao.add(dto);
			//4. 
			req.setAttribute("result", result);
			
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/flight/flightrezok.jsp");

		dispatcher.forward(req, resp);
	}
}