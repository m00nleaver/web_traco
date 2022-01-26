package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/cdel.do")
public class Cdel extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		
		//System.out.println(seq);
		AdminPDAO pdao = new AdminPDAO();
		
		AdminPDTO pdto = pdao.commentget(seq);
		
//		System.out.println(pdto.getTcseq());
//		System.out.println(pdto.getBseq());
//		
//		int tccresult = pdao.tccdel(pdto.getTcseq());
//		int tcresult = pdao.tcdel(pdto.getBseq());
//		int bresult = pdao.boarddel(seq);
//		
//		int result = tccresult +tcresult + bresult;
		
		//req.setAttribute("result", result);
		
		req.setAttribute("pdto", pdto);
		
	
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/cdel.jsp");

		dispatcher.forward(req, resp);
	}
}
