package com.project.traco.packagetour;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/packagetour/packagetotalsearch.do")
public class PackageTotalSearch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String region = req.getParameter("region");
		String mode = req.getParameter("mode");
		
		System.out.println(region + mode);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/packagetour/packagetotalsearch.jsp");

		dispatcher.forward(req, resp);
	}
}
