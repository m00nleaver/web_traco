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

@WebServlet("/flightlist.do")
public class Flightlist extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputAddress1 = req.getParameter("inputAddress1");
		String inputAddress2 = req.getParameter("inputAddress2");
		String inputdateOne = req.getParameter("inputdateOne");
		String inputdateTwo = req.getParameter("inputdateTwo");
		String adult = req.getParameter("adult");
		String child = req.getParameter("child");
		String toddler = req.getParameter("toddler");
		String searchmode="n";
		
		
		
		if((inputAddress1==null
				&&inputAddress2==null
				&&inputdateOne==null
				&&inputdateTwo==null
				)||(inputAddress1.equals("")
						&&inputAddress2.equals("")
						&&inputdateOne.equals("")
						&&inputdateTwo.equals("")
						)) {
			searchmode="n";
		}else {
			searchmode="y";
		}
		
		//DTO > HashMap
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("inputAddress1", inputAddress1);
		map.put("inputAddress2", inputAddress2);
		map.put("inputdateOne", inputdateOne);
		map.put("inputdateTwo", inputdateTwo);
		map.put("adult", adult);
		map.put("child", child);
		map.put("toddler", toddler);
		map.put("searchmode", searchmode);
		
		//1.
		FlightDAO dao = new FlightDAO();
		/* FlightDAO dao2 = new FlightDAO(); */
		ArrayList<FlightDTO> list = dao.list(map);
		ArrayList<FlightDTO> list2 = dao.list2(map);
		//ArrayList<FlightDTO> listSecond = dao.listSecond(map);
		
		//1.5
		try {
			for(FlightDTO dto : list) {
				dto.setAirplanp_takeoffdate( dto.getAirplanp_takeoffdate().substring(0,10));
				dto.setAirplanp_takeofftime(dto.getAirplanp_takeofftime().substring(11,16));
				dto.setSairport_name(dto.getSairport_name().substring(0,2));
				dto.setEairport_name(dto.getEairport_name().substring(0,2));
				if(dto.getAirplanl_name().indexOf("항공")>-1) {
					dto.setAirplanl_name(dto.getAirplanl_name().substring(0, dto.getAirplanl_name().length()-2));
				}
				}
			for(FlightDTO dto : list2) {
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
				req.setAttribute("list2", list2);
				req.setAttribute("map", map);
				
		} catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher 
		= req.getRequestDispatcher("/WEB-INF/views/flight/flightlist.jsp");

		dispatcher.forward(req, resp);
	}
}