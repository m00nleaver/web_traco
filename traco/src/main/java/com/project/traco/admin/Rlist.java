package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/rlist.do")
public class Rlist extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminPDAO pdao = new AdminPDAO();
		
		ArrayList<AdminPDTO> rlist = pdao.rlist();
		
		req.setAttribute("rlist", rlist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/rlist.jsp");

		dispatcher.forward(req, resp);
	}
}
