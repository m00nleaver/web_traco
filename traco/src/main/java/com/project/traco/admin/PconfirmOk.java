package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/pconfirmok.do")
public class PconfirmOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String confirm = req.getParameter("confirm");
		String seq = req.getParameter("seq");
		
		AdminPDAO pdao = new AdminPDAO();
		
		int result = pdao.pconfirmEdit(seq);
		
		
		
		req.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/pconfirmok.jsp");

		dispatcher.forward(req, resp);
	}
}
