package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/pdelok.do")
public class PdelOk extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		
		AdminPDAO pdao = new AdminPDAO();
		
		
		
	
		pdao.ipdel(seq);
		
		int result = pdao.delPackage(seq);
		System.out.println(result);
		
		req.setAttribute("result", result);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/pdelok.jsp");

		dispatcher.forward(req, resp);
	}
}
