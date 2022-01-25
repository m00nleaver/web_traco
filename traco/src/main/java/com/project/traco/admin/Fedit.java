package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/fedit.do")
public class Fedit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq");
		String status = req.getParameter("status");
		
		AdminPDAO pdao = new AdminPDAO();
		ArrayList<AdminPDTO> alist = pdao.arealist(); //출발 도착 리스트
		ArrayList<AdminPDTO> blist = pdao.comlist(); //항공사리스트
		
		req.setAttribute("alist", alist);
		req.setAttribute("blist", blist);
		
		AdminPDTO pdto = pdao.fget(seq);
		System.out.println(status);
		req.setAttribute("pdto", pdto);
		req.setAttribute("status", status);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/fedit.jsp");

		dispatcher.forward(req, resp);
	}
}
