package com.project.traco.flightticket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/flightrez.do")
public class Flightrez extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String single_seq = req.getParameter("single_seq");
		 String double_seq = req.getParameter("double_seq");
		
		 HashMap<String, String> map = new HashMap<String, String>(); 
		 map.put("single_seq", single_seq);
		 map.put("double_seq", double_seq);
		 
		 FlightDAO dao = new FlightDAO();
		 
		 ArrayList<FlightDTO> list3 = dao.list3(map);
		 try {
			 req.setAttribute("list3", list3);
		} catch (Exception e) {
			System.out.println("Flightrez().오류");
			e.printStackTrace();
			
		}
		 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/flight/flightrez.jsp");

		dispatcher.forward(req, resp);
	}
}
