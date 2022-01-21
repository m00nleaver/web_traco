package com.project.traco.flightticket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/flight.do")
public class Flight extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		//1.
		FlightDAO dao = new FlightDAO();
		ArrayList<FlightDTO> list = dao.list();
		
		//1.5
		Calendar now = Calendar.getInstance();
		for(FlightDTO dto : list) {
		dto.setAirplanp_takeoffdate( dto.getAirplanp_takeoffdate().substring(0,10));
		dto.setAirplanp_takeofftime(dto.getAirplanp_takeofftime().substring(11,16));
		dto.setSairport_name(dto.getSairport_name().substring(0,2));
		dto.setEairport_name(dto.getEairport_name().substring(0,2));
		if(dto.getAirplanl_name().indexOf("항공")>-1) {
			dto.setAirplanl_name(dto.getAirplanl_name().substring(0, dto.getAirplanl_name().length()-2));
		}
		
		}
		//2.
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher 
		= req.getRequestDispatcher("/WEB-INF/views/flight/flight.jsp");

		dispatcher.forward(req, resp);
	}
}
