package com.project.traco.minitour.jeju;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/minitour/jeju/jejumini.do")
public class Main extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/minitour/jeju/main.jsp");

		dispatcher.forward(req, resp);
	}
}

