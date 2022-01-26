package com.project.traco;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/main.do")
public class Main extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String banner_status = "사용중";
		String package_status = "y";
		String mini_status = "y";
		MainDAO dao = new MainDAO();
		ArrayList<MainDTO> banner = dao.banner(banner_status);
		
		ArrayList<MainDTO> toppackage = dao.toppackage(package_status);
		
		ArrayList<MainDTO> topmini = dao.topmini(mini_status);


		
		
		req.setAttribute("toppackage", toppackage);
		req.setAttribute("banner", banner);
		req.setAttribute("topmini", topmini);
			
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main.jsp");

		dispatcher.forward(req, resp);
	}
}