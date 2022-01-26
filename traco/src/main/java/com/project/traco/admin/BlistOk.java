package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/blistok.do")
public class BlistOk extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		
		String status = req.getParameter("status");
		String seq = req.getParameter("seq");
		
		AdminPDAO pdao = new AdminPDAO();
		AdminPDTO pdto = new AdminPDTO();
		
		pdto.setBseq(seq);
		pdto.setStatus(status);
		
		int result = pdao.editStatus(pdto);
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/blistok.jsp");

		dispatcher.forward(req, resp);
	}
}
