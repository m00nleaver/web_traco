package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/bedit.do")
public class Bedit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		
		AdminPDAO pdao = new AdminPDAO();
		
		AdminPDTO pdto = pdao.bget(seq);
		
		req.setAttribute("pdto", pdto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/bedit.jsp");

		dispatcher.forward(req, resp);
	}
}
