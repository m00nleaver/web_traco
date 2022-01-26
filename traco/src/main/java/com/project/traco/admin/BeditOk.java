package com.project.traco.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/beditok.do")
public class BeditOk extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String seq = req.getParameter("bseq");
		String name = req.getParameter("name");
		String file = req.getParameter("file");
		String url = req.getParameter("url");
		String ctg = req.getParameter("ctg");
		
		AdminPDTO pdto = new AdminPDTO();
		AdminPDAO pdao = new AdminPDAO();
		
		pdto.setBname(name);
		pdto.setBfile(file);
		pdto.setBurl(url);
		pdto.setBctg(ctg);
		pdto.setBseq(seq);
		
		int result = pdao.bedit(pdto);
		
		req.setAttribute("result", result);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/beditok.jsp");

		dispatcher.forward(req, resp);
	}
}
