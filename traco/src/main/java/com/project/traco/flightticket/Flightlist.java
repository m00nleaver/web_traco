package com.project.traco.flightticket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

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
		
		
	
		
		RequestDispatcher dispatcher 
		= req.getRequestDispatcher("/WEB-INF/views/flight/flightlist.jsp");

		dispatcher.forward(req, resp);
	}
}