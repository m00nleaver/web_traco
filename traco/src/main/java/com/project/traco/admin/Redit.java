package com.project.traco.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/redit.do")
public class Redit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String seq = req.getParameter("seq"); //번호
		String kindname=req.getParameter("kind");
		String status = req.getParameter("status");
		
		AdminPDAO pdao = new AdminPDAO();
		ArrayList<AdminPDTO> mlist = pdao.manulist(); //제조사리스트
		ArrayList<AdminPDTO> flist = pdao.fuellist(); //연료리스트
		ArrayList<AdminPDTO> klist = pdao.kindlist(); //크기리스트
		
		AdminPDTO pdto = pdao.rget(seq);
		
		
		req.setAttribute("pdto", pdto);
 		req.setAttribute("klist", klist);
		req.setAttribute("mlist", mlist);
		req.setAttribute("flist", flist);
		req.setAttribute("kindname", kindname);
		req.setAttribute("status", status);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/admin/redit.jsp");

		dispatcher.forward(req, resp);
	}
}
